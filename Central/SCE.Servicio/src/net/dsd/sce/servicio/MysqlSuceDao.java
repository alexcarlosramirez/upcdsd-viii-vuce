package net.dsd.sce.servicio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanSuce;

public class MysqlSuceDao {

	private Connection con = null;

	private String url = "jdbc:mysql://localhost:3306/sce_central_db";
	private String user = "root";
	private String password = "root";

	public BeanSuce generarSuce(BeanOrden orden) {
		CallableStatement st1 = null;
		BeanSuce suce = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
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
		return suce;
	}

	public void modificarSuce(BeanSuce suce) {
		CallableStatement st1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
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
