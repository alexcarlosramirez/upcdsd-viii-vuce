package net.dsd.sce.bean;

import java.util.GregorianCalendar;

public class BeanTce {

	private int tceId;
	private int tupaId;
	private int formatoId;
	private int ordenId;
	private int suceId;
	private GregorianCalendar fechaRegistro;
	private String estado;

	public int getTceId() {
		return tceId;
	}
	public void setTceId(int tceId) {
		this.tceId = tceId;
	}
	public int getTupaId() {
		return tupaId;
	}
	public void setTupaId(int tupaId) {
		this.tupaId = tupaId;
	}
	public int getFormatoId() {
		return formatoId;
	}
	public void setFormatoId(int formatoId) {
		this.formatoId = formatoId;
	}
	public int getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}
	public int getSuceId() {
		return suceId;
	}
	public void setSuceId(int suceId) {
		this.suceId = suceId;
	}
	public GregorianCalendar getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(GregorianCalendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
