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
			<th style="width: 150px;">Nro. ORDEN</th>
			<th style="width: 150px;">Nro. SUCE</th>
			<th>ESTADO</th>
			<th style="width: 150px;">NRO.EXPEDIENTE</th>
			<th style="width: 150px;">DR SCE</th>
			<th style="width: 150px;">DR ENTIDAD</th>
			<th colspan="3">OPERACIONES</th>
		</tr>
	</thead>

	<tbody>
		<?php
		while($row=mysql_fetch_array($consulta))
		{
			echo "<tr>";
			echo "<td style=\"text-align: center;\">".$row['nu_orden']."</td>";
			echo "<td style=\"text-align: center;\">".$row['nu_suce']."</td>";
			echo "<td style=\"text-align: center;\">".$row['l_estado_pago']."</td>";
			echo "<td style=\"text-align: center;\">".$row['nu_expediente']."</td>";
			echo "<td style=\"text-align: center;\">".$row['nu_dr']."</td>";
			echo "<td style=\"text-align: center;\">".$row['nu_dr_entidad']."</td>";
      echo "<td><button class=\".boton_tabla\" type=\"button\" ".($row['nu_expediente'] == ""?"onclick=\"pedirDatos('".$row['id_expediente']."', 1)\"":"disabled=\"disabled\"").">Registrar Nro Expediente</button></td>";
      echo "<td><button class=\".boton_tabla\" type=\"button\" ".($row['nu_dr'] == "" && $row['nu_expediente'] != ""?"onclick=\"pedirDatos('".$row['id_expediente']."', 2)\"":"disabled=\"disabled\"").">Aprobar</button></td>";
      echo "<td><button class=\".boton_tabla\" type=\"button\" ".($row['nu_dr'] == "" && $row['nu_expediente'] != ""?"onclick=\"pedirDatos('".$row['id_expediente']."', 3)\"":"disabled=\"disabled\"").">Denegar</button></td>";
			echo "</tr>";
		}
		?>
	</tbody>
</table>