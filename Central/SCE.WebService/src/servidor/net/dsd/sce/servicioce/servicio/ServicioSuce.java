package net.dsd.sce.servicioce.servicio;

import java.util.ArrayList;

import net.dsd.entidad.servicioentidad.ServicioEntidadStub;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.Dgs015ProductoType;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.Dgs015Type;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadFormatoRequest;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadFormatoRequestChoice_type0;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadResponse;
import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.servicio.MysqlSuceDao;

public class ServicioSuce {
	private MysqlSuceDao mysqlSuceDao;

	public ServicioSuce() {
		mysqlSuceDao = new MysqlSuceDao();
	}

	public void transmitirSuceHaciaEntidad(BeanOrden orden, BeanSuce suce, BeanFormato formatoEntidadOrigen, String rucUsuarioSolicitante) {
		try {
			ServicioEntidadStub expedienteStub = new ServicioEntidadStub();

			EntidadFormatoRequestChoice_type0 formatoType = convertirFormatoSceEnEntidad(orden.getFormato(), formatoEntidadOrigen);

			EntidadFormatoRequest request = new EntidadFormatoRequest();
			request.setFormato(orden.getFormato());
			request.setOrden(orden.getOrden());
			request.setSuce(suce.getSuce());
			request.setEntidadFormatoRequestChoice_type0(formatoType);
			request.setRucUsuarioSolicitante(rucUsuarioSolicitante);

			EntidadResponse response = expedienteStub.registrarSuce(request);
			System.out.println(response.getCodigo());
			System.out.println(response.getTexto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BeanSuce registrarSuce(BeanOrden orden) {
		return mysqlSuceDao.registrarSuce(orden);
	}

	public void modificarSuce(BeanSuce suce) {
		mysqlSuceDao.modificarSuce(suce);
	}

	private EntidadFormatoRequestChoice_type0 convertirFormatoSceEnEntidad(String formato, BeanFormato formatoEntidadOrigen) {
		EntidadFormatoRequestChoice_type0 formatoEntidad = new EntidadFormatoRequestChoice_type0();
		if (formato == "DGS015") {
			BeanDgs015 dgs015 = (BeanDgs015) formatoEntidadOrigen;
			ArrayList<BeanDgs015Producto> listaDgs015Producto = dgs015.getListaDgs015Producto();
			//llenando detalle del producto
			Dgs015Type dgs015Type = new Dgs015Type();
			dgs015Type.setTipoProducto(formatoEntidad.getFormatoDgs015().getTipoProducto());
			//llenando lista de productos
			Dgs015ProductoType[] dgs015ProductoTypeArray = new Dgs015ProductoType[listaDgs015Producto.size()];
			int i = 0;
			for (BeanDgs015Producto dgs015Producto : listaDgs015Producto) {
				Dgs015ProductoType dgs015ProductoType = new Dgs015ProductoType();
				dgs015ProductoType.setCantidad(dgs015Producto.getCantidad());
				dgs015ProductoType.setEnvase(dgs015Producto.getEnvase());
				dgs015ProductoType.setNombre(dgs015Producto.getNombre());
				dgs015ProductoType.setPartidaArancelaria(dgs015Producto.getPartidaArancelaria());
				dgs015ProductoTypeArray[i] = dgs015ProductoType;
				i = i+1;
			}
			dgs015Type.setListaProducto(dgs015ProductoTypeArray);
			formatoEntidad.setFormatoDgs015(dgs015Type);
		} else {
			formatoEntidad = null;
		}
		return formatoEntidad;
	}
}
