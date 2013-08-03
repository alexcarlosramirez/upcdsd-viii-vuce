package net.dsd.sce.servicioce.servicio;

import java.util.ArrayList;

import net.dsd.sce.bean.BeanAdjunto;
import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanFormatoEntidad;
import net.dsd.sce.bean.BeanMto;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSdr;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.bean.BeanTce;
import net.dsd.sce.bean.BeanTraza;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.servicio.MysqlOrdenDao;

public class ServicioOrden {
	private MysqlOrdenDao mysqlOrdenDao;

	public ServicioOrden() {
		mysqlOrdenDao = new MysqlOrdenDao();
	}

	public BeanOrden registrarOrden(String formato, BeanMto outMto, BeanFormatoEntidad outFormatoEntidad, BeanTce outTce) {
		return mysqlOrdenDao.registrarOrden(formato, outMto, outFormatoEntidad, outTce);
	}

	public void transmitirOrden(BeanOrden orden, BeanMto mto, BeanFormatoEntidad formatoEntidad, BeanTasa outTasa) {
		mysqlOrdenDao.transmitirOrden(orden, mto, formatoEntidad, outTasa);
	}

	public void registrarAdjunto(BeanMto mto, BeanAdjunto adjunto) {
		mysqlOrdenDao.registrarAdjuntoPorMto(mto, adjunto);
	}

	public void registrarUsuarioFormatoSolicitante(BeanMto mto, BeanUsuario usuario) {
		mysqlOrdenDao.registrarUsuarioFormatoSolicitante(mto, usuario);
	}

	public void registrarTraza(BeanTce tce, BeanMto mto, BeanSdr sdr, BeanUsuario usuario, BeanTraza traza) {
		mysqlOrdenDao.registrarTraza(tce, mto, sdr, usuario, traza);
	}

	public BeanOrden buscarOrdenPorCda(String cda) {
		return mysqlOrdenDao.buscarOrdenPorCda(cda);
	}

	public BeanTce buscarTcePorOrdenId(int ordenId) {
		return mysqlOrdenDao.buscarTcePorOrdenId(ordenId);
	}

	public BeanMto buscarMtoVigentePorOrdenId(int ordenId) {
		return mysqlOrdenDao.buscarMtoVigentePorOrdenId(ordenId);
	}

	public BeanOrden buscarOrdenPorSuce(long suce) {
		return mysqlOrdenDao.buscarOrdenPorSuce(suce);
	}

	public BeanAdjunto buscarAdjuntoPorMto(BeanMto mto) {
		return mysqlOrdenDao.buscarAdjuntoPorMto(mto);
	}

	public BeanOrden buscarOrdenPorOrdenId(int ordenId, BeanFormato outFormato) {
		return mysqlOrdenDao.buscarOrdenPorOrdenId(ordenId, outFormato);
	}

	public BeanUsuario buscarUsuarioSolicitantePorMto(BeanMto mto) {
		return mysqlOrdenDao.buscarUsuarioSolicitantePorMto(mto);
	}

	public BeanFormatoEntidad buscarFormatoEntidadPorFormato(String formato, BeanMto mto) {
		if (formato.equals("DGS015")) {
			return buscarDgs015PorOrdenId(mto);
		} else {
			return null;
		}
	}

	public BeanUsuario buscarUsuarioSolicitantePorOrdenId(BeanMto mto) {
		return mysqlOrdenDao.buscarUsuarioSolicitantePorMto(mto);
	}

	//Digesa

	public BeanDgs015 buscarDgs015PorOrdenId(BeanMto mto) {
		return mysqlOrdenDao.buscarDgs015PorMto(mto);
	}

	public void modificarDgs015(BeanDgs015 dgs015) {
		mysqlOrdenDao.modificarDgs015(dgs015, dgs015.getListaDgs015Producto());
	}

	public void modificarDgs015(BeanDgs015 dgs015, ArrayList<BeanDgs015Producto> listaDgs015Producto) {
		mysqlOrdenDao.modificarDgs015(dgs015, listaDgs015Producto);
	}
}
