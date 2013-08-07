package net.dsd.sce.rest.gestion;

import java.util.ArrayList;

import net.dsd.sce.bean.vistas.BeanSolBandeja;
import net.dsd.sce.dao.MysqlVistasDao;
import net.dsd.sce.excepcion.DAOExcepcion;

public class GestionBandeja {

	public ArrayList<BeanSolBandeja> buscarListaSolicitudesPorEstadoEntidadId(String etapa, int entidadId) throws DAOExcepcion {
		MysqlVistasDao vistasDao = new MysqlVistasDao();
		return vistasDao.buscarListaSolicitudesPorEstadoEntidadId(etapa, entidadId);
	}
}
