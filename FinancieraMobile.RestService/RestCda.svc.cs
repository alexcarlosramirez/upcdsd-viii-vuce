using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace FinancieraMobile.RestService
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "RestCda" en el código, en svc y en el archivo de configuración a la vez.
    // NOTA: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione RestCda.svc o RestCda.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class RestCda : IRestCda
    {
        public CdaType generarCda(string paramCodigoEmpresa, double montopago)
        {
            return null;
        }

        public CdaType pagarCda(string paramCodigoEmpresa, string paramCda)
        {
            return null;
        }

        public CdaType[] listarCda(string paramCodigoEmpresa)
        {
            return null;
        }

        public CdaType consultarCda(string paramCodigoEmpresa, string paramCda)
        {
            return null;
        }
    }
}
