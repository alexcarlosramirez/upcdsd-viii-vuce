package net.dsd.sce.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dsd.sce.bean.vistas.BeanLista;
import net.dsd.sce.excepcion.DAOExcepcion;
import net.dsd.sce.rest.gestion.GestionListas;
import net.sf.json.JSONArray;

@Path("/listas")
public class ListasRest {

	@GET
	@Path("{tipoLista}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarLista(@PathParam("tipoLista") int tipoLista) {
		System.out.println("Dentro de buscarListaSolicitudes() / tipoLista / " + tipoLista);
		JSONArray arrayObj = new JSONArray();
		
		try {
			GestionListas gestionBandeja = new GestionListas();
			if (tipoLista == 1) {
				ArrayList<BeanLista> listaEntidades = gestionBandeja.buscarListaEntidades();
				arrayObj.addAll(listaEntidades);
			}
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}

	@GET
	@Path("{tipoLista}/{criterio1}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarLista(@PathParam("tipoLista") int tipoLista, @PathParam("criterio1") String criterio1) {
		System.out.println("Dentro de buscarListaSolicitudes() / tipoLista / " + tipoLista);
		JSONArray arrayObj = new JSONArray();
		
		try {
			GestionListas gestionBandeja = new GestionListas();
			if (tipoLista == 2) {
				ArrayList<BeanLista> listaEntidades = gestionBandeja.buscarListaFormatoPorEntidad(Integer.valueOf(criterio1));
				arrayObj.addAll(listaEntidades);
			}
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}
}
