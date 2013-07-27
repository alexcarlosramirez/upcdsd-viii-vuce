package net.dsd.sce.servicio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanTasa;

public class MysqlTasaDao {

	private Connection con = null;

	private String url = "jdbc:mysql://localhost:3306/sce_central_db";
	private String user = "root";
	private String password = "root";

	public void asignarTasa(BeanOrden orden, BeanTasa tasa) {
		CallableStatement st1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
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
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}


	public void pagarTasa (BeanTasa tasa) {
		CallableStatement st1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
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
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (st1 != null) {
					st1.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
}
