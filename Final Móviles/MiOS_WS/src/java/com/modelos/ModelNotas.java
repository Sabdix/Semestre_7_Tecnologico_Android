package com.modelos;

import com.entidades.Notas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class ModelNotas 
{
    Connection conexion;
    Statement comando;
    
    public ModelNotas() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/miso",
            "root", null
        );
        comando = (Statement) conexion.createStatement();
    }
    
    public boolean guardarNota(String com, String id, String titulo, String contenido)throws Exception {
        String qry;
        if (com.equalsIgnoreCase("update")) {
            qry = "UPDATE notas SET titulo='"+titulo+"', contenido='"+contenido+"' WHERE id="+id+"";
            return (comando.executeUpdate(qry) > 0);
        } else {
             qry = "INSERT INTO notas (titulo, contenido) VALUES ('"+titulo+"', '"+contenido+"')";
            return (comando.executeUpdate(qry) > 0);
        }
    }
    
    public ArrayList<Notas> muestraNotas() throws Exception
    {
        String qry = "SELECT * FROM notas";
        
        ResultSet rs = comando.executeQuery(qry);
        
        ArrayList<Notas> notas = new ArrayList<>();
        while(rs.next())
        {
            Notas nota = new Notas();
            nota.setId(rs.getInt("id"));
            nota.setTitulo(rs.getString("titulo"));
            nota.setContenido(rs.getString("contenido"));
            
            notas.add(nota);
        }
        return notas;
    }
    
    public boolean eliminarNota(String id) throws Exception
    {
        String qry = "DELETE FROM notas WHERE id=" + id;
        
        return (comando.executeUpdate(qry) > 0);
    }
    
}
