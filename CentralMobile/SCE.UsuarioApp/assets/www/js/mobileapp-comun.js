var cComun = {
	buscarListaEmpresas : function() {
		$.ajaxSetup({
			cache : false
		});
		$('#lstEntidad').empty();
		$.getJSON("http://172.16.100.51:8888/SCE.RestService/rest/listas/1", null, function(data){
		    $('#lstEntidad').append('<option value="0">Todos</option>');
			for (var i = 0; i < data.length; i++) {
			    var objeto = data[i];
			    $('#lstEntidad').append('<option  value="'+objeto.valor+'">'+objeto.texto+'</option>');
			}
			$('#lstEntidad').selectmenu("refresh", true);
		    $('#myPage').trigger('pagecreate');
		});
	}
};