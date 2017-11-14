package com.ws;

import com.entidades.Reproductor;
import com.modelos.ModelReproductor;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alexander
 */
@Path("wsreproductor")
public class WSReproductor 
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String cancionero()
    {
        try 
        {
            ModelReproductor reproductor = new ModelReproductor();
            ArrayList<Reproductor> canciones = reproductor.listadoCanciones();
            
            JsonObjectBuilder builder = Json.createObjectBuilder();
            int numCancion = 1;
            for(Reproductor cancion : canciones)
            {
                JsonArrayBuilder array = Json.createArrayBuilder();
                array.add(cancion.getId());
                array.add(cancion.getCancion());
                array.add(cancion.getAlbum());
                array.add(cancion.getInterprete());
                
                builder.add("cancion" +  numCancion, array);
                numCancion++;
            }
            
            return builder.build().toString();
        }
        catch (Exception e)
        {
            System.err.println("Error al consultar las canciones.\n" + e.getMessage());
            return "Error. No se encontraron canciones";
        }
    }
}
