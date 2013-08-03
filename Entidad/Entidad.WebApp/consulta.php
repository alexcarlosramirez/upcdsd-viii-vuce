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
			<th style="width: 150px;">DR</th>
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
      if ($row['nu_expediente'] == "")
      {
        echo "<td><button class=\".boton_tabla\" type=\"button\" onclick=\"pedirDatos('".$row['id_expediente']."', 1)\">Registrar Nro Expediente</button></td>";
      }
      else {
        echo "<td><button class=\".boton_tabla\" type=\"button\" disabled=\"disabled\">Registrar Nro Expediente</button></td>";
      }
      if ($row['nu_dr'] == null)
      {
        echo "<td><button class=\".boton_tabla\" type=\"button\" onclick=\"pedirDatos('".$row['id_expediente']."', 2)\">Aprobar</button></td>";
        echo "<td><button class=\".boton_tabla\" type=\"button\" onclick=\"pedirDatos('".$row['id_expediente']."', 3)\">Denegar</button></td>";
      }
      else {
        echo "<td><button class=\".boton_tabla\" type=\"button\" disabled=\"disabled\">Aprobar</button></td>";
        echo "<td><button class=\".boton_tabla\" type=\"button\" disabled=\"disabled\">Denegar</button></td>";
      }
			echo "</tr>";
		}
		?>
	</tbody>
</table>