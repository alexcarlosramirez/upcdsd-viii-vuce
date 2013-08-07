package net.dsd.sce.test;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import net.dsd.sce.servicioce.ServicioCeStub;
import net.dsd.sce.servicioce.ServicioCeStub.Dgs015ProductoType;
import net.dsd.sce.servicioce.ServicioCeStub.Dgs015Type;
import net.dsd.sce.servicioce.ServicioCeStub.MensajeType;
import net.dsd.sce.servicioce.ServicioCeStub.TransmitirOrdenRequest;
import net.dsd.sce.servicioce.ServicioCeStub.TransmitirOrdenRequestChoice_type0;
import net.dsd.sce.servicioce.ServicioCeStub.TransmitirResponse;
import net.dsd.sce.servicioce.ServicioCeStub.UsuarioType;

public class PruebaCe {

	public static void main(String[] args) {
		try {
			//carga del binario
			File file = new File("c:/archivo.pptx");
			DataHandler dh = new DataHandler(new FileDataSource(file));
			//

			MensajeType mensaje = new MensajeType();
			mensaje.setFormato("DGS015");

			Dgs015ProductoType[] dgs015ProductoArray = new Dgs015ProductoType[2];

			Dgs015ProductoType dgs015Producto = new Dgs015ProductoType();
			dgs015Producto.setNombre("PRUEBA 1");
			dgs015Producto.setPartidaArancelaria("1234567890");
			dgs015Producto.setCantidad(1);
			dgs015Producto.setEnvase("ENVASE 1");
			dgs015ProductoArray[0] = dgs015Producto;

			dgs015Producto = new Dgs015ProductoType();
			dgs015Producto.setNombre("PRUEBA 2");
			dgs015Producto.setPartidaArancelaria("1234567891");
			dgs015Producto.setCantidad(1);
			dgs015Producto.setEnvase("ENVASE 2");
			dgs015ProductoArray[1] = dgs015Producto;

			Dgs015Type dgs015 = new Dgs015Type();
			dgs015.setTipoProducto(1);
			dgs015.setListaProducto(dgs015ProductoArray);

			TransmitirOrdenRequestChoice_type0 x = new TransmitirOrdenRequestChoice_type0();
			x.setFormatoDgs015(dgs015);

			UsuarioType usuarioType = new UsuarioType();
			//usuarioType.setRuc("20130801001");
			//usuarioType.setUsuarioSol("AMERICO");
			usuarioType.setRuc("10451149411");
			usuarioType.setUsuarioSol("45114941");

			TransmitirOrdenRequest transmitirOrdenRequest = new TransmitirOrdenRequest();
			transmitirOrdenRequest.setMensaje(mensaje);
			transmitirOrdenRequest.setTransmitirOrdenRequestChoice_type0(x);
			transmitirOrdenRequest.setUsuario(usuarioType);
			transmitirOrdenRequest.setNombreArchivoAdjunto(file.getName());
			transmitirOrdenRequest.setAdjunto(dh);

			ServicioCeStub stup = new ServicioCeStub();
			TransmitirResponse res = stup.transmitirOrden(transmitirOrdenRequest);
			System.out.println(res.getCodigo());
			System.out.println(res.getTexto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
