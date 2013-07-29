using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Xml.Serialization;
using Financiera.WebService.Servidor.DataSetBancaTableAdapters;

namespace Financiera.WebService.Servidor
{
    /// <summary>
    /// Descripción breve de ServicioBanca
    /// </summary>
    [WebService(Namespace = "http://financiera.dsd.net/banca/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class ServicioBanca : System.Web.Services.WebService
    {
        [WebMethod]
        public UsuarioType autenticar(String codigo, String claveweb)
        {
            UsuarioTableAdapter UsuarioTa = new UsuarioTableAdapter();
            DataSetBanca.UsuarioDataTable UsuarioDt = UsuarioTa.ConsultarUsuarioPorCredencial(codigo, claveweb);
            if (UsuarioDt.Rows.Count > 0)
            {
                UsuarioType usuarioType = new UsuarioType();
                usuarioType.usuarioId = Int32.Parse(UsuarioDt.Rows[0]["usuario_id"].ToString());
                usuarioType.codigo = UsuarioDt.Rows[0]["codigo"].ToString();
                return usuarioType;
            }
            else
            {
                return null;
            }
        }

        [WebMethod]
        public BancoType[] listarBancosPorUsuario(int usuarioId)
        {
            System.Diagnostics.Debug.WriteLine(usuarioId);
            BancoTableAdapter BancoTa = new BancoTableAdapter();
            DataSetBanca.BancoDataTable BancoDt = BancoTa.ConsultarBancosPorUsuario(usuarioId);
            if (BancoDt.Rows.Count > 0)
            {
                List<BancoType> BancoList = new List<BancoType>();
                foreach (DataRow row in BancoDt.Rows)
                {
                    BancoType BancoType = new BancoType();
                    BancoType.bancoId = Int32.Parse(row["banco_id"].ToString());
                    BancoType.nombre = row["nombre"].ToString();
                    BancoList.Add(BancoType);
                }
                return BancoList.ToArray();
            }
            else
            {
                return null;
            }
        }

        [WebMethod]
        public CuentaType[] listarCuentasPorUsuarioBanco(int usuarioId, int bancoId)
        {
            CuentaTableAdapter CuentaTa = new CuentaTableAdapter();
            DataSetBanca.CuentaDataTable CuentaDt = CuentaTa.ConsultarCuentasPorUsuarioBanco(usuarioId, bancoId);
            if (CuentaDt.Rows.Count > 0)
            {
                List<CuentaType> CuentaList = new List<CuentaType>();
                foreach (DataRow row in CuentaDt.Rows)
                {
                    CuentaType CuentaType = new CuentaType();
                    CuentaType.cuentaId = Int32.Parse(row["cuenta_id"].ToString());
                    CuentaType.numero = row["numero"].ToString();
                    CuentaList.Add(CuentaType);
                }
                return CuentaList.ToArray();
            }
            else
            {
                return null;
            }
        }
    }

    [XmlRoot(ElementName = "usuario")]
    public class UsuarioType
    {
        private int usuarioIdVal;
        private String codigoVal;

        public UsuarioType()
        {
        }

        public int usuarioId
        {
            get { return usuarioIdVal; }
            set { usuarioIdVal = value; }
        }

        public string codigo
        {
            get { return codigoVal; }
            set { codigoVal = value; }
        }
    }

    [XmlRoot(ElementName = "banco")]
    public class BancoType
    {
        private int bancoIdVal;
        private String nombreVal;

        public BancoType()
        {
        }

        public int bancoId
        {
            get { return bancoIdVal; }
            set { bancoIdVal = value; }
        }

        public string nombre
        {
            get { return nombreVal; }
            set { nombreVal = value; }
        }
    }


    [XmlRoot(ElementName = "cuenta")]
    public class CuentaType
    {
        private int cuentaIdVal;
        private String numeroVal;

        public CuentaType()
        {
        }

        public int cuentaId
        {
            get { return cuentaIdVal; }
            set { cuentaIdVal = value; }
        }

        public string numero
        {
            get { return numeroVal; }
            set { numeroVal = value; }
        }
    }
}
