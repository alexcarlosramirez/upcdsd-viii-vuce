using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Xml.Serialization;
using Financiera.WebService.Servidor.DataSetCdaTableAdapters;
using Financiera.WebService.Servidor.ServicioCe;

namespace Financiera.WebService.Servidor
{
    /// <summary>
    /// Descripción breve de ServicioCda
    /// </summary>
    [WebService(Namespace = "http://financiera.dsd.net/cda/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class ServicioCda : System.Web.Services.WebService
    {
        [WebMethod(MessageName = "GenerarCda")]
        public CdaType generarCda(double montopago)
        {
            String outCda;
            DateTime outFechaGeneracion;
            TimeSpan outHoraGeneracion;

            CdaQueriesTableAdapter dsFQTA = new CdaQueriesTableAdapter();
            int res = dsFQTA.usp_GeneraCda(new Decimal(montopago), out outCda, out outFechaGeneracion, out outHoraGeneracion);
            CdaType response = new CdaType();
            response.cda = outCda;
            response.fechaGeneracion = outFechaGeneracion.Add(outHoraGeneracion);
            return response;
        }

        [WebMethod(MessageName = "PagarCda")]
        public CdaType pagarCda(String cda)
        {
            DateTime outFechaPago;
            TimeSpan outHoraPago;
            double outMontoPago;

            CdaQueriesTableAdapter dsFQTA = new CdaQueriesTableAdapter();
            CdaType response = null;
            int res = dsFQTA.usp_PagaCda(cda, out outMontoPago, out outFechaPago, out outHoraPago);

            response = new CdaType();
            response.cda = cda;
            response.montoPago = outMontoPago;
            response.fechaPago = outFechaPago.Add(outHoraPago);

            ServicioCeClient ServicioCe = new ServicioCeClient();
            String texto = "";
            String codigo = ServicioCe.TransmitirPago(cda, response.montoPago, response.fechaPago, out texto);

            return response;
        }

        [WebMethod(MessageName = "ListarCda")]
        public CdaType[] listarCda()
        {
            CdaTableAdapter financieraQTA = new CdaTableAdapter();
            DataSetCda.CdaDataTable CdaDt = financieraQTA.ConsultarCdaPendientePago();

            List<CdaType> CdaTypeList = new List<CdaType>();
            foreach (DataRow row in CdaDt.Rows)
            {
                CdaType cdaType = new CdaType();
                cdaType.cda = row["cda"].ToString();
                cdaType.montoPago = Double.Parse(row["monto_pago"].ToString());
                CdaTypeList.Add(cdaType);
            }
            CdaType[] CdaTypeArray = CdaTypeList.ToArray();
            return CdaTypeArray;
        }

        [WebMethod(MessageName = "ConsultarCda")]
        public CdaType consultarCda(String cda)
        {
            CdaTableAdapter financieraQTA = new CdaTableAdapter();
            DataSetCda.CdaDataTable CdaDt = financieraQTA.ConsultarCdaPorCodigo(cda);

            CdaType cdaType = null;
            foreach (DataRow row in CdaDt.Rows)
            {
                cdaType = new CdaType();
                cdaType.cda = row["cda"].ToString();
                cdaType.montoPago = Double.Parse(row["monto_pago"].ToString());
                cdaType.fechaGeneracion = ((DateTime)row["fecha_gerenacion"]).Add((TimeSpan)row["hora_generacion"]);
            }
            return cdaType;
        }
    }

    [XmlRoot(ElementName = "cda")]
    public class CdaType
    {
        private String cdaVal;
        private double montoPagoVal;
        private DateTime fechaGeneracionVal;
        private DateTime fechaPagoVal;

        public CdaType()
        {
        }

        public string cda
        {
            get { return cdaVal; }
            set { cdaVal = value; }
        }

        public double montoPago
        {
            get { return montoPagoVal; }
            set { montoPagoVal = value; }
        }

        public DateTime fechaGeneracion
        {
            get { return fechaGeneracionVal; }
            set { fechaGeneracionVal = value; }
        }

        public DateTime fechaPago
        {
            get { return fechaPagoVal; }
            set { fechaPagoVal = value; }
        }
    }
}
