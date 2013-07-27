<%@ Page Title="" Language="C#" MasterPageFile="~/SitePagoElectronico.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Financiera.WebApp.Default" %>
<%@ MasterType virtualPath="~/SitePagoElectronico.Master"%> 

<asp:Content ID="HeadDefaultCon" ContentPlaceHolderID="HeadCph" runat="server">
</asp:Content>
<asp:Content ID="PanelDefaultCon" ContentPlaceHolderID="PanelCph" runat="server">
    <table align="center">
        <tr>
            <td align="right">Usuario:</td><td><asp:TextBox ID="CodigoTxt" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td align="right">Clave:</td><td><asp:TextBox ID="ClaveTxt" runat="server" TextMode="Password"></asp:TextBox></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <asp:Button ID="EntrarBtn" runat="server" Text="Entrar" onclick="EntrarBtn_Click" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><asp:Label ID="MensajeLbl" runat="server" Text=""></asp:Label></td>
        </tr>
    </table>
</asp:Content>
