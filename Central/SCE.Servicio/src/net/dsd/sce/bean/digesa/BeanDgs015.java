package net.dsd.sce.bean.digesa;

import java.util.ArrayList;

import net.dsd.sce.bean.BeanFormato;

public class BeanDgs015 extends BeanFormato {

	private int dgs015Id;
	private int dgsTipoProducto;
	private ArrayList<BeanDgs015Producto> listaDgs015Producto; 

	public int getDgs015Id() {
		return dgs015Id;
	}
	public void setDgs015Id(int dgs015Id) {
		this.dgs015Id = dgs015Id;
	}
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
