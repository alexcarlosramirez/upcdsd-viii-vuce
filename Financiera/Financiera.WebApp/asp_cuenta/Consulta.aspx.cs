using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Financiera.WebApp.ServicioBanca;
using Financiera.WebApp.ServicioCda;

namespace Financiera.WebApp.asp_cuenta
{
    public partial class Consulta : System.Web.UI.Page
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

        protected void SeleccionCdaDdl_SelectedIndexChanged(object sender, EventArgs e)
        {
            DropDownList SeleccionCdaDdlTemp = (DropDownList) sender;
            String cda = SeleccionCdaDdlTemp.SelectedValue;
            int selectedIndex = SeleccionCdaDdlTemp.SelectedIndex;
            SeleccionCdaDdl.SelectedIndex = selectedIndex;
            //
            ServicioCdaSoapClient ServicioCdaCliente = new ServicioCdaSoapClient();
            CdaType CdaType = ServicioCdaCliente.consultarCda(cda);

            if (CdaType == null)
            {
                MensajeLbl.Text = "Seleccione un CDA";
            }
            else
            {
                MensajeLbl.Text = "";
                LlenarDatosCda(CdaType);
            }
        }

        protected void BorrarConsultaBtn_Click(object sender, EventArgs e)
        {
            LimpiarDatosCda();
        }

        protected void EntrarBtn_Click(object sender, EventArgs e)
        {
            Session["CdaPorPagar"] = SeleccionCdaDdl.SelectedValue;
            Session["MontoPorPagar"] = MontoPagoTxt.Text;
            Session["FechaGenPorPagar"] = FechaGenTxt.Text;
            Response.Redirect("~/asp_cuenta/ModalidadPago.aspx");
        }

        //-----------------------

        private void ConfigurarMaster()
        {
            Label lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelCuentaLbl");
            lbl.CssClass = "Navegador Seleccionado";
            lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelPagoLbl");
            lbl.CssClass = "Navegador Elemento";
            lbl = (Label)Master.Master.FindControl("PanelCph").FindControl("PanelConfirmacion");
            lbl.CssClass = "Navegador Elemento";
        }

        private void ConfigurarPagina()
        {
            ServicioCdaSoapClient ServicioCdaClient = new ServicioCdaSoapClient();
            CdaType[] CdaTypeArray = ServicioCdaClient.listarCda(Session["CodigoEmpresa"].ToString());
            if (CdaTypeArray.Length == 0)
            {
                MensajeLbl.Text = "No hay CDA para consultar";
            }
            else
            {
                PanelBusquedaCda.Visible = true;
                SeleccionCdaDdl.DataSource = CdaTypeArray;
                SeleccionCdaDdl.DataValueField = "cda";
                SeleccionCdaDdl.DataTextField = "cda";
                SeleccionCdaDdl.DataBind();
                SeleccionCdaDdl.Items.Insert(0, "");
            }
        }

        private void LlenarDatosCda(CdaType CdaType)
        {
            SeleccionCdaDdl.Enabled = false;
            MontoPagoTxt.Text = CdaType.montoPago.ToString();
            FechaGenTxt.Text = CdaType.fechaGeneracion.ToString("dd/MM/yyyy HH:mm");
            PanelDetalleCda.Visible = true;
        }

        private void LimpiarDatosCda()
        {
            SeleccionCdaDdl.Enabled = true;
            MontoPagoTxt.Text = "";
            FechaGenTxt.Text = "";
            PanelDetalleCda.Visible = false;
        }
    }
}
