package net.dsd.sce.servicio;

import net.dsd.financiera.cda.ServicioCdaStub;
import net.dsd.financiera.cda.ServicioCdaStub.CdaType;
import net.dsd.financiera.cda.ServicioCdaStub.GenerarCda;
import net.dsd.financiera.cda.ServicioCdaStub.GenerarCdaResponse;
import net.dsd.sce.bean.BeanEntidad;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.dao.MysqlTasaDao;
import net.dsd.sce.excepcion.DAOExcepcion;

import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;

public class ServicioTasa {

	private MysqlTasaDao mysqlTasaDao;

	public ServicioTasa() {
		mysqlTasaDao = new MysqlTasaDao();
	}

	public BeanTasa solicitarTasaHaciaFinanciera(BeanEntidad entidad, BeanUsuario usuario, BeanTasa tasa) {
		try {
			GenerarCda generarCda = new GenerarCda();
			generarCda.setCodigoEntidad(entidad.getCodigoFinanciera());
			generarCda.setCodigoEmpresa(usuario.getRuc());
			generarCda.setMontopago(tasa.getMontoPago());
			ServicioCdaStub servicioCda = new ServicioCdaStub();

			Options options = servicioCda._getServiceClient().getOptions();
			options.setProperty(HTTPConstants.HTTP_PROTOCOL_VERSION, HTTPConstants.HEADER_PROTOCOL_10);
			GenerarCdaResponse response = servicioCda.generarCda(generarCda);
			CdaType cdaType = response.getCda();

			//Registrar la tasa
			tasa.setCda(cdaType.getCda());
			tasa.setFechaGeneracion(cdaType.getFechaGeneracion());

			return tasa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void asignarTasa(BeanOrden orden, BeanTasa tasa) throws DAOExcepcion {
		mysqlTasaDao.asignarTasa(orden, tasa);
	}

	public void pagarTasa(BeanTasa tasa) throws DAOExcepcion {
		mysqlTasaDao.pagarTasa(tasa);
	}
}
