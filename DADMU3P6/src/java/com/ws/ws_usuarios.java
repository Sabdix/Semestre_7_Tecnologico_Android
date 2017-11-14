/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws;

import com.Model.ModelUsuarios;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author supernona
 */
@Path("ws_usuarios")
public class ws_usuarios {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ws_usuarios
     */
    public ws_usuarios() {
    }

    /**
     * Retrieves representation of an instance of com.ws.ws_usuarios
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hola Mundo";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login/{usuario}/{contra]")
    public String login(@PathParam("usuario")String usuario, @PathParam("contra")String contra){
        try {
            ModelUsuarios model= new ModelUsuarios();
            return ""+model.existeUsuario(usuario, contra);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: "+e.getMessage();
        }
    }
}
