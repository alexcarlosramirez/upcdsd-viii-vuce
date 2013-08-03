package net.dsd.sce.bean.digesa;

import java.util.ArrayList;

import net.dsd.sce.bean.BeanFormatoEntidad;

public class BeanDgs015 extends BeanFormatoEntidad {

	private int dgsTipoProducto;
	private ArrayList<BeanDgs015Producto> listaDgs015Producto; 

	public int getDgsTipoProducto() {
		return dgsTipoProducto;
	}
	public void setDgsTipoProducto(int dgsTipoProducto) {
		this.dgsTipoProducto = dgsTipoProducto;
	}
	public ArrayList<BeanDgs015Producto> getListaDgs015Producto() {
		return listaDgs015Producto;
	}
	public void setListaDgs015Producto(
			ArrayList<BeanDgs015Producto> listaDgs015Producto) {
		this.listaDgs015Producto = listaDgs015Producto;
	}
}
