package com.ws;

import com.entidades.Notas;
import com.modelos.ModelNotas;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alexander
 */
@Path("wsnotas")
public class WSNotas 
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String allNotas()
    {
        try 
        {
            ModelNotas model = new ModelNotas();
            ArrayList<Notas> notas = model.muestraNotas();
            
            JsonObjectBuilder builder = Json.createObjectBuilder();
            int numNotas = 1;
            for(Notas nota : notas)
            {
                JsonArrayBuilder jab = Json.createArrayBuilder();
                jab.add(nota.getId());
                jab.add(nota.getTitulo());
                jab.add(nota.getContenido());
                
                builder.add("nota" +  numNotas, jab);
                numNotas++;
            }
            
            return builder.build().toString();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return "Error, no hay notas. " + e.getMessage();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminaNota/{id}")
    public String eliminaNota(@PathParam("id")String id)
    {
        try 
        {
            ModelNotas model = new ModelNotas();
            if(model.eliminarNota(id))
            {
                return "Nota eliminada correctamente!";
            }
            else
            {
                return "La nota no se elimino";
            }
        }
        catch (Exception e)
        {
            System.err.println("Error al ejecutar el WS para eliminar notas.\n" + e.getMessage());
            return "No se elimino la nota";
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("guardarNota/{comando}/{id}/{titulo}/{contenido}")
    public String eliminaNota(@PathParam("comando")String comando, @PathParam("id")String id, @PathParam("titulo")String titulo, @PathParam("contenido")String contenido)
    {
        try 
        {
            ModelNotas model = new ModelNotas();
            if(model.guardarNota(comando, id, titulo, contenido))
            {
                return "Nota guardada correctamente!";
            }
            else
            {
                return "La nota no se guardo";
            }
        }
        catch (Exception e)
        {
            System.err.println("Error al ejecutar el WS para guardar notas.\n" + e.getMessage());
            return "No se guardo la nota" + e.getMessage();
        }
    }
    
}
