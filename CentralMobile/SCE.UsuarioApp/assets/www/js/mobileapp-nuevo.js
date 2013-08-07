var cNuevo = {
	iniciar : function() {
		document.addEventListener("deviceready", cNuevo.dispositivoListo, false);
	},
	dispositivoListo : function() {
		try {
			cComun.buscarListaEmpresas();
		} catch (e) {
			alert(e);
		}
	},
	buscarListaFormatos : function() {
		try {
			$.ajaxSetup({
				cache : false
			});
			var entidadId = $("#lstEntidad").val() == null?"0": $("#lstEntidad").val();

			$.getJSON("http://172.16.100.51:8888/SCE.RestService/rest/listas/2/"+entidadId, null, function(data){
				if (data.length > 0) {
					$('#lstFormatos').empty();
					for (var i = 0; i < data.length; i++) {
					    var objeto = data[i];
					    var strInicio = '<li>';
					    var strCheck  = '<input name="radio-choice-formato" id="radio-choice-v-'+i+'a" value="'+objeto.texto+'" type="radio">';
					    var strLabel  = '<label for="radio-choice-v-'+i+'a">'+objeto.texto+'</label>';
					    var strFin    = '</li>';
					    $('#lstFormatos').append(strInicio + strCheck + strLabel + strFin);
					}
				    $('#myPage').trigger('pagecreate');
				}
			});
		} catch (e) {
			alert(e);
		}
	},
	nuevaSolicitud : function() {
		var formato = $('input[name="radio-choice-formato"]:checked').val();
		var carpeta = formato.substring(0, 3);
		window.location.assign("formatos/" + carpeta + "/" + formato + ".html");
	}
};