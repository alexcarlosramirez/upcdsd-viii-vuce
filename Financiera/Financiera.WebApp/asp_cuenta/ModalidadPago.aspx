<%@ Page Title="" Language="C#" MasterPageFile="~/asp_cuenta/NestedMasterPageCuenta.master" AutoEventWireup="true" CodeBehind="ModalidadPago.aspx.cs" Inherits="Financiera.WebApp.asp_cuenta.ModalidadPago" %>
<asp:Content ID="HeadCuentaModalidadCon" ContentPlaceHolderID="HeadCuentaChp" runat="server">
</asp:Content>
<asp:Content ID="PanelCuentaModalidadCon" ContentPlaceHolderID="PanelCuentaCph" runat="server">
    <table align="center">
        <tr>
            <td align="center"><asp:Label ID="MensajeLbl" runat="server" Text=""></asp:Label></td>
        </tr>
        <tr>
            <td>
                <table style="width: 100%; border: solid 1px black;">
                    <tr>
                        <th align="right" style="width: 120px; height: 30px;" valign="middle">
                            CDA:
                        </th>
                        <td style="height: 30px;" valign="middle">
                            <asp:TextBox ID="CdaTxt" runat="server" Width="250px" ReadOnly="True"></asp:TextBox>
                        </td>
                    </tr>
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
                </table>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>
                <table style="width: 100%; border: solid 1px black;">
                    <tr>
                        <th align="center" style="height: 30px;" valign="middle">
                            Seleccione Banco y Cuenta:
                        </th>
                    </tr>
                    <tr>
                        <td style="height: 30px;" valign="middle">
                            <asp:DropDownList ID="SeleccionBancoDdl" runat="server" Width="150px" 
                                AutoPostBack="true" 
                                onselectedindexchanged="SeleccionBancoDdl_SelectedIndexChanged"></asp:DropDownList>
                            <asp:DropDownList ID="SeleccionCuentaDdl" runat="server" Width="250px"></asp:DropDownList>
                        </td>
                    </tr>
                    <tr>
                        <td align="center"><asp:Button ID="PagarBtn" runat="server" Text="Pagar CDA" 
                                onclick="PagarBtn_Click"/></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</asp:Content>
