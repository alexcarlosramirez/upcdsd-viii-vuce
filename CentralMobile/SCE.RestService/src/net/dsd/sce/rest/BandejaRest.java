package net.dsd.sce.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dsd.sce.bean.vistas.BeanSolBandeja;
import net.dsd.sce.excepcion.DAOExcepcion;
import net.dsd.sce.rest.gestion.GestionBandeja;
import net.sf.json.JSONArray;

@Path("/bandejas")
public class BandejaRest {
	
	@GET
	@Path("{tipoBandeja}/entidades/{entidadId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarListaSolicitudes(@PathParam("tipoBandeja") String tipoBandeja, @PathParam("entidadId") int entidadId) {
		System.out.println("Dentro de buscarListaSolicitudes()" + " / tipoBandeja / " + tipoBandeja + " / entidadId / " + entidadId);
		JSONArray arrayObj = new JSONArray();
		
		try {
			GestionBandeja gestionBandeja = new GestionBandeja();
			ArrayList<BeanSolBandeja> listaSolbandeja = gestionBandeja.buscarListaSolicitudesPorEstadoEntidadId(tipoBandeja, entidadId);
			arrayObj.addAll(listaSolbandeja);
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}
	
	/*
	@Path("/productos")
	public class ProductosRest {
		
		@GET
		//@Path("{nombre}/{fecha}")
		@Path("{nombre}")
		@Produces(MediaType.APPLICATION_JSON)
		//public String buscarPorNombre( @PathParam("nombre") String nombre, @PathParam("fecha") String fecha ) {
		public String buscarPorNombre( @PathParam("nombre") String nombre ) {

			System.out.println("Dentro de buscarPorNombre() : nombre: " + nombre);
			JSONArray arrayObj = new JSONArray();
			
			try {
				GestionProductos negocio = new GestionProductos();
				Collection<Producto> productos =  negocio.buscarPorNombre(nombre);
				System.out.println(productos.size());
				arrayObj.addAll(productos);
				
			} catch (DAOExcepcion e) {	
				System.out.println(e.getMessage());
			}
			return arrayObj.toString();
		}
	

	@GET
	@Path("/producto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String obtenerPorId( @PathParam("id") int idProducto ) {		

		System.out.println("Dentro de obtenerPorId()");
		JSONObject jsonObj = new JSONObject();
		
		try {
			GestionProductos negocio = new GestionProductos();
			Producto producto =  negocio.obtenerPorId(idProducto);
			System.out.println(producto.getNombre());
			jsonObj.put("idProducto", producto.getIdProducto());
			jsonObj.put("nombre", producto.getNombre());
			jsonObj.put("precio", producto.getPrecio());
						
		} catch (DAOExcepcion e) {	
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	//public String insertar(Producto producto) {		
	public String insertar(@FormParam("idCategoria") int idCategoria, 
							@FormParam("nombre") String nombre, 
							@FormParam("precio") double precio) {

		System.out.println("Dentro de insertar(): " + nombre);

		JSONObject jsonObj = new JSONObject();
		
		try {
			GestionProductos negocio = new GestionProductos();
			
			Producto vo = new Producto();
			Categoria cvo = new Categoria();
			cvo.setIdCategoria(idCategoria);
			vo.setCategoria(cvo);
			vo.setNombre(nombre);
			vo.setPrecio(precio);
			
			vo = negocio.insertar(vo);
			System.out.println(vo.getIdProducto());
			jsonObj.put("estado", "CORRECTO");
						
		} catch (DAOExcepcion e) {
			jsonObj.put("estado", "FALLIDO");
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	@DELETE
	@Path("/producto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminar( @PathParam("id") int idProducto ) {		

		System.out.println("Dentro de eliminar(): ");
		
		JSONObject jsonObj = new JSONObject();
		
		try {
			GestionProductos negocio = new GestionProductos();
			negocio.eliminar(idProducto);
			jsonObj.put("estado", "CORRECTO");
						
		} catch (DAOExcepcion e) {	
			jsonObj.put("estado", "FALLIDO");
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	@PUT
	@Path("{idProducto}/{nombre}/{precio}")
	@Produces(MediaType.APPLICATION_JSON)
	public String actualizar( @PathParam("idProducto") int idProducto, @PathParam("nombre") String nombre, @PathParam("precio") double precio) {		

		System.out.println("Dentro de actualizar()");
				
		JSONObject jsonObj = new JSONObject();
		
		try {
			GestionProductos negocio = new GestionProductos();
			
			Producto vo = new Producto();
			vo.setIdProducto(idProducto);
			vo.setNombre(nombre);	
			vo.setPrecio(precio);
			
			negocio.actualizar(vo);
			jsonObj.put("estado", "CORRECTO");
						
		} catch (DAOExcepcion e) {
			jsonObj.put("estado", "FALLIDO");
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	*/
}
