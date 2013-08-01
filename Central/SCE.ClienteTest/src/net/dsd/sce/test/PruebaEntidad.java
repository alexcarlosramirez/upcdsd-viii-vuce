package net.dsd.sce.test;

import net.dsd.entidad.servicioentidad.ServicioEntidadStub;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.Dgs015ProductoType;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.Dgs015Type;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadFormatoRequest;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadFormatoRequestChoice_type0;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadResponse;

public class PruebaEntidad {

	public static void main(String[] args) {
		try {
			Dgs015ProductoType[] dgs015ProductoArray = new Dgs015ProductoType[2];

			Dgs015ProductoType dgs015Producto = new Dgs015ProductoType();
			dgs015Producto.setSecuenciaProducto(1);
			dgs015Producto.setNombre("PRUEBA 1");
			dgs015Producto.setPartidaArancelaria("1234567890");
			dgs015Producto.setCantidad(1);
			dgs015Producto.setEnvase("ENVASE 1");
			dgs015ProductoArray[0] = dgs015Producto;

			dgs015Producto = new Dgs015ProductoType();
			dgs015Producto.setSecuenciaProducto(2);
			dgs015Producto.setNombre("PRUEBA 2");
			dgs015Producto.setPartidaArancelaria("1234567891");
			dgs015Producto.setCantidad(1);
			dgs015Producto.setEnvase("ENVASE 2");
			dgs015ProductoArray[1] = dgs015Producto;

			Dgs015Type dgs015 = new Dgs015Type();
			dgs015.setTipoProducto(1);
			dgs015.setListaProducto(dgs015ProductoArray);

			EntidadFormatoRequestChoice_type0 x = new EntidadFormatoRequestChoice_type0();
			x.setFormatoDgs015(dgs015);

			EntidadFormatoRequest transmitirOrdenRequest = new EntidadFormatoRequest();
			transmitirOrdenRequest.setFormato("DGS015");
			transmitirOrdenRequest.setSuce(2013001003);
			transmitirOrdenRequest.setOrden(2013002003);
			transmitirOrdenRequest.setFormato("DGS015");
			transmitirOrdenRequest.setEntidadFormatoRequestChoice_type0(x);
			transmitirOrdenRequest.setRucUsuarioSolicitante("45114941");
			transmitirOrdenRequest.setEstadoPago("S");

			ServicioEntidadStub stup = new ServicioEntidadStub();
			EntidadResponse res = stup.registrarSuce(transmitirOrdenRequest);
			System.out.println(res.getCodigo());
			System.out.println(res.getTexto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
