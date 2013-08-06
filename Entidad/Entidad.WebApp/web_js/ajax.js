function objetoAjax() {
	var xmlhttp = false;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
		}
	}
	if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}

function enviarDatosFormato() {
	// donde se mostrará lo resultados
	divResultado = document.getElementById('resultado');
	divFormulario = document.getElementById('formulario');
	divResultado.innerHTML = '<div class="centro"><img class="animacion" src="././web_imagenes/anim.gif"></div>';
	// instanciamos el objetoAjax
	ajax = objetoAjax();

	// valores de las cajas de texto
  var nu_operacion = document.frmExpediente.nu_operacion.value;
  var id_expediente = document.frmExpediente.id_expediente.value;
  var nu_suce = document.frmExpediente.nu_suce.value;
  var nu_orden = document.frmExpediente.nu_orden.value;
  var l_estado_pago = document.frmExpediente.l_estado_pago.value;
  var nu_expediente = document.frmExpediente.nu_expediente.value;
  var nu_dr_entidad = document.frmExpediente.nu_dr_entidad.value;

	// usando del medoto POST
	// archivo que realizará la operacion ->actualizacion.php
	ajax.open("POST", "actualizacion.php");
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar los nuevos registros en esta capa
			divResultado.innerHTML = ajax.responseText;
			// una vez actualizacion ocultamos formulario
			divFormulario.style.display = "none";
		}
	}

	// muy importante este encabezado ya que hacemos uso de un formulario
  if (nu_operacion == "1") {
    alert("ext" + nu_operacion);
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    ajax.send(
      "nu_operacion=" + nu_operacion +
      "&id_expediente=" + id_expediente +
      "&nu_suce=" + nu_suce +
      "&nu_orden=" + nu_orden +
      "&l_estado_pago=" + l_estado_pago +
      "&nu_expediente=" + nu_expediente +
      "&nu_expediente=" + nu_expediente);
  } else {
    alert(nu_operacion);
    var file = document.getElementById('adjunto_dr').files[0];
    formData.append("adjunto_dr", file);

    ajax.setRequestHeader("Cache-Control", "no-cache");
    ajax.setRequestHeader("X-Requested-With", "XMLHttpRequest");
    ajax.setRequestHeader("Content-Type", "multipart/form-data");
    ajax.setRequestHeader("X-File-Name", file.fileName);
    ajax.setRequestHeader("X-File-Size", file.fileSize);
    ajax.setRequestHeader("X-File-Type", file.type);
    ajax.send(
      "nu_operacion=" + nu_operacion +
      "&id_expediente=" + id_expediente +
      "&nu_suce=" + nu_suce +
      "&nu_orden=" + nu_orden +
      "&l_estado_pago=" + l_estado_pago +
      "&nu_expediente=" + nu_expediente);
  }
	// enviando los valores

}

function pedirDatos(id_expediente, nu_operacion) {
	// donde se mostrará el formulario con los datos
	divFormulario = document.getElementById('formulario');

	// instanciamos el objetoAjax
	ajax = objetoAjax();
	// uso del medotod POST
	ajax.open("POST", "consulta_por_id.php");
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar resultados en esta capa
			f_agregar.style.display = "none";
			divFormulario.innerHTML = ajax.responseText
			divFormulario.style.display = "block";
		}
	}
	// como hacemos uso del metodo POST
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// enviando el codigo del empleado
	ajax.send("id_expediente=" + id_expediente + "&nu_operacion=" + nu_operacion);
}