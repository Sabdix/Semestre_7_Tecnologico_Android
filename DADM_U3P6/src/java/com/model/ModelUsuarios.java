
package com.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author sabdi
 */
public class ModelUsuarios {
    Connection conexion;
    Statement comando;
    
    public ModelUsuarios() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myos", "root", null);
        comando = (Statement) conexion.createStatement();
    }
    
    public boolean existeUsuario(String usr, String pass) throws Exception{
        String qry = "SELECT 1 FROM usuarios WHERE usuario='"+usr+"' "
                + "AND pass=SHA1('"+pass+"')";
        
        ResultSet rs = comando.executeQuery(qry);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void insertarUsuario(String usr, String pass, String nombre, String correo) throws Exception {
        String qry = "INSERT INTO usuarios VALUES('"+usr+"', SHA1('"+pass+"'), '"+nombre+"', '"+correo+"')";
        
        comando.executeUpdate(qry);
        
    }
}
