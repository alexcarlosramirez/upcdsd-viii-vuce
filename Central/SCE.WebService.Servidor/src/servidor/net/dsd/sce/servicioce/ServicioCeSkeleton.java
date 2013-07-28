/**
 * ServicioCeSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package net.dsd.sce.servicioce;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.servicioce.servicio.ServicioOrden;
import net.dsd.sce.servicioce.servicio.ServicioSuce;
import net.dsd.sce.servicioce.servicio.ServicioTasa;
import net.dsd.sce.transmitirdigesarequest.MensajeType;
import net.dsd.sce.transmitirdigesarequest.TransmitirNroExpedienteRequest;
import net.dsd.sce.transmitirdigesarequest.TransmitirOrdenRequest;
import net.dsd.sce.transmitirdigesarequest.TransmitirPagoRequest;
import net.dsd.sce.transmitirresponse.TransmitirResponse;

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
		System.out.println("======================");
		System.out.println("Inicio: transmitirOrden");

		MensajeType mensajeType = tramiteOrdenRequest.getMensaje();
		String formato = mensajeType.getFormato();

		// 1: Registro de la Orden
		ServicioOrden servicioOrden = new ServicioOrden();
		BeanOrden orden = servicioOrden.registrarOrden(formato);

		// 2: Registro del formato
		if (formato.equals("DGS015")) {
			servicioOrden.actualizarDgs015(orden, tramiteOrdenRequest.getTransmitirOrdenRequestChoice_type0().getFormatoDgs015());
		} else {
			servicioOrden.actualizarDgs016(orden, tramiteOrdenRequest.getTransmitirOrdenRequestChoice_type0().getFormatoDgs016());
		}

		// 3: Flujo Alterno 1
		if (orden.getMontoPago() > 0) {
			//3.1: Registrar Tasa
			ServicioTasa servicioTasa = new ServicioTasa();
			//3.1.1: Solicitar la tasa a Financiera
			BeanTasa tasa = servicioTasa.solicitarTasaHaciaFinanciera(orden.getMontoPago());
			//3.1.2: Asignar Tasa a ORDEN
			servicioTasa.asignarTasa(orden, tasa);
			//3.1.3: Comunicar Tasa por correo
			//TODO Comunicar Tasa por correo
		} else {
			//3.2: Registra la SUCE
			ServicioSuce servicioSuce = new ServicioSuce();
			//3.2.1: Generar SUCE
			BeanSuce suce = servicioSuce.registrarSuce(orden);
			//3.2.2: Transmitir SUCE a Entidad
			servicioSuce.transmitirSuceHaciaEntidad(suce);
			//3.2.3: Transmitir SUCE a Usuario
			//TODO Transmitir SUCE a Usuario
		}

		System.out.println("Fin");
		System.out.println("======================");

		TransmitirResponse res = new TransmitirResponse();
		res.setCodigo(orden.getOrden()+"");
		res.setTexto("Se registró con existo la orden " + orden.getOrden());
		return res;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param tramitePagoRequest
	 * @return tramiteResponse0
	 */

	public TransmitirResponse transmitirPago(TransmitirPagoRequest tramitePagoRequest) {
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

		//3.2: Registra la SUCE
		ServicioSuce servicioSuce = new ServicioSuce();
		//3.2.1: Generar SUCE
		BeanSuce suce = servicioSuce.registrarSuce(orden);
		//3.2.2: Transmitir SUCE a Entidad
		//servicioSuce.transmitirSuceHaciaEntidad(suce);
		//3.2.3: Transmitir SUCE a Usuario
		//TODO Transmitir SUCE a Usuario

		System.out.println("Fin");
		System.out.println("======================");

		TransmitirResponse res = new TransmitirResponse();
		res.setCodigo(suce.getSuce()+"");
		res.setTexto("Exito");
		return res;
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