<?php
//referenciamos a los detalles
include_once("cDGS015Producto.php");

//implementamos la clase DGS015
class cDGS015
{
  public $idDgs015;
  public $idExpediente;
  public $tipoProducto;
  public $listaProducto;

  //constructor  
  public function cDGS015()
  {
  }

  public function llenar($params)
  {
    $this->tipoProducto = ($params->tipoProducto);
    $this->listaProducto = array();
    foreach ($params->listaProducto as $i => $DGS015Producto)
    {
      $objDGS015Producto = new cDGS015Producto;
      $objDGS015Producto->llenar($DGS015Producto);
      array_push($this->listaProducto, $objDGS015Producto);
    }
  }

  public function insertar($db)
  {
    $resultado = $db->query("insert into t_dgs015 (id_expediente, nu_tipo_producto) values ($this->idExpediente, $this->tipoProducto)");
    if ($resultado != null)
    {
      //recuperando el id_dgs015 generado
      if ($idDgs015Resultado = $db->query("select id_dgs015 from t_dgs015 where id_expediente = $this->idExpediente"))
      {
        $row = $idDgs015Resultado->fetch_row();
        $this->idDgs015 = $row[0];
        $idDgs015Resultado->close();
      }
      //
      foreach ($this->listaProducto as $i => $Dgs015Producto)
      {
        $Dgs015Producto->idDgs015 = $this->idDgs015;
        $resultado = $Dgs015Producto->insertar($db);
        if ($resultado == null)
        {
          return null;
        }
      }
    }
    return $resultado;
  }
}
?>
