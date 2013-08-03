<?php 
//referenciamos a los formatos
include_once("cDGS015.php");
include_once("cAdjunto.php");

//implementamos la clase Formato
class cFormato
{
  public $idExpediente;
  public $orden;
  public $suce;
  public $adjunto;
  public $rucUsuarioSolicitante;
  public $estadoPago;
  public $formatoEntidad;

  //constructor  
  public function cFormato()
  {
  }

  public function llenar($params)
  {
    $this->orden = ($params->orden);
    $this->suce = ($params->suce);
    $this->estadoPago = ($params->estadoPago);
    $this->rucUsuarioSolicitante = ($params->rucUsuarioSolicitante);
    //Guardamos el adjunto
    $this->adjunto = new cAdjunto;
    $this->adjunto->llenar($params->adjunto);
    //Declaramos el formato
    $classFormatoEntidad = "c".$params->formato;
    $elementFormatoEntidad = "formato".ucfirst(strtolower($params->formato));
    $this->formatoEntidad = new $classFormatoEntidad;
    $this->formatoEntidad->llenar($params->$elementFormatoEntidad);
  }

  public function insertar($db)
  {
    $resultado = $db->query("insert into t_expediente (nu_orden, nu_suce, l_estado_pago) values ($this->orden, $this->suce, '$this->estadoPago')");
    if ($resultado != null)
    {
      //recuperando el id_expediente generado
      if ($idExpedienteResultado = $db->query("select id_expediente from t_expediente where nu_suce = $this->suce"))
      {
        $row = $idExpedienteResultado->fetch_row();
        $this->idExpediente = $row[0];
        $idExpedienteResultado->close();
      }
      //Guardando el adjunto
      $this->adjunto->idExpediente = $this->idExpediente;
      $resultado = $this->adjunto->insertar($db);
      //Guardando el formato
      $this->formatoEntidad->idExpediente = $this->idExpediente;
      $resultado = $this->formatoEntidad->insertar($db);
    }
    return $resultado;
  }
}
?>
