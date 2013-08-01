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
		$id_expediente=$_POST['id_expediente'];

		$objentidad = new cEntidad;
		$consulta = $objentidad->consultarid($id_expediente);

		$row = mysql_fetch_array($consulta);

		//valores de las consultas
		//$co_registro=$row['co_registro'];
		$id_expediente=$row['id_expediente'];
		$nu_suce=$row['nu_suce'];
		$no_producto=$row['no_producto'];
		$l_estado_pago=$row['l_estado_pago'];
		$nu_expediente=$row['nu_expediente'];

		//muestra los datos consultados en los campos del formulario
		?>
		<form name="frmempleado" action="" onsubmit="enviarDatosFormato(); return false">
			<p>
				<input name="id_expediente" type="hidden" value="<?php echo $id_expediente; ?>" />
			</p>
			<table align="center">
				<tbody>
					<tr>
						<td style="width: 54%">Nro.REGISTRO ENTIDAD</th>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input name="id_expediente1" type="text" disabled value="<?php echo $id_expediente; ?>" /></td>                
					</tr>
					<tr>
						<td style="width: 54%">SUCE</th>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input name="nu_suce" type="text" value="<?php echo $nu_suce; ?>" /></td>
					</tr>
					<tr>
						<td style="width: 54%">PRODUCTO</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input name="no_producto" type="text" value="<?php echo $no_producto; ?>" /></td>
					</tr>
					<tr>
						<td style="width: 54%">ESTADO</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input name="l_estado_pago" type="text" value="<?php echo $l_estado_pago; ?>" /></td> 
					</tr>
					<tr>
						<td style="width: 54%">Nro.EXPEDIENTE</td>
						<td style="width: 2%">:</td>
						<td style="width: 44%"><input name="nu_expediente" type="text" value="<?php echo $nu_expediente; ?>" /></td>
					</tr>
					<tr>
						<td colspan="4"><div align="center"><input type="submit" name="Submit" class="Estilo1" value="Actualizar" /></div></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>