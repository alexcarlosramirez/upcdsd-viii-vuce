package net.dsd.sce.bean;

import java.util.GregorianCalendar;

public class BeanOrden {

	private int ordenId;
	private long orden;
	private GregorianCalendar fechaRegistro;
	private String bloqueada;
	private String cerrada;

	public int getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}
	public long getOrden() {
		return orden;
	}
	public void setOrden(long orden) {
		this.orden = orden;
	}
	public GregorianCalendar getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(GregorianCalendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getBloqueada() {
		return bloqueada;
	}
	public void setBloqueada(String bloqueada) {
		this.bloqueada = bloqueada;
	}
	public String getCerrada() {
		return cerrada;
	}
	public void setCerrada(String cerrada) {
		this.cerrada = cerrada;
	}

	/*
	private String formato;
	private int ordenId;
	private int mto;
	private long orden;
	private int formatoEntidadId;
	private int tceId;
	private double montoPago;

	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public int getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}
	public int getMto() {
		return mto;
	}
	public void setMto(int mto) {
		this.mto = mto;
	}
	public long getOrden() {
		return orden;
	}
	public void setOrden(long orden) {
		this.orden = orden;
	}
	public int getFormatoEntidadId() {
		return formatoEntidadId;
	}
	public void setFormatoEntidadId(int formatoEntidadId) {
		this.formatoEntidadId = formatoEntidadId;
	}
	public int getTceId() {
		return tceId;
	}
	public void setTceId(int tceId) {
		this.tceId = tceId;
	}
	public double getMontoPago() {
		return montoPago;
	}
	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}*/
}
