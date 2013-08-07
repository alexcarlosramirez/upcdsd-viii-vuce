package net.dsd.sce.bean.vistas;

public class BeanSolBandeja {

	private long numero;
	private int entidadId;
	private String fechaRegistro;
	private String formato;
	private String entidad;
	private String etapaTramite;
	private String estado;

	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public int getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(int entidadId) {
		this.entidadId = entidadId;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getEtapaTramite() {
		return etapaTramite;
	}
	public void setEtapaTramite(String etapaTramite) {
		this.etapaTramite = etapaTramite;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
