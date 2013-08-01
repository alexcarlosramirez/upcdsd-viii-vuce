<?php
class ConSQL
{
	private $conexion;
	public function Conectar()
	{
		$this->conexion = mysql_connect("localhost:3306","root","root");
		if(!$this->conexion)
		{
			echo "No se ha podido conectar a la base de datos.";
		}
		else
		{
			mysql_select_db("sd_entidad",$this->conexion);
		}
	} 

	public function Consulta($sql)
	{
		$resultado = mysql_query($sql,$this->conexion); 
		if(!$resultado)
		{
			echo "Error en la base de datos: ".mysql_error();
			exit;
		}
		return $resultado;
	}
}
?>