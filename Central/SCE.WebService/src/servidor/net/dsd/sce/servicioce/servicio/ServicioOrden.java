package net.dsd.sce.servicioce.servicio;

import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.servicio.MysqlOrdenDao;

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

	public BeanOrden buscarOrdenPorOrdenId(int ordenId) {
		return mysqlOrdenDao.buscarOrdenPorOrdenId(ordenId);
	}

	public BeanFormato buscarFormatoEntidadPorOrdenId(int ordenId) {
		return null;
	}

	public BeanUsuario buscarUsuarioSolicitantePorOrdenId(int ordenId) {
		return mysqlOrdenDao.buscarUsuarioSolicitantePorOrdenId(ordenId);
	}

	//Digesa

	public BeanDgs015 buscarDgs015PorOrdenId(int ordenId) {
		return mysqlOrdenDao.buscarDgs015PorOrdenId(ordenId);
	}

	public void actualizarDgs015(BeanOrden orden, BeanDgs015 dgs015) {
		mysqlOrdenDao.registrarDgs015(dgs015, dgs015.getListaDgs015Producto());
	}
}
