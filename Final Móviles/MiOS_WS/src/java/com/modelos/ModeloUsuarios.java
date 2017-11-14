package com.modelos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Alexander
 */
public class ModeloUsuarios 
{
    Connection conexion;
    Statement comando;
    
    public ModeloUsuarios() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/miso",
            "root",
            null
        );
        comando = (Statement) conexion.createStatement();
    }
    
    public boolean login(String usr, String pass) throws Exception
    {
        String qry = "SELECT 1 FROM usuarios WHERE usuario='";
        qry += usr + "' AND pass=SHA1('" + pass + "')";
        
        ResultSet rs = comando.executeQuery(qry);
        
        if(rs.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}

