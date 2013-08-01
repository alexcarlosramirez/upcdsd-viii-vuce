<?php
include_once('conexion/DBManager.php');
include_once("clases/cFormato.php");

if(!extension_loaded("soap"))
{
	dl("php_soap.dll");
}
 
ini_set("soap.wsdl_cache_enabled","0");
$server = new SoapServer("services/ServicioEntidad.wsdl");
 
function RegistrarSuce($params)
{
	$db = new ConSQL;
	$db->connect();

	$objFormato = new cFormato;
	$objFormato->llenar($params);
	$db->beginTransacction();
	$res = $objFormato->insertar($db);
	if ($res != null) {
		$db->commit();
		$msj = array("codigo"=>"OK", "texto"=>"Exito");
	} else {
		error_log("Entidad.WebServices ServicioEntidad->RegistrarSuce failed");
	  $db->rollback();
		$msj = array("codigo"=>"ERROR", "texto"=>"No se pudo insertar: ");
	}
	return $msj;
}
//	mysqli_close($con);
$server->AddFunction("RegistrarSuce");
$server->handle();
$server->addFunction(SOAP_FUNCTIONS_ALL);
?>
