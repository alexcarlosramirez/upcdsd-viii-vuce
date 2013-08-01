<?php
include('conexion.php');
?>
<form id="form1" name="form1" method="get" action="expediente_server.php">
  <table width="329" border="1">
    <tr>
      <td colspan="3">ASIGNACIÓN DE EXPEDIENTE</td>
    </tr>
    <tr>
      <td width="114">SUCE</td>
      <td width="6">:</td>
      <td width="169"><label for="textfield"></label>
      <input type="text" name="nu_suce" id="textfield" /></td>
    </tr>
    <tr>
      <td>Producto</td>
      <td>:</td>
      <td><label for="textfield2"></label>
      <input type="text" name="no_producto" id="textfield2" /></td>
    </tr>
    <tr>
      <td>Estado</td>
      <td>:</td>
      <td><label for="textfield3"></label>
      <input type="text" name="l_estado" id="textfield3" /></td>
    </tr>
    <tr>
      <td>Nro Expediente</td>
      <td>:</td>
      <td><label for="textfield4"></label>
      <input type="text" name="nu_expediente" id="textfield4" /></td>
    </tr>
    <tr>
      <td colspan="3"><input type="submit" name="button" id="button" value="Enviar" /></td>
    </tr>
  </table>
</form>









<?php
$db = new ConSQL();
$db->Conectar();
$operando1='666';
$operando2='prod6';
$operando3='n';
$operando4='66-1';
//$nombre = $_POST['nombre'];

$db->Consulta("INSERT INTO t_expediente(nu_suce,no_pruducto,l_estado_pago,nu_expediente) VALUES('$operando1','$operando2','$operando3','$operando4')");
?>