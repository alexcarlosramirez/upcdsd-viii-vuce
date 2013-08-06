<?php 
//referenciamos la clase DBManager
include_once("././conexion/DBManager.php");

//implementamos la clase empleado
class cEntidad
{
	//constructor	
	function cEntidad()
	{
	}

	// consulta los empledos de la BD
	function consultar()
	{
		//creamos el objeto $con a partir de la clase DBManager
		$con = new DBManager;
		//usamos el metodo conectar para realizar la conexion
		if($con->conectar()==true)
		{
			$query = "select * from t_expediente order by id_expediente desc";
			$result = @mysql_query($query);
			if (!$result)
				return false;
			else
				return $result;
		}
	}

	//inserta un nuevo empleado en la base de datos
	// actualizar un nuevo empleado en la base de datos
	function actualizar($id_expediente,$nu_expediente)
	{
		$con = new DBManager;
		if($con->conectar()==true)
		{
			$query = "UPDATE t_expediente SET nu_expediente ='$nu_expediente' WHERE id_expediente=$id_expediente";
			$result = mysql_query($query);
			if (!$result)
				return false;
			else
				return true;
		}
	}

	//inserta un nuevo empleado en la base de datos
	// actualizar un nuevo empleado en la base de datos
	function actualizar_dr ($id_expediente,$nu_dr_entidad,$l_estado_pago)
	{
		$con = new DBManager;
		if($con->conectar()==true)
		{
			$query = "UPDATE t_expediente SET nu_dr_entidad ='$nu_dr_entidad', l_estado_pago = '$l_estado_pago' WHERE id_expediente=$id_expediente";
			$result = mysql_query($query);
			if (!$result)
				return false;
			else
				return true;
		}
	}

	// consulta empleado por su codigo
	function consultarid($id_expediente)
	{
		$con = new DBManager;
		if($con->conectar()==true)
		{
			$query = "SELECT * FROM t_expediente WHERE id_expediente=$id_expediente";
			$result = @mysql_query($query);
			if (!$result)
				return false;
			else
				return $result;
		}

	}
}
?>
