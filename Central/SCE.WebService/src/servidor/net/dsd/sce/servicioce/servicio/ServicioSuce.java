package net.dsd.sce.servicioce.servicio;

import expediente.ExpedienteServicioStub;
import expediente.ExpedienteServicioStub.InsertaExpediente;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.servicio.MysqlSuceDao;

public class ServicioSuce {
	private MysqlSuceDao mysqlSuceDao;

	public ServicioSuce() {
		mysqlSuceDao = new MysqlSuceDao();
	}

	public void transmitirSuceHaciaEntidad(BeanSuce suce) {
		try {
			ExpedienteServicioStub expedienteStub = new ExpedienteServicioStub();
			InsertaExpediente expedienteType = new InsertaExpediente();
			expedienteType.setOperando1(suce.getSuce()+"");
			expedienteStub.insertaExpediente(expedienteType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BeanSuce registrarSuce(BeanOrden orden) {
		return mysqlSuceDao.registrarSuce(orden);
	}

	public void modificarSuce(BeanSuce suce) {
		mysqlSuceDao.modificarSuce(suce);
	}
}
