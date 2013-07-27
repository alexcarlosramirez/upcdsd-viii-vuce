package net.dsd.sce.bean;

import java.util.Calendar;

public class BeanTasa {

	private int tasaId;
	private double montoPago;
	private String cda;
	private Calendar fechaGeneracion;
	private Calendar fechaPago;

	public int getTasaId() {
		return tasaId;
	}
	public void setTasaId(int tasaId) {
		this.tasaId = tasaId;
	}
	public double getMontoPago() {
		return montoPago;
	}
	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}
	public String getCda() {
		return cda;
	}
	public void setCda(String cda) {
		this.cda = cda;
	}
	public Calendar getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Calendar fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Calendar getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}
}
