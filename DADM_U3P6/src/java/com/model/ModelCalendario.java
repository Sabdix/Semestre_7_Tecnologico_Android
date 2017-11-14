
package com.model;

import com.entities.Calendario_Eventos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class ModelCalendario {
    Connection conexion;
    Statement comando;
    
    public ModelCalendario() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myos", "root", null);
        comando = (Statement) conexion.createStatement();
    }
    
    public ArrayList<Calendario_Eventos> mostrarEventosMes(String mes) throws Exception {
        String qry = "SELECT dia FROM calendario_eventos WHERE mes=" + mes;
        
        ResultSet rs  = comando.executeQuery(qry);
        ArrayList<Calendario_Eventos> eventos = new ArrayList<Calendario_Eventos>();
        while (rs.next()) {
            Calendario_Eventos evento = new Calendario_Eventos();
            evento.setDia(rs.getInt("dia"));
            eventos.add(evento);
        }
        
        return eventos;    
    }
}
