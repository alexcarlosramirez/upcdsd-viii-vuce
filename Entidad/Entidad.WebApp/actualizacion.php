<?php
include_once('clases/cEntidad.php');
//variables POST

$id_expediente=$_POST['id_expediente'];
$nu_suce=$_POST['nu_suce'];
$no_producto=$_POST['no_producto'];
$l_estado_pago=$_POST['l_estado_pago'];
$nu_expediente=$_POST['nu_expediente'];

//$suel=$_POST['sueldo'];

sleep(2);
//actualiza los datos del registro
$objempleado = new cEntidad;
if ($objempleado->actualizar($id_expediente,$nu_expediente)==true){
	echo "<div class=\"centro\"><p class=\".Estilo8\">Registro Nro. <span class=\"Estilo5\">".$id_expediente."</span> ACTUALIZADO</div>";
}
else{
	echo "No se pudo actualizar";
}
include('consulta.php');
?>