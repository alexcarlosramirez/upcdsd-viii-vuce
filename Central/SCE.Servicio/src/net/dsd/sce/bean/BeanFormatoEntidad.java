package net.dsd.sce.bean;

public abstract class BeanFormatoEntidad {

	private int formatoEntidadId;
	private int ordenId;
	private int mto;

	public int getFormatoEntidadId() {
		return formatoEntidadId;
	}
	public void setFormatoEntidadId(int formatoEntidadId) {
		this.formatoEntidadId = formatoEntidadId;
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
}
