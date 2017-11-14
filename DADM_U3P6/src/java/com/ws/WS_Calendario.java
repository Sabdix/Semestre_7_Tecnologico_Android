
package com.ws;

import com.entities.Calendario_Eventos;
import com.model.ModelCalendario;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sabdi
 */
@Path("calendario")
public class WS_Calendario {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eventos/{mes}")
    public String eventos(@PathParam("mes")String mes) {
        try {
            ModelCalendario model = new ModelCalendario();
            ArrayList<Calendario_Eventos> eventos = model.mostrarEventosMes(mes);
            
            JsonObjectBuilder builder = Json.createObjectBuilder();
            int conteo = 1;
            for (Calendario_Eventos evt : eventos) {
                builder.add("evento" + conteo, evt.getDia());
                conteo++;
            }
            JsonObject json = builder.build();
            
            if(eventos.size() > 0) {
                return json.toString();
            } else {
                throw new Exception ("Error, no hay eventos daaaa");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al Mostrar Eventos.\n"+e.getMessage();
        }
    }
}
