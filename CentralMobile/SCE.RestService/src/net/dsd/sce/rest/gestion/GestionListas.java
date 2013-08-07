package net.dsd.sce.rest.gestion;

import java.util.ArrayList;

import net.dsd.sce.bean.vistas.BeanLista;
import net.dsd.sce.dao.MysqlVistasDao;
import net.dsd.sce.excepcion.DAOExcepcion;

public class GestionListas {

	public ArrayList<BeanLista> buscarListaEntidades() throws DAOExcepcion {
		MysqlVistasDao mysqlVistasDao = new MysqlVistasDao();
		return mysqlVistasDao.buscarListaEntidades();
	}

	public ArrayList<BeanLista> buscarListaFormatoPorEntidad(int entidadId) throws DAOExcepcion {
		MysqlVistasDao mysqlVistasDao = new MysqlVistasDao();
		return mysqlVistasDao.buscarListaFormatoPorEntidad(entidadId);
	}

}
