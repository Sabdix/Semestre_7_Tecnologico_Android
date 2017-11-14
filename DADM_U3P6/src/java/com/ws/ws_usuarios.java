/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws;

import com.model.ModelUsuarios;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sabdi
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
    public String inicio() {
        return "WS usuarios en ejecucion";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login/{usr}/{pass}")
    public String login(@PathParam("usr")String usr, @PathParam("pass")String pass) {
        
        try {
            ModelUsuarios model = new ModelUsuarios();
            return "" + model.existeUsuario(usr, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: \n"+e.getMessage();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("insert/{usr}/{pass}/{nombre}/{correo}")
    public String insert(@PathParam("usr")String usr, @PathParam("pass")String pass, @PathParam("nombre")String nombre, @PathParam("correo")String correo) {
        try {
            ModelUsuarios model = new ModelUsuarios();
            model.insertarUsuario(usr, pass, nombre, correo);
            return "Exito";
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
}
