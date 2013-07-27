<%@ Page Title="" Language="C#" MasterPageFile="~/asp_cuenta/NestedMasterPageCuenta.master" AutoEventWireup="true" CodeBehind="Consulta.aspx.cs" Inherits="Financiera.WebApp.asp_cuenta.Consulta" %>
<%@ MasterType virtualPath="~/asp_cuenta/NestedMasterPageCuenta.master"%> 

<asp:Content ID="HeadCuentaConsultaCon" ContentPlaceHolderID="HeadCuentaChp" runat="server">
</asp:Content>

<asp:Content ID="PanelCuentaConsultaCon" ContentPlaceHolderID="PanelCuentaCph" runat="server">
    <table align="center">
        <tr>
            <td align="center"><asp:Label ID="MensajeLbl" runat="server" Text=""></asp:Label></td>
        </tr>
        <tr>
            <td>
                <asp:Panel ID="PanelBusquedaCda" runat="server" Visible="false">
                    <table style="width: 100%; border: solid 1px black;">
                        <tr>
                            <th align="right" style="width: 120px; height: 30px;" valign="middle">
                                Buscar CDA:
                            </th>
                            <td style="height: 30px;" valign="middle">
                                <asp:DropDownList ID="SeleccionCdaDdl" runat="server" Width="250px" 
                                    AutoPostBack="true" 
                                    onselectedindexchanged="SeleccionCdaDdl_SelectedIndexChanged"></asp:DropDownList>
                                <asp:Button ID="BorrarConsultaBtn" runat="server" Text="Borrar Búsqueda" onclick="BorrarConsultaBtn_Click" />
                            </td>
                        </tr>
                    </table>
                </asp:Panel>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>
                <asp:Panel ID="PanelDetalleCda" runat="server" Visible="false">
                    <table style="width: 100%; border: solid 1px black;">
                        <tr>
                            <th align="right" style="width: 120px; height: 30px;" valign="middle">
                                Monto a pagar:
                            </th>
                            <td style="height: 30px;" valign="middle">
                                <asp:TextBox ID="MontoPagoTxt" runat="server" Width="250px" ReadOnly="True"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <th align="right" style="width: 120px; height: 30px;" valign="middle">
                                Fecha de Gen.:
                            </th>
                            <td style="height: 30px;" valign="middle">
                                <asp:TextBox ID="FechaGenTxt" runat="server" Width="250px" ReadOnly="True"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><asp:Button ID="EntrarBtn" runat="server" Text="Pagar usando una Cuenta" onclick="EntrarBtn_Click" /></td>
                        </tr>
                    </table>
                </asp:Panel>
            </td>
        </tr>
    </table>
</asp:Content>
