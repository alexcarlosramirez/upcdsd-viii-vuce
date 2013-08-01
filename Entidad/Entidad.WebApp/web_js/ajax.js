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

	// valores de las cajas de texto
	id_expediente = document.frmempleado.id_expediente.value;
	nu_suce = document.frmempleado.nu_suce.value;
	nu_orden = document.frmempleado.nu_orden.value;
	l_estado_pago = document.frmempleado.l_estado_pago.value;
	nu_expediente = document.frmempleado.nu_expediente.value;

	// suel=document.frmempleado.sueldo.value;

	// instanciamos el objetoAjax
	ajax = objetoAjax();
	// usando del medoto POST
	// archivo que realizará la operacion ->actualizacion.php
	ajax.open("POST", "actualizacion.php", true);
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar los nuevos registros en esta capa
			divResultado.innerHTML = ajax.responseText
			// una vez actualizacion ocultamos formulario
			divFormulario.style.display = "none";

		}
	}
	// muy importante este encabezado ya que hacemos uso de un formulario
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// enviando los valores

	ajax.send("id_expediente=" + id_expediente + "&nu_suce=" + nu_suce
			+ "&nu_orden=" + nu_orden + "&l_estado_pago=" + l_estado_pago
			+ "&nu_expediente=" + nu_expediente)
}

function pedirDatos(id_expediente) {
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
	ajax.send("id_expediente=" + id_expediente)
}
function pedirDatosAgregar() {
	// donde se mostrará el formulario con los datos
	divFormulario = document.getElementById('f_agregar');
	// instanciamos el objetoAjax
	ajax = objetoAjax();
	// uso del medotod POST
	ajax.open("POST", "agregar.php");
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar resultados en esta capa
			formulario.style.display = "none";
			divFormulario.innerHTML = ajax.responseText
			divFormulario.style.display = "block";
		}
	}
	// como hacemos uso del metodo POST
	// ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	// enviando el codigo del empleado
	ajax.send()
}
function enviarDatosProcesado() {
	// donde se mostrará lo resultados
	divResultado = document.getElementById('resultado');
	divFormulario = document.getElementById('formulario');
	divResultado.innerHTML = '<img src="././web_imagenes/anim.gif">';

	// valores de las cajas de texto
	no_fiscalia = document.frmempleado.no_fiscalia.value;
	fe_hora = document.frmempleado.fe_hora.value;
	no_procesado = document.frmempleado.no_procesado.value;
	co_dni = document.frmempleado.co_dni.value;
	tx_situacion = document.frmempleado.tx_situacion.value;
	fe_ho_resolucion = document.frmempleado.fe_ho_resolucion.value;
	tx_delito = document.frmempleado.tx_delito.value;
	l_activo = document.frmempleado.l_activo.value;
	no_juez = document.frmempleado.no_juez.value;

	// suel=document.frmempleado.sueldo.value;

	// instanciamos el objetoAjax
	ajax = objetoAjax();
	// usando del medoto POST
	// archivo que realizará la operacion ->actualizacion.php
	ajax.open("POST", "agregado.php", true);
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar los nuevos registros en esta capa
			divResultado.innerHTML = ajax.responseText
			// una vez actualizacion ocultamos formulario
			divFormulario.style.display = "none";

		}
	}
	// muy importante este encabezado ya que hacemos uso de un formulario
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// enviando los valores

	ajax.send("&no_fiscalia=" + no_fiscalia + "&fe_hora=" + fe_hora
			+ "&no_procesado=" + no_procesado + "&co_dni=" + co_dni
			+ "&tx_situacion=" + tx_situacion + "&fe_ho_resolucion="
			+ fe_ho_resolucion + "&tx_delito=" + tx_delito + "&l_activo="
			+ l_activo + "&no_juez=" + no_juez)
}
function pedirDatosJuez() {
	// donde se mostrará el formulario con los datos
	divFormulario = document.getElementById('f_juez');
	// instanciamos el objetoAjax
	ajax = objetoAjax();
	// uso del medotod POST
	ajax.open("POST", "turno_juez.php");
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar resultados en esta capa
			formulario.style.display = "none";
			divFormulario.innerHTML = ajax.responseText
			divFormulario.style.display = "block";
		}
	}
	// como hacemos uso del metodo POST
	// ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	// enviando el codigo del empleado
	ajax.send()
}
function enviarDatosJuez() {
	// donde se mostrará lo resultados
	divResultado = document.getElementById('resultado');
	divFormulario = document.getElementById('formulario');
	divFormulario = document.getElementById('f_juez');
	divResultado.innerHTML = '<img src="././web_imagenes/anim.gif">';

	// valores de las cajas de texto
	co_juez = document.frmjuez.co_juez.value;
	fe_programacion = document.frmjuez.fe_programacion.value;

	// instanciamos el objetoAjax
	ajax = objetoAjax();
	// usando del medoto POST
	// archivo que realizará la operacion ->actualizacion.php
	ajax.open("POST", "turno_juez_asignado.php", true);
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4) {
			// mostrar los nuevos registros en esta capa
			divResultado.innerHTML = ajax.responseText
			// una vez actualizacion ocultamos formulario
			divFormulario.style.display = "none";

		}
	}
	// muy importante este encabezado ya que hacemos uso de un formulario
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//enviando los valores

	ajax.send("&co_juez=" + co_juez + "&fe_programacion=" + fe_programacion)
}