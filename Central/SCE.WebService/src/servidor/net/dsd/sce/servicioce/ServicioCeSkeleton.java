/**
 * ServicioCeSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package net.dsd.sce.servicioce;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import net.dsd.sce.bean.BeanAdjunto;
import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.servicioce.servicio.ServicioOrden;
import net.dsd.sce.servicioce.servicio.ServicioSuce;
import net.dsd.sce.servicioce.servicio.ServicioTasa;
import net.dsd.sce.transmitirdigesarequest.Dgs015ProductoType;
import net.dsd.sce.transmitirdigesarequest.Dgs015Type;
import net.dsd.sce.transmitirdigesarequest.MensajeType;
import net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest;
import net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest;
import net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequestChoice_type0;
import net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest;
import net.dsd.sce.transmitirdigesarequest.UsuarioType;
import net.dsd.sce.transmitirresponse.TransmitirResponse;

import org.apache.commons.io.IOUtils;

/**
 * ServicioCeSkeleton java skeleton for the axisService
 */
public class ServicioCeSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param tramiteOrdenRequest
	 * @return tramiteResponse
	 */

	public TransmitirResponse transmitirOrden(TransmitirOrdenRequest tramiteOrdenRequest) {
		try {
			System.out.println("======================");
			System.out.println("Inicio: transmitirOrden");
			String formato = tramiteOrdenRequest.getMensaje().getFormato();

			BeanOrden orden = ConvertirdorBean.convertirMensajeTypeEnBeanOrden(tramiteOrdenRequest.getMensaje());
			BeanUsuario usuario = ConvertirdorBean.convertirUsuarioTypeEnBeanUsuario(tramiteOrdenRequest.getUsuario());
			// 1: Registro de la Orden y el usuario solicitante
			ServicioOrden servicioOrden = new ServicioOrden();
			orden = servicioOrden.registrarOrden(orden.getFormato());

			// 2: Cargar el archivo adjunto
			if (tramiteOrdenRequest.getAdjunto() != null) {
				BeanAdjunto adjunto = new BeanAdjunto();
				adjunto.setNombreArchivo(tramiteOrdenRequest.getNombreArchivoAdjunto());
				byte[] b = IOUtils.toByteArray(tramiteOrdenRequest.getAdjunto().getInputStream());
				ByteArrayInputStream bis = new ByteArrayInputStream(b);
				adjunto.setArchivo(bis);
				adjunto.setTamano(b.length);
				servicioOrden.registrarAdjunto(orden, adjunto);
			}

			// 3: Registro del formato
			BeanFormato formatoEntidad = ConvertirdorBean.convertirFormatoTypeEnBeanFormato(formato, orden, tramiteOrdenRequest.getTransmitirOrdenRequestChoice_type0());
			if (formato.equals("DGS015")) {
				servicioOrden.actualizarDgs015(orden, (BeanDgs015) formatoEntidad);
			}

			// 4: Se transmite automáticamente, esto es debido a que por este medio no hay pendiente de envio
			servicioOrden.transmitirOrden(orden);

			// 5: Flujo Alterno 1
			if (orden.getMontoPago() > 0) {
				//5.1: Registrar Tasa
				ServicioTasa servicioTasa = new ServicioTasa();
				//5.1.1: Solicitar la tasa a Financiera
				BeanTasa tasa = servicioTasa.solicitarTasaHaciaFinanciera(orden.getMontoPago());
				//5.1.2: Asignar Tasa a ORDEN
				servicioTasa.asignarTasa(orden, tasa);
				//5.1.3: Comunicar Tasa por correo
				//TODO Comunicar Tasa por correo
			} else {
				//5.2: Registra la SUCE
				ServicioSuce servicioSuce = new ServicioSuce();
				//5.2.1: Generar SUCE
				BeanSuce suce = servicioSuce.registrarSuce(orden);
				//5.2.2: Transmitir SUCE a Entidad
				servicioSuce.transmitirSuceHaciaEntidad(orden, suce, formatoEntidad, usuario.getRuc());
				//5.2.3: Transmitir SUCE a Usuario
				//TODO Transmitir SUCE a Usuario
			}

			System.out.println("Fin");
			System.out.println("======================");

			TransmitirResponse res = new TransmitirResponse();
			res.setCodigo(orden.getOrden()+"");
			res.setTexto("Se registró con existo la orden " + orden.getOrden());
			return res;
		} catch (Exception e) {
			e.printStackTrace();

			TransmitirResponse res = new TransmitirResponse();
			res.setCodigo("ERR");
			res.setTexto("Error");
			return res;
		}
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param tramitePagoRequest
	 * @return tramiteResponse0
	 */

	public TransmitirResponse transmitirPago(TransmitirPagoRequest tramitePagoRequest) {
		try {
			System.out.println("======================");
			System.out.println("Inicio: transmitirPago");

			//1: Se recupera el CDA pagado
			BeanTasa tasa = new BeanTasa(); 
			tasa.setCda(tramitePagoRequest.getCda());
			tasa.setMontoPago(tramitePagoRequest.getMonto());
			tasa.setFechaPago(tramitePagoRequest.getFechaPago());

			//2: Se actualiza el pago de la Tasa
			ServicioTasa servicioTasa = new ServicioTasa();
			servicioTasa.pagarTasa(tasa);

			//3: Se busca la orden según el CDA pagado
			ServicioOrden servicioOrden = new ServicioOrden();
			BeanOrden orden = servicioOrden.buscarOrdenPorCda(tasa.getCda());
			orden = servicioOrden.buscarOrdenPorOrdenId(orden.getOrdenId());

			//4: Registra la SUCE
			ServicioSuce servicioSuce = new ServicioSuce();
			BeanSuce suce = servicioSuce.registrarSuce(orden);

			//5: Se genera el nuevo MTO
			//TODO generar nuevo mto, incluye registrar otra vez la orden

			//6: Se transmite la SUCE
			orden = servicioOrden.buscarOrdenPorOrdenId(orden.getOrdenId());
			BeanFormato formatoEntidad = servicioOrden.buscarFormatoEntidadPorOrden(orden.getOrdenId(), orden.getFormato());
			BeanUsuario usuarioSolicitante = servicioOrden.buscarUsuarioSolicitantePorOrdenId(orden.getOrdenId());

			//3.2.3: Transmitir SUCE a Entidad
			servicioSuce.transmitirSuceHaciaEntidad(orden, suce, formatoEntidad, usuarioSolicitante.getRuc());
			//3.2.4: Transmitir SUCE a Usuario
			//TODO Transmitir SUCE a Usuario

			System.out.println("Fin");
			System.out.println("======================");

			TransmitirResponse res = new TransmitirResponse();
			res.setCodigo(suce.getSuce()+"");
			res.setTexto("Exito");
			return res;
		} catch (Exception e) {
			e.printStackTrace();

			TransmitirResponse res = new TransmitirResponse();
			res.setCodigo("ERR");
			res.setTexto("Error");
			return res;
		}
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param tramiteSuceRequest
	 * @return tramiteResponse1
	 */

	public TransmitirResponse transmitirNroExpediente(TransmitirNroExpedienteRequest tramiteSuceRequest) {
		System.out.println("======================");
		System.out.println("Inicio: transmitirNroExpediente");

		MensajeType mensajeType = tramiteSuceRequest.getMensaje();

		//1: Se recupera la SUCE
		BeanSuce suce = new BeanSuce();
		suce.setSuce(mensajeType.getSuce());
		suce.setNroExpediente(mensajeType.getNumeroExpediente());

		//2: Se actualiza la SUCE
		ServicioSuce servicioSuce = new ServicioSuce();
		//2.1 Se actualiza los datos de la SUCE
		servicioSuce.modificarSuce(suce);
		//3.2: Transmitir Nro de Expediente a Usuario
		//TODO Transmitir Nro de Expediente a Usuario

		System.out.println("Fin");
		System.out.println("======================");

		TransmitirResponse res = new TransmitirResponse();
		res.setCodigo("001");
		res.setTexto("Exito");
		return res;
	}
}


class ConvertirdorBean {

	public static BeanOrden convertirMensajeTypeEnBeanOrden(MensajeType mensajeType) {
		BeanOrden orden = new BeanOrden();
		orden.setFormato(mensajeType.getFormato());
		orden.setOrden(mensajeType.getOrden());
		return orden;
	}

	public static BeanFormato convertirFormatoTypeEnBeanFormato(String formato, BeanOrden orden, TransmitirOrdenRequestChoice_type0 formatoEntidadOriden) {
		if (formato.equals("DGS015")) {
			Dgs015Type dgs015Type = formatoEntidadOriden.getFormatoDgs015();
			Dgs015ProductoType[] listaDgs015ProductoType = dgs015Type.getListaProducto();

			BeanDgs015 dgs015 = new BeanDgs015();
			dgs015.setDgs015Id(orden.getFormatoEntidadId());
			dgs015.setDgsTipoProducto(dgs015Type.getTipoProducto());
			ArrayList<BeanDgs015Producto> listaDgs015Producto = new ArrayList<BeanDgs015Producto>();
			for (Dgs015ProductoType dgs015ProductoType : listaDgs015ProductoType) {
				BeanDgs015Producto dgs015Producto = new BeanDgs015Producto();
				dgs015Producto.setDgs015Id(orden.getFormatoEntidadId());
				dgs015Producto.setNombre(dgs015ProductoType.getNombre());
				dgs015Producto.setPartidaArancelaria(dgs015ProductoType.getPartidaArancelaria());
				dgs015Producto.setCantidad(dgs015ProductoType.getCantidad());
				dgs015Producto.setEnvase(dgs015ProductoType.getEnvase());
				listaDgs015Producto.add(dgs015Producto);
			}
			dgs015.setListaDgs015Producto(listaDgs015Producto);
			return dgs015;
		} else {
			return null;
		}
	}

	public static BeanUsuario convertirUsuarioTypeEnBeanUsuario(UsuarioType usuarioType) {
		BeanUsuario usuario = new BeanUsuario();
		usuario.setRuc(usuarioType.getRuc());
		usuario.setUsuarioSol(usuarioType.getUsuarioSol());
		return usuario;
	}
}