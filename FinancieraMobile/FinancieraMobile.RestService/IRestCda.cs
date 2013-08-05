using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.ServiceModel.Web;

namespace FinancieraMobile.RestService
{
    [ServiceContract]
    public interface IRestCda
    {
        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, UriTemplate = "users/{username}/bookmarks?format=json")]
        public CdaType generarCda(string paramCodigoEmpresa, double montopago);

        [OperationContract]
        [WebInvoke(Method = "POST", RequestFormat = WebMessageFormat.Json, UriTemplate = "users/{username}/bookmarks?format=json")]
        public CdaType pagarCda(string paramCodigoEmpresa, string paramCda);

        [OperationContract]
        [WebGet(UriTemplate = "usuarios/{paramCodigoEmpresa}/cda", RequestFormat = WebMessageFormat.Json)]
        public CdaType[] listarCda(string paramCodigoEmpresa);

        [OperationContract]
        [WebGet(UriTemplate = "usuarios/{paramCodigoEmpresa}/cda/{paramCda}/", RequestFormat = WebMessageFormat.Json)]
        public CdaType consultarCda(string paramCodigoEmpresa, String paramCda);
    }

    [DataContract]
    public class CdaType
    {
        private String cdaVal;
        private double montoPagoVal;
        private DateTime fechaGeneracionVal;
        private DateTime fechaPagoVal;

        [DataMember]
        public string cda
        {
            get { return cdaVal; }
            set { cdaVal = value; }
        }

        [DataMember]
        public double montoPago
        {
            get { return montoPagoVal; }
            set { montoPagoVal = value; }
        }

        [DataMember]
        public DateTime fechaGeneracion
        {
            get { return fechaGeneracionVal; }
            set { fechaGeneracionVal = value; }
        }

        [DataMember]
        public DateTime fechaPago
        {
            get { return fechaPagoVal; }
            set { fechaPagoVal = value; }
        }
    }
}
