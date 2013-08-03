<?php
class ConSQL
{
  private $conexion;

  public function connect()
  {
    $this->conexion = new mysqli("localhost:3306","root","root","sd_entidad");
    if (mysqli_connect_errno())
    {
      error_log("Entidad.WebServices DBManager->connect failed: %s\n");
      exit();
    }
  }

  public function query($sql)
  {
    try
    {
      $result = $this->conexion->query($sql);
      if ($result == null)
      {
        $error = mysqli_error($this->conexion);
        error_log("Entidad.WebServices DBManager->query result failed:\n$sql\n$error");
      }
      return $result;
    }
    catch (Exception $e)
    {
      error_log("Entidad.WebServices DBManager->query  failed: \n".$e);
      return null;
    }
  }

  public function prepare($sql)
  {
    return $this->conexion->prepare($sql);
  }

  public function beginTransacction() {
    $this->conexion->autocommit(FALSE);
  }

  public function commit() {
    $this->conexion->commit();
    $this->conexion->autocommit(TRUE);
    $this->conexion->close();
  }

  public function rollback() {
    $this->conexion->rollback();
    $this->conexion->autocommit(TRUE);
    $this->conexion->close();
  }
}
?>