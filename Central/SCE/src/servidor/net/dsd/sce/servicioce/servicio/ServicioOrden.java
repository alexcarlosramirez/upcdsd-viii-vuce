package net.dsd.sce.servicioce.servicio;

import java.util.ArrayList;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.servicio.MysqlOrdenDao;
import net.dsd.sce.transmitirdigesarequest.Dgs015ProductoType;
import net.dsd.sce.transmitirdigesarequest.Dgs015Type;
import net.dsd.sce.transmitirdigesarequest.Dgs016Type;

public class ServicioOrden {
	private MysqlOrdenDao mysqlOrdenDao;

	public ServicioOrden() {
		mysqlOrdenDao = new MysqlOrdenDao();
	}

	public BeanOrden registrarOrden(String formato) {
		return mysqlOrdenDao.registrarOrden(formato);
	}

	public BeanOrden buscarOrdenPorCda(String cda) {
		return mysqlOrdenDao.buscarOrdenPorCda(cda);
	}

	public void actualizarDgs015(BeanOrden orden, Dgs015Type dgs015Type) {
		Dgs015ProductoType[] listaDgs015ProductoType = dgs015Type.getListaProducto();
		BeanDgs015 dgs015 = new BeanDgs015();
		dgs015.setDgs015Id(orden.getFormatoEntidadId());
		dgs015.setDgsTipoProducto(dgs015Type.getTipoProducto());
		ArrayList<BeanDgs015Producto> listaDgs015Producto = new ArrayList<BeanDgs015Producto>();
		for (Dgs015ProductoType dgs015ProductoType : listaDgs015ProductoType) {
			BeanDgs015Producto dgs015Producto = new BeanDgs015Producto();
			dgs015Producto.setDgs015Id(orden.getFormatoEntidadId());
			dgs015Producto.setNombre(dgs015ProductoType.getNombre());
			dgs015Producto.setPartidaArancelaria(dgs015ProductoType.getPartidaArancelaria());
			dgs015Producto.setCantidad(dgs015ProductoType.getCantidad());
			dgs015Producto.setEnvase(dgs015ProductoType.getEnvase());
			listaDgs015Producto.add(dgs015Producto);
		}

		mysqlOrdenDao.registrarDgs015(dgs015, listaDgs015Producto);
	}

	public void actualizarDgs016(BeanOrden orden, Dgs016Type formatoDgs016) {
		// TODO Auto-generated method stub
		
	}

	
}
