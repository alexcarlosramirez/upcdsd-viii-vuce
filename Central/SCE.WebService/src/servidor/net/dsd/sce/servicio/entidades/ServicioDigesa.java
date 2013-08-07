package net.dsd.sce.servicio.entidades;

import java.util.ArrayList;

import net.dsd.sce.bean.BeanMto;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.dao.entidades.MysqlDigesaDao;
import net.dsd.sce.excepcion.DAOExcepcion;

public class ServicioDigesa {

	private MysqlDigesaDao mysqlDigesaDao;

	public ServicioDigesa() {
		mysqlDigesaDao = new MysqlDigesaDao();
	}

	public void modificarDgs015(BeanDgs015 dgs015, ArrayList<BeanDgs015Producto> listaDgs015Producto) throws DAOExcepcion {
		mysqlDigesaDao.modificarDgs015(dgs015, listaDgs015Producto);
	}

	public BeanDgs015 buscarDgs015PorOrdenId(BeanMto mto) throws DAOExcepcion {
		return mysqlDigesaDao.buscarDgs015PorMto(mto);
	}
}
