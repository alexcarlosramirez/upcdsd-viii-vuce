using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Financiera.WebApp.ServicioBanca;

namespace Financiera.WebApp.asp_cuenta
{
    public partial class ModalidadPago : System.Web.UI.Page
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
                CargarBancos();
            }
        }

        protected void SeleccionBancoDdl_SelectedIndexChanged(object sender, EventArgs e)
        {
            string codigoEmpresa = Session["CodigoEmpresa"].ToString();
            int bancoId = Int32.Parse(SeleccionBancoDdl.SelectedValue);
            ServicioBancaSoapClient ServicioBanca = new ServicioBancaSoapClient();
            CuentaType[] CuentaTypeArray = ServicioBanca.listarCuentasPorUsuarioBanco(codigoEmpresa, bancoId);
            SeleccionCuentaDdl.DataSource = CuentaTypeArray;
            SeleccionCuentaDdl.DataTextField = "numero";
            SeleccionCuentaDdl.DataValueField = "cuentaId";
            SeleccionCuentaDdl.DataBind();
        }

        protected void PagarBtn_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/asp_cuenta/Confirmar.aspx");
        }

        //-----------------------

        private void ConfigurarMaster()
        {
            Label lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelCuentaLbl");
            lbl.CssClass = "Navegador Terminado";
            lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelPagoLbl");
            lbl.CssClass = "Navegador Seleccionado";
            lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelConfirmacion");
            lbl.CssClass = "Navegador Elemento";
        }

        private void ConfigurarPagina()
        {
            CdaTxt.Text = Session["CdaPorPagar"].ToString();
            MontoPagoTxt.Text = Session["MontoPorPagar"].ToString();
            FechaGenTxt.Text = Session["FechaGenPorPagar"].ToString();
        }

        private void CargarBancos()
        {
            ServicioBancaSoapClient ServicioBanca = new ServicioBancaSoapClient();
            BancoType[] BancoTypeArray = ServicioBanca.listarBancosPorUsuario(Session["CodigoEmpresa"].ToString());
            SeleccionBancoDdl.DataSource = BancoTypeArray;
            SeleccionBancoDdl.DataTextField = "nombre";
            SeleccionBancoDdl.DataValueField = "bancoId";
            SeleccionBancoDdl.DataBind();
            SeleccionBancoDdl.Items.Insert(0, "");
        }
    }
}
