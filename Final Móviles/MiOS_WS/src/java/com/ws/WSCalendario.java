package com.ws;

import com.entidades.Calendario_Eventos;
import com.modelos.ModelCalendario;
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
 * @author Alexander
 */
@Path("ws_calendario")
public class WSCalendario 
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eventos/{mes}")
    public String eventos(@PathParam("mes")String mes)
    {
        try 
        {
            ModelCalendario model = new ModelCalendario();
            ArrayList<Calendario_Eventos> eventos = model.mostrarEventosMes(mes);
            
            //Comienzos del json
            int numEvt = 1;
            JsonObjectBuilder builder = Json.createObjectBuilder();
            for(Calendario_Eventos evt : eventos)
            {
                builder.add("evento" + numEvt, evt.getDia());
                numEvt++;
            }
            JsonObject json = builder.build();
            
            if(eventos.size() > 0)
            {
                return json.toString();
            }
            else
            {
                throw new Exception("No hay eventos en este mes");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al leer eventos.\n" + e.getMessage();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("evento/{mes}/{dia}")
    public String evento(@PathParam("mes")String mes, @PathParam("dia")String dia)
    {
        try 
        {
            ModelCalendario model = new ModelCalendario();
            Calendario_Eventos evento = model.mostrarEvento(mes, dia);
            
            if(evento != null)
            {
                //Json
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder.add("id", evento.getId());
                builder.add("mes", evento.getMes());
                builder.add("dia", evento.getDia());
                builder.add("nombre_evento", evento.getNombre_evento());
                builder.add("desc_evento", evento.getDesc_evento());
                builder.add("hora", evento.getHora());
                builder.add("ubicacion", evento.getUbicacion());
                
                return builder.build().toString();
            }
            else
            {
                throw new Exception("Error. No hay evento");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return "Error al leer el evento.\n" + e.getMessage();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("guardarEvento/{comando}/{id}/{dia}/{mes}/{nombre_evento}/{desc_evento}/{ubicacion}/{hora}")
    public String guardarEvento(@PathParam("comando")String comando, @PathParam("id")String id ,@PathParam("dia")String dia, @PathParam("mes")String mes, @PathParam("nombre_evento")String nombre_evento, 
            @PathParam("desc_evento")String desc_evento, @PathParam("ubicacion")String ubicacion, @PathParam("hora")String hora)
    {
        try 
        {
            ModelCalendario model = new ModelCalendario();
                 
            if(model.guardarEvento(comando ,id ,nombre_evento, desc_evento, dia, mes, ubicacion, hora))
            {
                
                
                return "Ubicación guardada correctamente!";
            }
            else
            {
                return "El evento no se guardo";
            }
        }
        catch (Exception e) 
        {
            System.err.println("Error al ejecutar el WS para guardar evento.\n" + e.getMessage());
            return "No se guardo el evento" + e.getMessage();
        }
    }
}
