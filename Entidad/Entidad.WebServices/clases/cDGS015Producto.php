<?php
//implementamos la clase DGS015Producto
class cDGS015Producto
{
  public $idDgs015;
  public $secuenciaProducto;
  public $nombre;
  public $partidaArancelaria;
  public $cantidad;
  public $envase;

  //constructor  
  public function cDGS015Producto()
  {
  }

  public function llenar($params)
  {
    $this->secuenciaProducto = ($params->secuenciaProducto);
    $this->nombre = ($params->nombre);
    $this->partidaArancelaria = ($params->partidaArancelaria);
    $this->cantidad = ($params->cantidad);
    $this->envase = ($params->envase);
  }

  public function insertar($db)
  {
    $resultado = $db->query("insert into t_dgs015_producto (id_dgs015, secuencia_producto, no_producto,partida_arancelaria,qt_producto,envase) values ($this->idDgs015, $this->secuenciaProducto, '$this->nombre', '$this->partidaArancelaria', '$this->cantidad', '$this->envase')");
    return $resultado;
  }
}
?>
