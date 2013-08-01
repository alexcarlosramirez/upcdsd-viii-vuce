<?php
include_once("clases/cEntidad.php");

//consulta todos los procesados
$objentidad = new cEntidad;
$consulta = $objentidad->consultar();

//muestra los datos consultados
//haremos uso de tabla para tabular los resultados
?>
<table align="center">
	<thead>
		<tr>
			<th>Nro.REGISTRO</th>
			<th>Nro.SUCE</th>
			<th>PRODUCTO</th>
			<th>ESTADO</th>
			<th>NRO.EXPEDIENTE</th>
		</tr>
	</thead>

	<tbody>
		<?php
		while($row=mysql_fetch_array($consulta))
		{
			echo "<tr>";
			//mediante el evento onclick llamaremos a la funcion PedirDatos(), la cual tiene como parametro
			//de entrada el ID del procesado
			echo "<th><a onclick=\"pedirDatos('".$row['id_expediente']."')\">".$row['id_expediente']."</a></th>";
			echo "<td>".$row['nu_suce']."</td>";
			echo "<td>".$row['no_producto']."</td>";
			echo "<td>".$row['l_estado_pago']."</td>";
			echo "<td>".$row['nu_expediente']."</td>";
			echo "</tr>";
		}
		?>
	</tbody>
</table>