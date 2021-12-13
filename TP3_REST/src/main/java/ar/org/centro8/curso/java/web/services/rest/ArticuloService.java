/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.web.services.rest;

import ar.org.centro8.curso.java.web.entities.Articulo;
import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.TipoArticulo;
import ar.org.centro8.curso.java.web.interfaces.connectors.Connector;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ArticuloRepository;
import com.google.gson.Gson;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/articulos/v1")
public class ArticuloService {

    private I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "Servicio articulos activo";
    }
    
    @GET
    @Path("/ArticulosAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return new Gson().toJson(ar.getAll());
    }

    @GET
    @Path("/LikeNombre")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLikeNombre(@QueryParam("nombre")String nombre){
       return new Gson().toJson(ar.getLikeNombreArticulo(nombre));
    }
    
    @GET
    @Path("/ByTipoArticulo")
    @Produces (MediaType.APPLICATION_JSON)
    public String getByTipoArticulo(@QueryParam("tipoArticulo")TipoArticulo tipoArticulo){
        return new Gson().toJson(ar.getByTipoArticulo(tipoArticulo));
    }
    
    @GET
    @Path("/LikeEspecieRecomendada")
    @Produces (MediaType.APPLICATION_JSON)
    public String getLikeEspecieRecomendada(@QueryParam("especieRecomendada")EspecieRecomendada especieRecomendada){
        return new Gson().toJson(ar.getLikeEspecieRecomendada(especieRecomendada));
    }
    
    @GET
    @Path("/ByActivo")
    @Produces (MediaType.APPLICATION_JSON)
    public String getByActivo(@QueryParam("activo")boolean activo){
        return new Gson().toJson(ar.getByActivo(activo));
    }
    
    @GET
    @Path("/ArticulosAlta")
    @Produces (MediaType.TEXT_PLAIN)
    public String save(
            @QueryParam("nombre")String nombre,
            @QueryParam("descripcion")String descripcion,
            @QueryParam("tipo")TipoArticulo tipoArticulo,
            @QueryParam("especieRecomendada")EspecieRecomendada especieRecomendada,
            @QueryParam("costo")double costo,
            @QueryParam("precio")double precio,
            @QueryParam("stock")int stock,
            @QueryParam("stockMinimo")int stockMinimo,
            @QueryParam("stockMaximo")int stockMaximo,
            @QueryParam("comentario")String comentario,
            @QueryParam("activo")boolean activo){
    
        Articulo articulo = new Articulo(
                nombre, 
                descripcion, 
                tipoArticulo, 
                especieRecomendada, 
                costo, 
                precio, 
                stock, 
                stockMinimo, 
                stockMaximo, 
                comentario, 
                activo);
        ar.save(articulo);
        return articulo.getId()+"";
    }
}

