package net.dsd.sce.bean;

import java.io.InputStream;

public class BeanAdjunto {

	private String nombreArchivo;
	private InputStream archivo;
	private int tamano;

	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public InputStream getArchivo() {
		return archivo;
	}
	public void setArchivo(InputStream archivo) {
		this.archivo = archivo;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
}
