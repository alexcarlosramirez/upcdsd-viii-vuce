<?php
class ServicioCeCliente
{

  private $clienteSOAP;

  //constructor
  public function ServicioCeCliente()
  {
    $this->clienteSOAP = new SoapClient("http://localhost:8888/SCE/services/ServicioCe?wsdl");
  }

  function enviarNroExpediente($formato, $nu_suce, $nu_expediente)
  {
    try
    {
      $request = array(
                   "mensaje" => array("formato"=>"$formato", "suce"=>$nu_suce, "numeroExpediente"=>"$nu_expediente"),
                   "usuario" => array("ruc"=>"EXTC001","usuarioSol"=>"-")
                 );
      $resp = $this->clienteSOAP->transmitirNroExpediente($request);
      return $resp->codigo;
    }
    catch (Exception $e)
    {
      error_log("Entidad.WebApp ServicioCe->enviarNroExpediente result failed:\n$e");
      return $e;
    }
  }

  function enviarDrAprobacion($formato, $nu_suce, $dr_entidad, $nombreArchivo, $adjuntoArchivo)
  {
    try
    {
      $request = array(
                "mensaje" => array("formato"=>"$formato", "suce"=>$nu_suce, "drEntidad"=>$nu_dr),
                "usuario" => array("ruc"=>"EXTC001","usuarioSol"=>"-"),
                "tipoDr" => 1,
                "nombreArchivoAdjunto" => "$nombreArchivo",
                "adjuntoArchivo" => $adjuntoArchivo
                );
      $resp = $this->clienteSOAP->transmitirDr($request);
      return $resp->codigo;
    }
    catch (Exception $e)
    {
      error_log("Entidad.WebApp ServicioCe->enviarDrAprobacion result failed:\n$e");
      return $e;
    }
  }

  function enviarDrDenegacion($formato, $nu_suce, $dr_entidad, $nombreArchivo, $adjuntoArchivo)
  {
    try
    {
      $request = array(
                "mensaje" => array("formato"=>"$formato", "suce"=>$nu_suce, "drEntidad"=>$nu_dr),
                "usuario" => array("ruc"=>"EXTC001","usuarioSol"=>"-"),
                "tipoDr" => 2,
                "nombreArchivoAdjunto" => "$nombreArchivo",
                "adjuntoArchivo" => $adjuntoArchivo
                );
      $resp = $this->clienteSOAP->transmitirDr($request);
      return $resp->codigo;
    }
    catch (Exception $e)
    {
      error_log("Entidad.WebApp ServicioCe->enviarDrDenegacion result failed:\n$e");
      return $e;
    }
  }
}
?>