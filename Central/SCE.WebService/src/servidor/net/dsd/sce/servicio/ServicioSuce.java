package net.dsd.sce.servicio;

import java.io.IOException;
import java.util.ArrayList;

import javax.activation.DataHandler;

import org.apache.axiom.attachments.ByteArrayDataSource;
import org.apache.commons.io.IOUtils;

import net.dsd.entidad.servicioentidad.ServicioEntidadStub;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.AdjuntoType;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.Dgs015ProductoType;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.Dgs015Type;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadFormatoRequest;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadFormatoRequestChoice_type0;
import net.dsd.entidad.servicioentidad.ServicioEntidadStub.EntidadResponse;
import net.dsd.sce.bean.BeanAdjunto;
import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanFormatoEntidad;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.dao.MysqlSuceDao;
import net.dsd.sce.excepcion.DAOExcepcion;

public class ServicioSuce {
	private MysqlSuceDao mysqlSuceDao;

	public ServicioSuce() {
		mysqlSuceDao = new MysqlSuceDao();
	}

	public void transmitirSuceHaciaEntidad(BeanFormato formato, BeanOrden orden, BeanSuce suce, BeanFormatoEntidad formatoEntidad, BeanAdjunto adjunto, String ruc) {
		try {
			ServicioEntidadStub expedienteStub = new ServicioEntidadStub();

			EntidadFormatoRequestChoice_type0 formatoType = convertirFormatoSceEnEntidad(formato.getFormato(), formatoEntidad);

			EntidadFormatoRequest request = new EntidadFormatoRequest();
			request.setFormato(formato.getFormato());
			request.setOrden(orden.getOrden());
			request.setSuce(suce.getSuce());
			request.setEntidadFormatoRequestChoice_type0(formatoType);
			request.setEstadoPago("C");//Pendiente de respuesta de la entidad
			if (adjunto != null) {
				AdjuntoType adjuntoType = convertirAdjuntoSceEnAdjunto(adjunto);
				request.setAdjunto(adjuntoType);
			}
			request.setRucUsuarioSolicitante(ruc);

			EntidadResponse response = expedienteStub.registrarSuce(request);
			System.out.println(response.getCodigo());
			System.out.println(response.getTexto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BeanSuce generarSuce(BeanOrden orden) throws DAOExcepcion {
		return mysqlSuceDao.generarSuce(orden);
	}

	public void modificarSuce(BeanSuce suce) throws DAOExcepcion {
		mysqlSuceDao.modificarSuce(suce);
	}

	private EntidadFormatoRequestChoice_type0 convertirFormatoSceEnEntidad(String formato, BeanFormatoEntidad formatoEntidadOrigen) {
		EntidadFormatoRequestChoice_type0 formatoEntidad = new EntidadFormatoRequestChoice_type0();
		if (formato.equals("DGS015")) {
			BeanDgs015 dgs015 = (BeanDgs015) formatoEntidadOrigen;
			ArrayList<BeanDgs015Producto> listaDgs015Producto = dgs015.getListaDgs015Producto();
			//llenando detalle del producto
			Dgs015Type dgs015Type = new Dgs015Type();
			dgs015Type.setTipoProducto(dgs015.getDgsTipoProducto());
			//llenando lista de productos
			Dgs015ProductoType[] dgs015ProductoTypeArray = new Dgs015ProductoType[listaDgs015Producto.size()];
			int i = 0;
			for (BeanDgs015Producto dgs015Producto : listaDgs015Producto) {
				Dgs015ProductoType dgs015ProductoType = new Dgs015ProductoType();
				dgs015ProductoType.setSecuenciaProducto(dgs015Producto.getSecProducto());
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

	private AdjuntoType convertirAdjuntoSceEnAdjunto(BeanAdjunto adjunto) {
		try {
			AdjuntoType adjuntoType = new AdjuntoType();
			adjuntoType.setNombreArchivo(adjunto.getNombreArchivo());
			ByteArrayDataSource ds = new ByteArrayDataSource(IOUtils.toByteArray(adjunto.getArchivo()));
			adjuntoType.setAdjunto(new DataHandler(ds));
			return adjuntoType;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
