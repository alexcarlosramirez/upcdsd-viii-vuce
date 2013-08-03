package net.dsd.sce.bean;

import java.util.GregorianCalendar;

public class BeanMto {

	private int ordenId;
	private int mto;
	private GregorianCalendar fechaRegistro;
	private String vigente;
	private String transmitido;
	private String etapaTramite;

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
	public GregorianCalendar getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(GregorianCalendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getVigente() {
		return vigente;
	}
	public void setVigente(String vigente) {
		this.vigente = vigente;
	}
	public String getTransmitido() {
		return transmitido;
	}
	public void setTransmitido(String transmitido) {
		this.transmitido = transmitido;
	}
	public String getEtapaTramite() {
		return etapaTramite;
	}
	public void setEtapaTramite(String etapaTramite) {
		this.etapaTramite = etapaTramite;
	}
}
