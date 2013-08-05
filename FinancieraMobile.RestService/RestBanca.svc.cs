using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using FinancieraMobile.RestService.ServicioBanca;
using FinancieraMobile.RestService.ServicioCda;

namespace FinancieraMobile.RestService
{
    public class RestBanca : IRestBanca
    {
        public UsuarioType autenticar(string paramNombreUsuario, string paramPasswod)
        {
            ServicioBancaSoapClient servicioBanca = new ServicioBancaSoapClient();
            ServicioBanca.UsuarioType wsUsuarioType = servicioBanca.autenticar(codigo: paramNombreUsuario, claveweb: paramPasswod);
            if (wsUsuarioType != null)
            {
                UsuarioType restUsuarioType = new UsuarioType();
                restUsuarioType.codigo = wsUsuarioType.codigo;
                return restUsuarioType;
            }
            else
            {
                return null;
            }
        }

        public BancoType[] listarBancosPorUsuario(int paramUsuarioId)
        {
            ServicioBancaSoapClient servicioBanca = new ServicioBancaSoapClient();
            ServicioBanca.BancoType[] wsBancoTypeArray = servicioBanca.listarBancosPorUsuario(usuarioId: paramUsuarioId);
            if (wsBancoTypeArray != null)
            {
                List<BancoType> bancoList = new List<BancoType>();
                foreach (ServicioBanca.BancoType wsBancoType in wsBancoTypeArray)
                {
                    BancoType bancoType = new BancoType();
                    bancoType.bancoId = wsBancoType.bancoId;
                    bancoType.nombre = wsBancoType.nombre;
                    bancoList.Add(bancoType);
                }
                return bancoList.ToArray();
            }
            else
            {
                return null;
            }
        }

        public CuentaType[] listarCuentasPorUsuarioBanco(int paramUsuarioId, int paramBancoId)
        {
            ServicioBancaSoapClient servicioBanca = new ServicioBancaSoapClient();
            ServicioBanca.CuentaType[] wsCuentaTypeArray = servicioBanca.listarCuentasPorUsuarioBanco(usuarioId: paramUsuarioId, bancoId: paramBancoId);
            if (wsCuentaTypeArray != null)
            {
                List<CuentaType> cuentaList = new List<CuentaType>();
                foreach (ServicioBanca.CuentaType wsCuentaType in wsCuentaTypeArray)
                {
                    CuentaType cuentaType = new CuentaType();
                    cuentaType.cuentaId = wsCuentaType.cuentaId;
                    cuentaType.numero = wsCuentaType.numero;
                    cuentaList.Add(cuentaType);
                }
                return cuentaList.ToArray();
            }
            else
            {
                return null;
            }
        }
    }
}

