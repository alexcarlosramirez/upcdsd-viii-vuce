/**
 * ServicioCeSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package net.dsd.sce.servicioce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.activation.DataHandler;

import net.dsd.sce.bean.BeanAdjunto;
import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanFormatoEntidad;
import net.dsd.sce.bean.BeanMto;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.bean.BeanTce;
import net.dsd.sce.bean.BeanTraza;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.servicioce.servicio.ServicioOrden;
import net.dsd.sce.servicioce.servicio.ServicioSuce;
import net.dsd.sce.servicioce.servicio.ServicioTasa;
import net.dsd.sce.transmitirdigesarequest.Dgs015ProductoType;
import net.dsd.sce.transmitirdigesarequest.Dgs015Type;
import net.dsd.sce.transmitirdigesarequest.MensajeType;
import net.dsd.sce.transmitirdigesarequest.TransmitirDrRequest;
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

			BeanFormato formato = ConvertirdorBean.convertirMensajeTypeEnBeanFormato(tramiteOrdenRequest.getMensaje());
			BeanFormatoEntidad formatoEntidad = ConvertirdorBean.convertirFormatoTypeEnBeanFormato(formato.getFormato(), tramiteOrdenRequest.getTransmitirOrdenRequestChoice_type0());
			BeanUsuario usuario = ConvertirdorBean.convertirUsuarioTypeEnBeanUsuario(tramiteOrdenRequest.getUsuario());

			// 1: Registro de la Orden y el usuario solicitante
			ServicioOrden servicioOrden = new ServicioOrden();
			BeanMto mto = new BeanMto();
			BeanTce tce = new BeanTce();
			BeanOrden orden = servicioOrden.registrarOrden(formato.getFormato(), mto, formatoEntidad, tce);
			servicioOrden.registrarUsuarioFormatoSolicitante(mto, usuario);

			// 1.1: Registrar estado traza 1: Solicitud registrada
			BeanTraza traza = new BeanTraza();
			traza.setEstadoTraza(1);
			traza.setDe(1);
			traza.setPara(3);
			servicioOrden.registrarTraza(tce, mto, null, usuario, traza);

			// 2: Cargar el archivo adjunto
			BeanAdjunto adjunto = null;
			if (tramiteOrdenRequest.getAdjunto() != null) {
				adjunto = new BeanAdjunto();
				adjunto.setNombreArchivo(tramiteOrdenRequest.getNombreArchivoAdjunto());
				adjunto.setArchivo(ConvertirdorBean.convertirDhEnBis(tramiteOrdenRequest.getAdjunto()));
				servicioOrden.registrarAdjunto(mto, adjunto);
			}

			// 3: Completar del formato
			if (formato.getFormato().equals("DGS015")) {
				servicioOrden.modificarDgs015((BeanDgs015) formatoEntidad);
			}

			// 4: Se transmite de forma interna, esto es debido a que por este medio no hay pendiente de envio
			BeanTasa tasa = new BeanTasa();
			servicioOrden.transmitirOrden(orden, mto, formatoEntidad, tasa);

			// 4.1: Registrar estado traza 2: Solicitud transmitida
			traza = new BeanTraza();
			traza.setEstadoTraza(2);
			traza.setDe(3);
			traza.setPara(3);
			servicioOrden.registrarTraza(tce, mto, null, usuario, traza);

			// 5: Flujo Alterno 1
			if (tasa.getMontoPago() > 0) {
				// 5.1.1: Solicitar Tasa a Financiera
				ServicioTasa servicioTasa = new ServicioTasa();
				servicioTasa.solicitarTasaHaciaFinanciera(tasa);

				// 5.1.2: Asignar Tasa a ORDEN
				servicioTasa.asignarTasa(orden, tasa);

				// 5.2.3: Registrar estado traza 3: Tasa Generada
				traza = new BeanTraza();
				traza.setEstadoTraza(3);
				traza.setDe(3);
				traza.setPara(4);
				servicioOrden.registrarTraza(tce, mto, null, null, traza);

				// 5.1.3: Comunicar Tasa por correo
				//TODO Comunicar Tasa por correo
			} else {
				// 5.2.1: Registra la SUCE
				ServicioSuce servicioSuce = new ServicioSuce();
				BeanSuce suce = servicioSuce.generarSuce(orden);

				// 5.2.2: Transmitir SUCE a Entidad
				servicioSuce.transmitirSuceHaciaEntidad(formato, orden, suce, formatoEntidad, adjunto, usuario.getRuc());

				// 5.2.3: Registrar estado traza 5: Suce generada
				traza = new BeanTraza();
				traza.setEstadoTraza(5);
				traza.setDe(3);
				traza.setPara(2);
				servicioOrden.registrarTraza(tce, mto, null, null, traza);

				//5.2.3: Transmitir SUCE a Usuario
				//TODO Transmitir SUCE a Usuario
			}

			System.out.println("Fin");
			System.out.println("======================");

			TransmitirResponse res = new TransmitirResponse();
			res.setCodigo(orden.getOrden()+"");
			res.setTexto("Se registró con exito la orden " + orden.getOrden());
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

			//3: Según el CDA pagado, se obtiene la orden y otros datos importantes
			BeanFormato formato = new BeanFormato();
			ServicioOrden servicioOrden = new ServicioOrden();
			BeanOrden orden = servicioOrden.buscarOrdenPorCda(tasa.getCda());
			orden = servicioOrden.buscarOrdenPorOrdenId(orden.getOrdenId(), formato);
			BeanTce tce = servicioOrden.buscarTcePorOrdenId(orden.getOrdenId());
			BeanMto mto = servicioOrden.buscarMtoVigentePorOrdenId(orden.getOrdenId());
			BeanFormatoEntidad formatoEntidad = servicioOrden.buscarFormatoEntidadPorFormato(formato.getFormato(), mto);
			BeanAdjunto adjunto = servicioOrden.buscarAdjuntoPorMto(mto);
			BeanUsuario usuarioSolicitante = servicioOrden.buscarUsuarioSolicitantePorMto(mto);

			// 2.1: Registrar estado traza 4: Pago Recibido
			BeanTraza traza = new BeanTraza();
			traza.setEstadoTraza(4);
			traza.setDe(4);
			traza.setPara(3);
			servicioOrden.registrarTraza(tce, mto, null, null, traza);

			//5: Genera la SUCE
			ServicioSuce servicioSuce = new ServicioSuce();
			BeanSuce suce = servicioSuce.generarSuce(orden);

			//6: Se genera el nuevo MTO
			//TODO generar nuevo mto, incluye registrar otra vez la orden

			//7: Se transmite la SUCE
			servicioSuce.transmitirSuceHaciaEntidad(formato, orden, suce, formatoEntidad, adjunto, usuarioSolicitante.getRuc());

			// 2.1: Registrar estado traza 5: Suce generada
			traza = new BeanTraza();
			traza.setEstadoTraza(5);
			traza.setDe(3);
			traza.setPara(2);
			servicioOrden.registrarTraza(tce, mto, null, null, traza);

			//8: Transmitir SUCE a Usuario
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
		servicioSuce.modificarSuce(suce);

		// 2.1: Registrar estado traza 6: Suce generada
		BeanTraza traza = new BeanTraza();
		traza.setEstadoTraza(6);
		traza.setDe(2);
		traza.setPara(3);

		BeanFormato formato = new BeanFormato();
		formato.setFormato(mensajeType.getFormato());

		ServicioOrden servicioOrden = new ServicioOrden();
		BeanOrden orden = servicioOrden.buscarOrdenPorSuce(suce.getSuce());
		orden = servicioOrden.buscarOrdenPorOrdenId(orden.getOrdenId(), formato);
		BeanTce tce = servicioOrden.buscarTcePorOrdenId(orden.getOrdenId());
		BeanMto mto = servicioOrden.buscarMtoVigentePorOrdenId(orden.getOrdenId());
		servicioOrden.registrarTraza(tce, mto, null, null, traza);

		//3: Transmitir Nro de Expediente a Usuario
		//TODO Transmitir Nro de Expediente a Usuario

		System.out.println("Fin");
		System.out.println("======================");

		TransmitirResponse res = new TransmitirResponse();
		res.setCodigo("OK");
		res.setTexto("Exito");
		return res;
	}

	public TransmitirResponse transmitirDr(TransmitirDrRequest tramiteDrRequest) {
		System.out.println("transmitirDr");
		TransmitirResponse res = new TransmitirResponse();
		res.setCodigo("OK");
		res.setTexto("Exito");
		return res;
	}
}


class ConvertirdorBean {

	public static BeanFormato convertirMensajeTypeEnBeanFormato(MensajeType mensajeType) {
		BeanFormato outFormato = new BeanFormato();
		outFormato.setFormato(mensajeType.getFormato());
		return outFormato;
	}

	public static BeanFormatoEntidad convertirFormatoTypeEnBeanFormato(String formato, TransmitirOrdenRequestChoice_type0 formatoEntidadOrigen) {
		if (formato.equals("DGS015")) {
			Dgs015Type dgs015Type = formatoEntidadOrigen.getFormatoDgs015();
			Dgs015ProductoType[] listaDgs015ProductoType = dgs015Type.getListaProducto();

			BeanDgs015 dgs015 = new BeanDgs015();
			dgs015.setDgsTipoProducto(dgs015Type.getTipoProducto());
			ArrayList<BeanDgs015Producto> listaDgs015Producto = new ArrayList<BeanDgs015Producto>();
			for (Dgs015ProductoType dgs015ProductoType : listaDgs015ProductoType) {
				BeanDgs015Producto dgs015Producto = new BeanDgs015Producto();
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

	public static ByteArrayInputStream convertirDhEnBis(DataHandler dh) {
		try {
			byte[] buf = IOUtils.toByteArray(dh.getInputStream());
			return new ByteArrayInputStream(buf);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}