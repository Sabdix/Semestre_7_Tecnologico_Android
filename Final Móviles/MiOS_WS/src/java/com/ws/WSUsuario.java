package com.ws;

import com.modelos.ModeloUsuarios;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alexander
 */
@Path("wsusuario")
public class WSUsuario {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSUsuario
     */
    public WSUsuario() {
    }

    /**
     * Retrieves representation of an instance of com.ws.WSUsuario
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() 
    {
        return "WS Usuario en ejecución";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login/{usr}/{pass}")
    public String login(@PathParam("usr")String usr, @PathParam("pass")String pass) 
    {
        try 
        {
            ModeloUsuarios modelo = new ModeloUsuarios();
            if(modelo.login(usr, pass))
            {
                return "true";
            }
            else
            {
                return "false";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error.\n" + e.getMessage();
        }
    }

}
