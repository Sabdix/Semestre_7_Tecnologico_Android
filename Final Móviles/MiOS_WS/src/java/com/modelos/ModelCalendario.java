package com.modelos;

import com.entidades.Calendario_Eventos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class ModelCalendario 
{
    Connection conexion;
    Statement comando;
    
    public ModelCalendario() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/miso",
            "root", null
        );
        comando = (Statement) conexion.createStatement();
    }
    
    public boolean guardarEvento(String comandos ,String id , String titulo, String contenido, String dia, String mes, String ubicacion, String hora)throws Exception {
        String qry;
        if (comandos.equalsIgnoreCase("update")) {
            qry = "UPDATE calendario_eventos SET nombre_evento='"+titulo+"', desc_evento='"+contenido+"' WHERE id="+id+"";
            return (comando.executeUpdate(qry) > 0);
        } else {
            qry = "INSERT INTO calendario_eventos (dia, mes, nombre_evento, desc_evento, ubicacion, hora) VALUES ("+dia+", "+mes+", "
                + "'"+titulo+"', '"+contenido+"', '"+ubicacion+"', '"+hora+"')";
            return (comando.executeUpdate(qry) > 0);
        }
    } 
    
    public ArrayList<Calendario_Eventos> mostrarEventosMes(String mes) throws Exception
    {
        String qry = "SELECT dia FROM calendario_eventos WHERE mes=" + mes;
        
        ResultSet rs = comando.executeQuery(qry);
        
        ArrayList<Calendario_Eventos> eventos = new ArrayList<>();
        while(rs.next())
        {
            Calendario_Eventos evento = new Calendario_Eventos();
            evento.setDia(rs.getInt("dia"));
            
            eventos.add(evento);
        }
        
        return eventos;
    }
    
    public Calendario_Eventos mostrarEvento(String mes, String dia) throws Exception
    {
        String qry = "SELECT * FROM calendario_eventos WHERE mes=" + mes;
        qry += " AND dia = " + dia;
        
        ResultSet rs = comando.executeQuery(qry);
        
        if(rs.next())
        {
            Calendario_Eventos evento = new Calendario_Eventos();
            evento.setId(rs.getInt("id"));
            evento.setMes(rs.getInt("mes"));
            evento.setDia(rs.getInt("dia"));
            evento.setNombre_evento(rs.getString("nombre_evento"));
            evento.setDesc_evento(rs.getString("desc_evento"));
            evento.setHora(rs.getString("hora"));
            evento.setUbicacion(rs.getString("ubicacion"));
            
            return evento;
        }
        else
        {
            throw new Exception("No hay evento");
        }
    }
    
}
