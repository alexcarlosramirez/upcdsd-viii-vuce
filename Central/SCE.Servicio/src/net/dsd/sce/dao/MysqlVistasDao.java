package net.dsd.sce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import net.dsd.sce.bean.vistas.BeanLista;
import net.dsd.sce.bean.vistas.BeanSolBandeja;
import net.dsd.sce.conexion.ConexionBD;
import net.dsd.sce.excepcion.DAOExcepcion;

public class MysqlVistasDao {


	public ArrayList<BeanSolBandeja> buscarListaSolicitudesPorEstadoEntidadId(String etapa, int entidadId) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		ArrayList<BeanSolBandeja> listaSolBandeja = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select * from v_solicitud where if( ? != 'T', etapa = ?, etapa IN ('O','S','D')) and if( ? != 0, entidad_id = ?, entidad_id != 0)");
			st1.setString(1, etapa);
			st1.setString(2, etapa);
			st1.setInt(3, entidadId);
			st1.setInt(4, entidadId);
			rs = st1.executeQuery();
			listaSolBandeja = new ArrayList<BeanSolBandeja>();
			while (rs.next()) {
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(rs.getDate(3).getTime());
				BeanSolBandeja solBandeja = new BeanSolBandeja();
				solBandeja.setNumero(rs.getLong(1));
				solBandeja.setEntidadId(rs.getInt(2));
				solBandeja.setFechaRegistro((new SimpleDateFormat("dd/MM/yyyy HH:mm").format(gc.getTime())));
				solBandeja.setFormato(rs.getString(4));
				solBandeja.setEntidad(rs.getString(5));
				solBandeja.setEstado(rs.getString(6));
				solBandeja.setEtapaTramite(rs.getString(7));
				listaSolBandeja.add(solBandeja);
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
		return listaSolBandeja;
	}

	public ArrayList<BeanLista> buscarListaFormatoPorEntidad(int entidadId) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		ArrayList<BeanLista> lista = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select formato_id, formato from formato where entidad_id = ?");
			st1.setInt(1, entidadId);
			rs = st1.executeQuery();
			lista = new ArrayList<BeanLista>();
			while (rs.next()) {
				BeanLista elLista = new BeanLista();
				elLista.setValor(rs.getInt(1));
				elLista.setTexto(rs.getString(2));
				lista.add(elLista);
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
		return lista;
	}

	public ArrayList<BeanLista> buscarListaEntidades() throws DAOExcepcion {
		Connection con = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		ArrayList<BeanLista> lista = null;

		try {
			con = ConexionBD.obtenerConexion();
			con.setAutoCommit(false);
			st1 = con.prepareStatement("select entidad_id, entidad from entidad where estado = 'A'");
			rs = st1.executeQuery();
			lista = new ArrayList<BeanLista>();
			while (rs.next()) {
				BeanLista elLista = new BeanLista();
				elLista.setValor(rs.getInt(1));
				elLista.setTexto(rs.getString(2));
				lista.add(elLista);
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
		return lista;
	}
}
