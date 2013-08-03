package net.dsd.sce.bean;

import java.util.GregorianCalendar;

public class BeanSdr {

	private int drId;
	private int sdr;
	private GregorianCalendar fechaRegistro;
	private String vigente;

	public int getDrId() {
		return drId;
	}
	public void setDrId(int drId) {
		this.drId = drId;
	}
	public int getSdr() {
		return sdr;
	}
	public void setSdr(int sdr) {
		this.sdr = sdr;
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
}
