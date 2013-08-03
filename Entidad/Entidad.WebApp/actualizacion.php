<?php
include_once('clases/cEntidad.php');
include_once('ws_cliente/ServicioCe.php');
//variables POST

$id_expediente=$_POST['id_expediente'];
$nu_suce=$_POST['nu_suce'];
$nu_orden=$_POST['nu_orden'];
$l_estado_pago=$_POST['l_estado_pago'];
$nu_operacion=$_POST['nu_operacion'];
// Variables para la operacion del número de expediente
$nu_expediente=$_POST['nu_expediente'];
// Variables para el número de expediente
$nu_dr=null$_POST['nu_dr'];
$nombreArchivo=null;
$adjuntoArchivo=null;

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
      $resultado = $objExpediente->aprobar($id_expediente,$nu_dr,$adjuntoArchivo);
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr." - Operacion: Aprobar";
      break;
    case 3:
      $resultado = $objExpediente->denegar($id_expediente,$nu_dr,$adjuntoArchivo);
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr."</span> - Operacion: Denegar";
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
      $resultado = $cliente->enviarDrAprobacion("DGS015", $nu_suce, $nu_dr, $nombreArchivo, $adjuntoArchivo);
      $mensaje = "DR: <span class=\"Estilo5\">".$nu_dr." - Operacion: Transmisi&oacute;n";
      break;
    case 3:
      $resultado = $cliente->enviarDrDenegacion("DGS015", $nu_suce, $nu_dr, $nombreArchivo, $adjuntoArchivo);
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