package net.dsd.sce.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanTasa;
import net.dsd.sce.conexion.ConexionBD;
import net.dsd.sce.excepcion.DAOExcepcion;

public class MysqlTasaDao {

	public void asignarTasa(BeanOrden orden, BeanTasa tasa) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL asignar_tasa(?,?,?,?)");
			st1.setInt(1, orden.getOrdenId());
			st1.setDouble(2, tasa.getMontoPago());
			st1.setString(3, tasa.getCda());
			st1.setDate(4, new java.sql.Date(tasa.getFechaGeneracion().getTimeInMillis()));
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


	public void pagarTasa (BeanTasa tasa) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL pagar_tasa(?,?)");
			st1.setString(1, tasa.getCda());
			st1.setDate(2, new java.sql.Date(tasa.getFechaPago().getTimeInMillis()));
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
