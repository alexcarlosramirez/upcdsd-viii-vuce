<?php
include('conexion/DBManager.php');

if(!extension_loaded("soap"))
{
	dl("php_soap.dll");
}
 
ini_set("soap.wsdl_cache_enabled","0");
$server = new SoapServer("services/ServicioEntidad.wsdl");
 
function insertaExpediente($operando1)
{
	try
	{
		$db = new ConSQL();
		$db->Conectar();
		$msj="Probando";
		$consulta = $db->Consulta("INSERT INTO t_expediente (nu_suce) VALUES('451')");
		/*$consulta1 = $db->Consulta("SELECT * FROM t_expediente");
		$cuenta= mysql_num_rows($consulta1);

		if (!$consulta)
		{
			$msj="error de query:";
		}
		else
		{
			$msj="query ok:";
		}*/
		return $msj;
	}
	catch(Exception $e)
	{
		return "Exception".$e;
	}
}
//	mysqli_close($con);
$server->AddFunction("insertaExpediente");
$server->handle();
?>
