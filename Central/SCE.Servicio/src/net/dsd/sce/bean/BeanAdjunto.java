package net.dsd.sce.bean;

import java.io.ByteArrayInputStream;

public class BeanAdjunto {

	private String nombreArchivo;
	private ByteArrayInputStream archivo;

	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public ByteArrayInputStream getArchivo() {
		return archivo;
	}
	public void setArchivo(ByteArrayInputStream archivo) {
		this.archivo = archivo;
	}
	public int getTamano() {
		return archivo.available();
	}
}
