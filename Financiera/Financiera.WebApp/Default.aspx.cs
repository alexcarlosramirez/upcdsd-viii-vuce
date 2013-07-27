using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Financiera.WebApp.ServicioBanca;

namespace Financiera.WebApp
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void EntrarBtn_Click(object sender, EventArgs e)
        {
            ServicioBancaSoapClient SbWs = new ServicioBancaSoapClient();
            UsuarioType UsuarioType = SbWs.autenticar(CodigoTxt.Text,ClaveTxt.Text);

            if (UsuarioType == null)
            {
                MensajeLbl.Text = "Su usuario y/o contraseña son icorrectas";
            } else
            {
                Session["UsuarioId"] = UsuarioType.usuarioId;
                Session["UsuarioCodigo"] = UsuarioType.codigo;
                Response.Redirect("asp_cuenta/Consulta.aspx");
            }
        }
    }
}
