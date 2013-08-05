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
    public interface IRestBanca
    {
        [OperationContract]
        [WebGet(UriTemplate = "/login/{paramNombreUsuario}?clave={paramPasswod}", RequestFormat = WebMessageFormat.Json)]
        public UsuarioType autenticar(string paramNombreUsuario, string paramPasswod);

        [OperationContract]
        [WebGet(UriTemplate = "usuarios/{string paramCodigoEmpresa}/bancos", RequestFormat = WebMessageFormat.Json)]
        public BancoType[] listarBancosPorUsuario(string paramCodigoEmpresa);

        [OperationContract]
        [WebGet(UriTemplate = "usuarios/{string paramCodigoEmpresa}/bancos/{paramBancoId}", RequestFormat = WebMessageFormat.Json)]
        public CuentaType[] listarCuentasPorUsuarioBanco(string paramCodigoEmpresa, int paramBancoId);
    }

    [DataContract]
    public class UsuarioType
    {
        private int usuarioIdVal;
        private string codigoVal;

        [DataMember]
        public int usuarioId
        {
            get { return usuarioIdVal; }
            set { usuarioIdVal = value; }
        }

        [DataMember]
        public string codigo
        {
            get { return codigoVal; }
            set { codigoVal = value; }
        }
    }

    [DataContract]
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

    [DataContract]
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
