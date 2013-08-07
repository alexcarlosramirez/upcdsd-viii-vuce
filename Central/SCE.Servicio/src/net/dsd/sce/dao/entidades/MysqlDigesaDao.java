package net.dsd.sce.dao.entidades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.dsd.sce.bean.BeanMto;
import net.dsd.sce.bean.digesa.BeanDgs015;
import net.dsd.sce.bean.digesa.BeanDgs015Producto;
import net.dsd.sce.conexion.ConexionBD;
import net.dsd.sce.excepcion.DAOExcepcion;

public class MysqlDigesaDao {

	public void modificarDgs015(BeanDgs015 dgs015, ArrayList<BeanDgs015Producto> listaDgs015Producto) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;
		CallableStatement st2 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL dgs015_modifica(?,?)");
			st1.setInt(1, dgs015.getFormatoEntidadId());
			st1.setInt(2, dgs015.getDgsTipoProducto());
			st1.execute();
			st2 = con.prepareCall("CALL dgs015_producto_registra(?,?,?,?,?,?)");
			for (BeanDgs015Producto dgs015Producto : listaDgs015Producto) {
				dgs015Producto.setDgs015Id(dgs015.getFormatoEntidadId());
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
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
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
				ex.printStackTrace();
			}
		}
	}

	public BeanDgs015 buscarDgs015PorMto(BeanMto mto) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		BeanDgs015 dgs015 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			//formato entidad
			st1 = con.prepareStatement("select dgs015_id, dgs_tipo_producto from dgs015 where orden_id = ? and mto = ?");
			st1.setInt(1, mto.getOrdenId());
			st1.setInt(2, mto.getMto());
			rs1 = st1.executeQuery();
			if (rs1.next()) {
				dgs015 = new BeanDgs015();
				dgs015.setFormatoEntidadId(rs1.getInt(1));
				dgs015.setDgsTipoProducto(rs1.getInt(2));
			}
			//formato entidad detalle
			if (dgs015 != null) {
				st2 = con.prepareStatement("select dgs015_id, sec_producto, nombre, partida_arancelaria, cantidad, envase from dgs015_producto where dgs015_id = ?");
				st2.setInt(1, dgs015.getFormatoEntidadId());
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
			ex.printStackTrace();
			throw new DAOExcepcion(ex.getMessage());
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
				ex.printStackTrace();
			}
		}
		return dgs015;
	}
}
