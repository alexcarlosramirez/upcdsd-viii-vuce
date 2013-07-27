using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Financiera.WebApp.ServicioCda;

namespace Financiera.WebApp.asp_cuenta
{
    public partial class Confirmar : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["UsuarioId"] == null)
            {
                Response.Redirect("~/Default.aspx");
            }
            else if (!IsPostBack)
            {
                ConfigurarMaster();
                ConfigurarPagina();
            }
        }

        //-----------------------

        private void ConfigurarMaster()
        {
            Label lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelCuentaLbl");
            lbl.CssClass = "Navegador Terminado";
            lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelPagoLbl");
            lbl.CssClass = "Navegador Terminado";
            lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelConfirmacion");
            lbl.CssClass = "Navegador Seleccionado";
        }

        private void ConfigurarPagina()
        {
            CdaTxt.Text = Session["CdaPorPagar"].ToString();
            MontoPagoTxt.Text = Session["MontoPorPagar"].ToString();
            FechaGenTxt.Text = Session["FechaGenPorPagar"].ToString();
        }

        protected void ConfirmarBtn_Click(object sender, EventArgs e)
        {
            ServicioCdaSoapClient ServicioCda = new ServicioCdaSoapClient();
            CdaType CdaType = ServicioCda.pagarCda(CdaTxt.Text);
            if (CdaType == null)
            {
                MensajeLbl.Text = "Ocurrió un Error al Procesar el pago";
            }
            else
            {
                MensajeLbl.Text = "Su pago se cargó correctamente.";
            }
        }
    }
}
