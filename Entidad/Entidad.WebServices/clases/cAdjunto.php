<?php
//implementamos la clase Adjunto
class cAdjunto
{
  public $idExpediente;
  public $tipo; //1: adjunto de la SUCE, 2: Adjunto del DR
  public $nombreArchivo;
  public $adjunto;

  public function cAdjunto()
  {
  }

  public function llenar($params)
  {
    $this->tipo = 1;
    $this->nombreArchivo = $params->nombreArchivo;
    $this->adjunto = $params->adjunto;
  }

  public function insertar($db)
  {
    try
    {
      $null = NULL;
      $stmt = $db->prepare("insert into t_adjunto (id_expediente, tipo, no_archivo, archivo) values (?, ?, ?, ?)");
      $stmt->bind_param("iisb",$p1,$p2,$p3,$p4); //iisb corresponde a los tipos de variable: Integer, Integer, String, Blob
      $p1 = $this->idExpediente;
      $p2 = $this->tipo;
      $p3 = $this->nombreArchivo;
      $p4 = $null;
      $stmt->send_long_data(3, $this->adjunto);
      $stmt->execute();
      $stmt->close();
      return true;
    }
    catch (Exception $e)
    {
      error_log("Entidad.WebServices cAdjunto->insertar  failed: \n".$e);
      return null;
    }
  }
}
?>