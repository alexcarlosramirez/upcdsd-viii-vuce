package net.dsd.sce.dao;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.dsd.sce.bean.BeanAdjunto;
import net.dsd.sce.bean.BeanEntidad;
import net.dsd.sce.bean.BeanFormato;
import net.dsd.sce.bean.BeanFormatoEntidad;
import net.dsd.sce.bean.BeanMto;
import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSdr;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.bean.BeanTce;
import net.dsd.sce.bean.BeanTraza;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.conexion.ConexionBD;
import net.dsd.sce.excepcion.DAOExcepcion;

import org.apache.commons.io.IOUtils;

public class MysqlOrdenDao {

	public BeanOrden registrarOrden(String formato, BeanMto outMto, BeanFormatoEntidad outFormatoEntidad, BeanTce outTce) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;
		BeanOrden returnOrden = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL orden_registra(?,?,?,?,?,?)");
			st1.setString(1, formato);
			st1.registerOutParameter(2, java.sql.Types.INTEGER);
			st1.registerOutParameter(3, java.sql.Types.INTEGER);
			st1.registerOutParameter(4, java.sql.Types.INTEGER);
			st1.registerOutParameter(5, java.sql.Types.INTEGER);
			st1.registerOutParameter(6, java.sql.Types.INTEGER);
			st1.execute();
			con.commit();

			returnOrden = new BeanOrden();
			returnOrden.setOrdenId(st1.getInt(2));
			returnOrden.setOrden(st1.getLong(4));

			outMto.setOrdenId(st1.getInt(2));
			outMto.setMto(st1.getInt(3));

			outFormatoEntidad.setFormatoEntidadId(st1.getInt(5));

			outTce.setTceId(st1.getInt(6));
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return returnOrden;
	}

	public void transmitirOrden(BeanOrden orden, BeanMto mto, BeanFormatoEntidad formatoEntidad, BeanTasa outTasa) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL orden_transmite(?,?,?,?)");
			st1.setInt(1, orden.getOrdenId());
			st1.setInt(2, mto.getMto());
			st1.setInt(3, formatoEntidad.getFormatoEntidadId());
			st1.registerOutParameter(4, java.sql.Types.DOUBLE);
			st1.execute();
			con.commit();

			outTasa.setMontoPago(st1.getDouble(4));
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void registrarAdjuntoPorMto(BeanMto mto, BeanAdjunto adjunto) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL adjunto_registra_x_orden(?,?,?,?)");
			st1.setInt(1, mto.getOrdenId());
			st1.setInt(2, mto.getMto());
			st1.setString(3, adjunto.getNombreArchivo());
			st1.setBinaryStream(4, adjunto.getArchivo(), adjunto.getTamano());
			st1.executeUpdate();
			con.commit();
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void registrarUsuarioFormatoSolicitante(BeanMto mto, BeanUsuario usuario) throws DAOExcepcion {
		registrarUsuarioFormato(1, mto, usuario);
	}

	private void registrarUsuarioFormato(int usuarioFormatoTipo, BeanMto mto, BeanUsuario usuario) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL usuario_formato_registra(?,?,?,?,?,?)");
			st1.setInt(1, usuarioFormatoTipo);
			st1.setInt(2, mto.getOrdenId());
			st1.setInt(3, mto.getMto());
			st1.setString(4, usuario.getRuc());
			st1.setString(5, usuario.getUsuarioSol());
			st1.registerOutParameter(6, java.sql.Types.INTEGER);
			st1.execute();
			usuario.setUsuarioId(st1.getInt(6));
			con.commit();
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public BeanTraza registrarTraza(BeanTce tce, BeanMto mto, BeanSdr sdr, BeanUsuario usuario, BeanTraza traza) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;
		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL traza_registra(?,?,?,?,?,?,?,?,?,?)");
			st1.setInt(1, tce.getTceId());
			st1.setInt(2, traza.getEstadoTraza());
			//Si no hay mto, grabar nulo, seguro que hay un sdr
			if (mto == null) {
				st1.setNull(3, java.sql.Types.INTEGER);
				st1.setNull(4, java.sql.Types.INTEGER);
			} else {
				st1.setInt(3, mto.getOrdenId());
				st1.setInt(4, mto.getMto());
			}
			//Si no hay sdr, grabar nulo, seguro que hay un mto
			if (sdr == null) {
				st1.setNull(5, java.sql.Types.INTEGER);
				st1.setNull(6, java.sql.Types.INTEGER);
			} else {
				st1.setInt(5, sdr.getDrId());
				st1.setInt(6, sdr.getSdr());
			}
			st1.setInt(7, traza.getDe());
			st1.setInt(8, traza.getPara());
			//Si usuario es nulo, puede ser que sea enviado desde sistema SCE o Financiera
			if (usuario == null) {
				st1.setNull(9, java.sql.Types.INTEGER);
			} else {
				st1.setInt(9, usuario.getUsuarioId());
			}
			st1.registerOutParameter(10, java.sql.Types.INTEGER);
			st1.execute();
			traza = new BeanTraza();
			traza.setTrazaId(st1.getInt(10));
			con.commit();
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return traza;
	}

	public BeanOrden buscarOrdenPorCda(String cda) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanOrden orden = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select o.orden_id from orden o, tce t, tasa s, tce_tasa ts where o.orden_id = t.orden_id and t.tce_id = ts.tce_id and ts.tasa_id = s.tasa_id and cda = ?");
			st1.setString(1, cda);
			rs = st1.executeQuery();
			if (rs.next()) {
				orden = new BeanOrden();
				orden.setOrdenId(rs.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return orden;
	}

	public BeanOrden buscarOrdenPorSuce(long suce) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanOrden orden = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select o.orden_id from orden o, tce t, suce s where o.orden_id = t.orden_id AND t.suce_id = s.suce_id and s.suce = ?");
			st1.setLong(1, suce);
			rs = st1.executeQuery();
			if (rs.next()) {
				orden = new BeanOrden();
				orden.setOrdenId(rs.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return orden;
	}

	public BeanOrden buscarOrdenPorOrdenId(int ordenId, BeanFormato outFormato) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanOrden orden = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select o.orden_id, o.orden, o.fecha_registro, o.bloqueada, o.cerrada, f.formato from orden o, tce t, formato f where f.formato_id = t.formato_id and t.orden_id = o.orden_id and o.orden_id = ?");
			st1.setInt(1, ordenId);
			rs = st1.executeQuery();
			if (rs.next()) {
				orden = new BeanOrden();
				orden.setOrdenId(rs.getInt(1));
				orden.setOrden(rs.getLong(2));

				outFormato.setFormato(rs.getString(6));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return orden;
	}

	public BeanTce buscarTcePorOrdenId(int ordenId) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanTce tce = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select tce_id, tupa_id, formato_id, orden_id, suce_id, fecha_registro, estado from tce where orden_id = ?");
			st1.setInt(1, ordenId);
			rs = st1.executeQuery();
			if (rs.next()) {
				tce = new BeanTce();
				tce.setTceId(rs.getInt(1));
				tce.setTupaId(rs.getInt(2));
				tce.setFormatoId(rs.getInt(3));
				tce.setOrdenId(rs.getInt(4));
				tce.setSuceId(rs.getInt(5));
				tce.setEstado(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return tce;
	}

	public BeanMto buscarMtoVigentePorOrdenId(int ordenId) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanMto mto = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select orden_id, mto from mto where orden_id = ? and vigente = 'S' and etapa_tramite = 1");
			st1.setInt(1, ordenId);
			rs = st1.executeQuery();
			if (rs.next()) {
				mto = new BeanMto();
				mto.setOrdenId(rs.getInt(1));
				mto.setMto(rs.getInt(2));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return mto;
	}

	public BeanAdjunto buscarAdjuntoPorMto(BeanMto mto) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanAdjunto adjunto = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select nombre_archivo, archivo from adjunto where orden_id = ? and mto = ?");
			st1.setInt(1, mto.getOrdenId());
			st1.setInt(2, mto.getMto());
			rs = st1.executeQuery();
			if (rs.next()) {
				adjunto = new BeanAdjunto();
				adjunto.setNombreArchivo(rs.getString(1));
				adjunto.setArchivo(new ByteArrayInputStream(IOUtils.toByteArray(rs.getBinaryStream(2))));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return adjunto;
	}

	public BeanEntidad buscarEntidadPorFormato(String formato) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanEntidad entidad = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select e.entidad_id, e.entidad, e.codigo_financiera, e.estado from entidad e, formato f where e.entidad_id = f.entidad_id and f.formato = ?");
			st1.setString(1, formato);
			rs = st1.executeQuery();
			if (rs.next()) {
				entidad = new BeanEntidad();
				entidad.setEntidadId(rs.getInt(1));
				entidad.setEntidad(rs.getString(2));
				entidad.setCodigoFinanciera(rs.getString(3));
				entidad.setEstado(rs.getString(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return entidad;
	}

	public BeanUsuario buscarUsuarioSolicitantePorMto(BeanMto mto) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanUsuario usuario = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select usuario_id, ruc, usuario_sol from usuario_formato where orden_id = ? and mto = ?");
			st1.setInt(1, mto.getOrdenId());
			st1.setInt(2, mto.getMto());
			rs = st1.executeQuery();
			if (rs.next()) {
				usuario = new BeanUsuario();
				usuario.setUsuarioId(rs.getInt(1));
				usuario.setRuc(rs.getString(2));
				usuario.setUsuarioSol(rs.getString(3));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return usuario;
	}
}
