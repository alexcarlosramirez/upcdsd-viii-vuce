<html>
	<head>
		<title>Listado de Registros SUCE</title>
		<script type="text/javascript" src="web_js/ajax.js"></script>
		<link rel="stylesheet" type="text/css" href="web_css/site.css" />
	</head>
	<body>
		<?php
		include_once("clases/cEntidad.php");
		//consulta los datos del empleado por su id
		$id_expediente=$_POST["id_expediente"];
		$nu_operacion=$_POST["nu_operacion"];

		$objentidad = new cEntidad;
		$consulta = $objentidad->consultarid($id_expediente);

		$row = mysql_fetch_array($consulta);

		//valores de las consultas
		$id_expediente=$row["id_expediente"];
		$nu_suce=$row["nu_suce"];
		$nu_orden=$row["nu_orden"];
		$l_estado_pago=$row["l_estado_pago"];
		$nu_expediente=$row["nu_expediente"];
		$nu_dr=$row["nu_dr"];
		$nu_dr_entidad=$row["nu_dr_entidad"];

		//muestra los datos consultados en los campos del formulario
		?>
		<form name="frmExpediente" action="" <?php if ($nu_operacion!=1) {echo "enctype=\"multipart/form-data\"";} ?> onsubmit="enviarDatosFormato(); return false">
			<p>
				<input id="id_expediente" name="id_expediente" type="hidden" value="<?php echo $id_expediente; ?>" />
				<input id="nu_operacion" name="nu_operacion" type="hidden" value="<?php echo $nu_operacion; ?>" />
			</p>
			<table align="center">
				<tbody>
					<tr>
						<td style="width: 54%">ORDEN</th>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input id="nu_orden" name="nu_orden" type="text" readonly="readonly" value="<?php echo $nu_orden; ?>" /></td>
					</tr>
					<tr>
						<td style="width: 54%">SUCE</th>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input id="nu_suce" name="nu_suce" type="text" readonly="readonly" value="<?php echo $nu_suce; ?>" /></td>
					</tr>
					<tr>
						<td style="width: 54%">ESTADO</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input id="l_estado_pago" name="l_estado_pago" type="text" readonly="readonly" value="<?php echo $l_estado_pago; ?>" /></td>
					</tr>
					<tr>
						<td style="width: 54%">Nro. EXPEDIENTE</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input id="nu_expediente" name="nu_expediente" type="text" <?php if ($nu_operacion!=1) {echo "readonly=\"readonly\"";} ?> value="<?php echo $nu_expediente; ?>" /></td>
					</tr>
					<tr <?php if ($nu_operacion==1) {echo "class=\"invisible\"";} ?>>
						<td style="width: 54%">Nro. DR</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input id="nu_dr_entidad" name="nu_dr_entidad" type="text" value="<?php echo $nu_dr_entidad; ?>" /><br/></td>
					</tr>
					<tr <?php if ($nu_operacion==1) {echo "class=\"invisible\"";} ?>>
						<td style="width: 54%">Adjunto del DR</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input id="adjunto_dr" name="adjunto_dr" type="file"/></td>
					</tr>
					<tr>
						<td colspan="4"><div align="center"><input type="submit" name="Submit" class="Estilo1" value="Actualizar" /></div></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>