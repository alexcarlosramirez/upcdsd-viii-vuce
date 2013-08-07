package net.dsd.sce.dao.entidades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import net.dsd.sce.bean.ficticia.BeanFrm001;
import net.dsd.sce.conexion.ConexionBD;
import net.dsd.sce.excepcion.DAOExcepcion;

public class MysqlFicticiaDao {

	public void modificarFrm001(BeanFrm001 frm001) throws DAOExcepcion {
		Connection con = null;
		CallableStatement st1 = null;
		CallableStatement st2 = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareCall("CALL dgs015_modifica(?,?,?)");
			st1.setInt(1, frm001.getFormatoEntidadId());
			st1.setString(2, frm001.getTipoMercaderia());
			st1.setString(2, frm001.getDetalleMercaderia());
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

}
