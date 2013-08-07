package net.dsd.sce.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;
import net.dsd.sce.conexion.ConexionBD;
import net.dsd.sce.excepcion.DAOExcepcion;

public class MysqlSuceDao {

	public BeanSuce generarSuce(BeanOrden orden) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;
		BeanSuce suce = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL suce_registra(?,?,?)");
			st1.setInt(1, orden.getOrdenId());
			st1.registerOutParameter(2, java.sql.Types.INTEGER);
			st1.registerOutParameter(3, java.sql.Types.INTEGER);
			st1.execute();
			con.commit();
			suce = new BeanSuce();
			suce.setSuceId(st1.getInt(2));
			suce.setSuce(st1.getLong(3));
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
		return suce;
	}

	public void modificarSuce(BeanSuce suce) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL suce_modifica(?,?)");
			st1.setLong(1, suce.getSuce());
			st1.setString(2, suce.getNroExpediente());
			st1.execute();
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
}
