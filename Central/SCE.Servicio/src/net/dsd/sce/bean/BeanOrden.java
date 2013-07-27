package net.dsd.sce.bean;

public class BeanOrden {
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
	}
}
