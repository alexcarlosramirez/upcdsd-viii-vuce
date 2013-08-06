<?php
include_once('clases/cEntidad.php');
include_once('ws_cliente/ServicioCe.php');
//variables POST
print_r($_POST);

$nu_operacion=$_POST['nu_operacion'];
$id_expediente=$_POST['id_expediente'];
$nu_suce=$_POST['nu_suce'];
$nu_orden=$_POST['nu_orden'];
$l_estado_pago=$_POST['l_estado_pago'];
// Variables para la operacion del número de expediente
$nu_expediente=null;
// Variables para la operacion del número de dr
$nu_dr_entidad=null;
$adjuntoArchivo=null;
if ($nu_operacion == 1)
{
  $nu_expediente = $_POST['nu_expediente'];
}
else
{
  $nu_dr_entidad = $_POST['nu_dr_entidad'];
  $adjuntoArchivo = null;
}
// $nu_dr=null$_POST['nu_dr'];
// $nombreArchivo=null;
// $adjuntoArchivo=null;

sleep(2);
//actualiza los datos del registro
$objExpediente = new cEntidad;
$resultado = false;
$mensaje = "";

switch ($nu_operacion)
{
    case 1:
      $resultado = $objExpediente->actualizar($id_expediente,$nu_expediente);
      $mensaje = "Expediente: <span class=\"Estilo5\">".$nu_expediente."</span> - Operacion: Actualizar";
      break;
    case 2:
      $resultado = $objExpediente->actualizar_dr($id_expediente,$nu_dr_entidad,"E");
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr_entidad." - Operacion: Aprobar";
      break;
    case 3:
      $resultado = $objExpediente->actualizar_dr($id_expediente,$nu_dr_entidad,"F");
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr_entidad."</span> - Operacion: Denegar";
      break;
}

if ($resultado==true)
{
	echo "<div class=\"centro\"><p class=\".Estilo8\">".$mensaje." - Estado: Exito</div>";
  //transmision
  $cliente = new ServicioCeCliente;
  switch ($nu_operacion)
  {
    case 1:
      $resultado = $cliente->enviarNroExpediente("DGS015", $nu_suce, $nu_expediente);
      $mensaje = "Expediente: <span class=\"Estilo5\">".$nu_expediente."</span> - Operacion: Transmisi&oacute;n";
      break;
    case 2:
      $resultado = $cliente->enviarDrAprobacion("DGS015", $nu_suce, $nu_dr_entidad, $nombreArchivo, $adjuntoArchivo);
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr." - Operacion: Transmisi&oacute;n";
      break;
    case 3:
      $resultado = $cliente->enviarDrDenegacion("DGS015", $nu_suce, $nu_dr_entidad, $nombreArchivo, $adjuntoArchivo);
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr."</span> - Operacion: Transmisi&oacute;n";
      break;
  }
 
  if ($resultado)
  {
    echo "<div class=\"centro\"><p class=\".Estilo8\">".$mensaje." - Estado: Exito</div>";
  } else {
    echo "<div class=\"centro\"><p class=\".Estilo8\">".$mensaje." - Estado: Error</div>";
  }
}
else
{
	echo "<div class=\"centro\"><p class=\".Estilo8\">".$mensaje." - Estado: Error</div>";
}
include('consulta.php');
?>