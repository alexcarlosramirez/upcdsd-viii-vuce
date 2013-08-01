<?php
try
{
	$clienteSOAP = new SoapClient('http://localhost:8980/sd_entidad/entidad.wsdl');
	print_r("1.======================<br/>");
	$registrosInsertados = $clienteSOAP->insertaExpediente('456');
	print_r("2.======================<br/>");
	echo "Registros insertados: " . $registrosInsertados . "<br/>";
}
catch(Exception $ex)
{
	print_r("Exception: <br/>");
	print_r($ex);
}
?>
