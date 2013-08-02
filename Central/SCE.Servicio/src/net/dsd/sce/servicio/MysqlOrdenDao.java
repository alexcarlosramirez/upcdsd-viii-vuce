package net.dsd.sce.servicio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.dsd.sce.bean.BeanAdjunto;
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
			st1 = con.prepareCall("CALL orden_registra(?,?,?,?,?,?)");
			st1.setString(1, formato);
			st1.registerOutParameter(2, java.sql.Types.INTEGER);
			st1.registerOutParameter(3, java.sql.Types.INTEGER);
			st1.registerOutParameter(4, java.sql.Types.INTEGER);
			st1.registerOutParameter(5, java.sql.Types.INTEGER);
			st1.registerOutParameter(6, java.sql.Types.INTEGER);
			st1.execute();
			con.commit();

			orden = new BeanOrden();
			orden.setOrdenId(st1.getInt(2));
			orden.setMto(st1.getInt(3));
			orden.setOrden(st1.getLong(4));
			orden.setFormatoEntidadId(st1.getInt(5));
			orden.setTceId(st1.getInt(6));
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

	public void transmitirOrden(BeanOrden orden) {
		CallableStatement st1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL orden_transmite(?,?,?,?)");
			st1.setInt(1, orden.getOrdenId());
			st1.setInt(2, orden.getMto());
			st1.setInt(3, orden.getFormatoEntidadId());
			st1.registerOutParameter(4, java.sql.Types.DOUBLE);
			st1.execute();
			con.commit();

			orden.setMontoPago(st1.getDouble(4));
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

	public void registrarAdjunto(BeanOrden orden, BeanAdjunto adjunto) {
		CallableStatement st1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL adjunto_registra_x_orden(?,?,?,?)");
			st1.setInt(1, orden.getOrdenId());
			st1.setInt(2, orden.getMto());
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

	public void registrarUsuarioFormatoSolicitante(BeanOrden orden, BeanUsuario usuario) {
		registrarUsuarioFormato(1, orden, usuario);
	}

	private void registrarUsuarioFormato(int usuarioFormatoTipo, BeanOrden orden, BeanUsuario usuario) {
		CallableStatement st1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL usuario_formato_registra(?,?,?,?,?)");
			st1.setInt(1, usuarioFormatoTipo);
			st1.setInt(2, orden.getOrdenId());
			st1.setInt(3, orden.getMto());
			st1.setString(4, usuario.getRuc());
			st1.setString(5, usuario.getUsuarioSol());
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
			st1 = con.prepareStatement("select o.orden_id, o.orden, o.fecha_registro, o.bloqueada, o.cerrada, f.formato from orden o, tce t, formato f where f.formato_id = t.formato_id and t.orden_id = o.orden_id and o.orden_id = ?");
			st1.setInt(1, ordenId);
			rs = st1.executeQuery();
			if (rs.next()) {
				orden = new BeanOrden();
				orden.setOrdenId(rs.getInt(1));
				orden.setOrden(rs.getLong(2));
				orden.setFormato(rs.getString(6));
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
		PreparedStatement st1 = null;
		ResultSet rs = null;
		BeanUsuario usuario = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select usuario_id, ruc, usuario_sol from usuario_formato where orden_id = ? and mto = (select mto from mto where orden_id = ? and vigente = 'S' and etapa_tramite = 1)");
			st1.setInt(1, ordenId);
			st1.setInt(2, ordenId);
			rs = st1.executeQuery();
			if (rs.next()) {
				usuario = new BeanUsuario();
				usuario.setUsuarioId(rs.getInt(1));
				usuario.setRuc(rs.getString(2));
				usuario.setUsuarioSol(rs.getString(3));
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
		return usuario;
	}

	//digesa

	public BeanDgs015 buscarDgs015PorOrdenId(int ordenId) {
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		BeanDgs015 dgs015 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Registra la tasa
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			//formato entidad
			st1 = con.prepareStatement("select dgs015_id, dgs_tipo_producto from dgs015 where orden_id = ? and mto = (select mto from mto where orden_id = ? and vigente = 'S' and etapa_tramite = 1)");
			st1.setInt(1, ordenId);
			st1.setInt(2, ordenId);
			rs1 = st1.executeQuery();
			if (rs1.next()) {
				dgs015 = new BeanDgs015();
				dgs015.setDgs015Id(rs1.getInt(1));
				dgs015.setDgsTipoProducto(rs1.getInt(2));
			}
			//formato entidad detalle
			if (dgs015 != null) {
				st2 = con.prepareStatement("select dgs015_id, sec_producto, nombre, partida_arancelaria, cantidad, envase from dgs015_producto where dgs015_id = ?");
				st2.setInt(1, dgs015.getDgs015Id());
				rs2 = st2.executeQuery();
				ArrayList<BeanDgs015Producto> listaDgs015Producto = new ArrayList<BeanDgs015Producto>();
				while (rs2.next()) {
					BeanDgs015Producto dgs015Producto = new BeanDgs015Producto();
					dgs015Producto.setDgs015Id(rs2.getInt(1));
					dgs015Producto.setSecProducto(rs2.getInt(2));
					dgs015Producto.setNombre(rs2.getString(3));
					dgs015Producto.setPartidaArancelaria(rs2.getString(4));
					dgs015Producto.setCantidad(rs2.getInt(5));
					dgs015Producto.setEnvase(rs2.getString(6));
					listaDgs015Producto.add(dgs015Producto);
				}
				dgs015.setListaDgs015Producto(listaDgs015Producto);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (st1 != null) {
					st1.close();
				}
				if (rs2 != null) {
					rs2.close();
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
		return dgs015;
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
				dgs015Producto.setSecProducto(st2.getInt(6));
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
