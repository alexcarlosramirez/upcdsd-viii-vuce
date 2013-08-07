var cBandeja = {
	iniciar : function() {
		document.addEventListener("deviceready", cBandeja.dispositivoListo, false);
	},
	dispositivoListo : function() {
		cComun.buscarListaEmpresas();
		cBandeja.buscarListaSolicitudes();
	},
	buscarListaSolicitudes : function() {
		try {
			$.ajaxSetup({
				cache : false
			});
			var entidadId = $("#lstEntidad").val() == null?"0": $("#lstEntidad").val();
			var tipo = $("div[data-role='navbar']").find("a.ui-btn-active")[0].id.substring(12, 13);

			$.getJSON("http://172.16.100.51:8888/SCE.RestService/rest/bandejas/"+tipo+"/entidades/"+entidadId, null, function(data){
				if (data.length > 0) {
					$('#lstBandeja').empty();
				    $('#lstBandeja').listview('refresh');
					for (var i = 0; i < data.length; i++) {
					    var objeto = data[i];
					    var strInicio  = '<li><table style="width: 100%;">';
					    var strEstado  = '<tr><td rowspan="3" style="width: 25px;"><img src="img/estados/'+objeto.estado+'.png" /></td>';
					    var strNumero  = '';
					    var strBoton   = '<td rowspan="3" style="width: 25px;"><a class="ui-icon-nodisc" data-role="button" data-mini="true" data-theme="b" data-inline="true" data-icon="search" data-iconshadow="false" data-iconpos="notext" href="#" onclick="cBandeja.abrirSolicitud(\''+objeto.numero+'\',\''+objeto.formato+'\')"></a></td></tr>';
					    var strEntidad = '<tr><td>Entidad: '+objeto.entidad+' ('+objeto.formato+')</td></tr>';
					    var strFecha   = '<tr><td>Fecha: '+objeto.fechaRegistro+'</td></tr>';
					    var strFin     = '</table></li>';
					    if (objeto.etapaTramite == "O") {
					    	strNumero = '<td>ORDEN: '+objeto.numero+'</td>';
					    } else if (objeto.etapaTramite == "S") {
					    	strNumero = '<td>SUCE: '+objeto.numero+'</td>';
					    } else if (objeto.etapaTramite == "D") {
					    	strNumero = '<td>DR: '+objeto.numero+'</td>';
					    }
					    $('#lstBandeja').append(strInicio + strEstado + strNumero + strBoton + strEntidad + strFecha + strFin);
					    $('#lstBandeja').listview('refresh');
					}
				    $('#myPage').trigger('pagecreate');
				} else {
					$('#lstBandeja').empty();
					$('#lstBandeja').append('<li>No hay elementos que mostrar</li>');
				    $('#lstBandeja').listview('refresh');
				}
			});
		} catch (e) {
			alert(e);
		}
	},
	nuevaSolicitud : function () {
		var entidadId = $("#lstEntidad").val() == null?"0": $("#lstEntidad").val();
		window.localStorage.setItem("entidadId", entidadId);
		window.location.assign("sce_nuevo.html");
	},
	abrirSolicitud : function (pNumero, pFormato) {
		var carpeta = pFormato.substring(0, 3);
		window.localStorage.setItem("numero", pNumero);
		window.location.assign("formatos/" + carpeta + "/" + pFormato + ".html");
	}
};