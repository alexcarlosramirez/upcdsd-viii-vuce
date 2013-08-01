package net.dsd.sce.servicio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.dsd.sce.bean.BeanOrden;
import net.dsd.sce.bean.BeanUsuario;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;

public class MysqlOrdenDao {

	private Connection con = null;

	private String url = "jdbc:mysql://localhost:3306/sce_central_db";
	private String user = "root";
	private String password = "root";

	public BeanOrden registrarOrden(String formato) {
		CallableStatement st1 = null;
		BeanOrden orden = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL orden_registra(?,?,?,?,?,?,?)");
			st1.setString(1, formato);
			st1.registerOutParameter(2, java.sql.Types.INTEGER);
			st1.registerOutParameter(3, java.sql.Types.INTEGER);
			st1.registerOutParameter(4, java.sql.Types.INTEGER);
			st1.registerOutParameter(5, java.sql.Types.INTEGER);
			st1.registerOutParameter(6, java.sql.Types.INTEGER);
			st1.registerOutParameter(7, java.sql.Types.DOUBLE);
			st1.execute();
			con.commit();

			orden = new BeanOrden();
			orden.setOrdenId(st1.getInt(2));
			orden.setMto(st1.getInt(3));
			orden.setOrden(st1.getLong(4));
			orden.setFormatoEntidadId(st1.getInt(5));
			orden.setTceId(st1.getInt(6));
			orden.setMontoPago(st1.getDouble(7));
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

		return orden;
	}

	public BeanOrden buscarOrdenPorCda(String cda) {
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanOrden orden = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select o.orden_id from orden o, tce t, tasa s, tce_tasa ts where o.orden_id = t.orden_id and t.tce_id = ts.tce_id and ts.tasa_id = s.tasa_id and cda = ?");
			st1.setString(1, cda);
			rs = st1.executeQuery();
			if (rs.next()) {
				orden = new BeanOrden();
				orden.setOrdenId(rs.getInt(1));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
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
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		return orden;
	}

	public BeanOrden buscarOrdenPorOrdenId(int ordenId) {
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanOrden orden = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select orden_id, orden, fecha_registro, bloqueada, cerrada from orden o where orden_id = ?");
			st1.setInt(1, ordenId);
			rs = st1.executeQuery();
			if (rs.next()) {
				orden = new BeanOrden();
				orden.setOrdenId(rs.getInt(1));
				orden.setOrden(rs.getLong(2));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
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
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		return orden;
	}

	public BeanUsuario buscarUsuarioSolicitantePorOrdenId(int ordenId) {
		return null;
	}

	//digesa

	public BeanDgs015 buscarDgs015PorOrdenId(int ordenId) {
		return null;
	}

	public void registrarDgs015(BeanDgs015 dgs015, ArrayList<BeanDgs015Producto> listaDgs015Producto) {
		CallableStatement st1 = null;
		CallableStatement st2 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL dgs015_modifica(?,?)");
			st1.setInt(1, dgs015.getDgs015Id());
			st1.setInt(2, dgs015.getDgsTipoProducto());
			st1.execute();
			st2 = con.prepareCall("CALL dgs015_producto_registra(?,?,?,?,?,?)");
			for (BeanDgs015Producto dgs015Producto : listaDgs015Producto) {
				st2.setInt(1, dgs015Producto.getDgs015Id());
				st2.setString(2, dgs015Producto.getNombre());
				st2.setString(3, dgs015Producto.getPartidaArancelaria());
				st2.setInt(4, dgs015Producto.getCantidad());
				st2.setString(5, dgs015Producto.getEnvase());
				st2.registerOutParameter(6, java.sql.Types.INTEGER);
				st2.execute();
			}
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
				if (st2 != null) {
					st2.close();
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
