package com.modelos;

import com.entidades.Reproductor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class ModelReproductor
{
    Connection conexion;
    Statement comando;
    
    public ModelReproductor() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/miso",
            "root", null
        );
        comando = (Statement) conexion.createStatement();
    }
    
    public ArrayList<Reproductor> listadoCanciones() throws Exception
    {
        String qry = "SELECT * FROM reproductor";
        
        ResultSet rs = comando.executeQuery(qry);
        
        ArrayList<Reproductor> canciones = new ArrayList<>();
        while(rs.next())
        {
            Reproductor cancion = new Reproductor();
            cancion.setId(rs.getInt("id"));
            cancion.setCancion(rs.getString("cancion"));
            cancion.setAlbum(rs.getString("album"));
            cancion.setInterprete(rs.getString("interprete"));
            
            canciones.add(cancion);
        }
        
        return canciones;
    }
    
}
