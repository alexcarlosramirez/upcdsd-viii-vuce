var cFormato = {
	iniciar : function() {
		document.addEventListener("deviceready", cFormato.dispositivoListo, false);
	},
	dispositivoListo : function() {
		configurarFormato();
	},
	cancelar : function() {
		window.location.assign("file:///android_asset/www/sce_buscar.html");
	},
	guardar : function(pFormato) {
		alert(pFormato);
	}
};