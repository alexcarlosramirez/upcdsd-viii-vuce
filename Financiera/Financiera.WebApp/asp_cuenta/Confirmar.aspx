<%@ Page Title="" Language="C#" MasterPageFile="~/asp_cuenta/NestedMasterPageCuenta.master" AutoEventWireup="true" CodeBehind="Confirmar.aspx.cs" Inherits="Financiera.WebApp.asp_cuenta.Confirmar" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadCuentaChp" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="PanelCuentaCph" runat="server">
    <table align="center">
        <tr>
            <td align="center" colspan="2"><asp:Label ID="MensajeLbl" runat="server" Text=""></asp:Label></td>
        </tr>
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
        <tr>
            <td colspan="2" align="center">
                <asp:Button ID="ConfirmarBtn" runat="server" Text="Confirmar Pago" onclick="ConfirmarBtn_Click"/>
                <asp:Button ID="RegresarBtn" runat="server" Text="Regresar" Visible="false" 
                    onclick="RegresarBtn_Click"/>
            </td>
        </tr>
    </table>
</asp:Content>
