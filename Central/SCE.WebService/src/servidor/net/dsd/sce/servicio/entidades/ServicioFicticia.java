package net.dsd.sce.servicio.entidades;

import net.dsd.sce.bean.ficticia.BeanFrm001;
import net.dsd.sce.dao.entidades.MysqlFicticiaDao;
import net.dsd.sce.excepcion.DAOExcepcion;

public class ServicioFicticia {

	private MysqlFicticiaDao mysqlFicticiaDao;

	public ServicioFicticia() {
		mysqlFicticiaDao = new MysqlFicticiaDao();
	}

	public void modificarFrm001(BeanFrm001 frm001) throws DAOExcepcion {
		mysqlFicticiaDao.modificarFrm001(frm001);
	}

}
