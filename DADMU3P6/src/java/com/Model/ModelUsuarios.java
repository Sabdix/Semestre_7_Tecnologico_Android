/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author supernona
 */
public class ModelUsuarios {
    Connection conexion;
    Statement comando;

    public ModelUsuarios() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webos", "root", null);
        comando = (Statement) conexion.createStatement();
    }
    
    public boolean existeUsuario(String usuario, String password)throws Exception{
        String qry = "SELECT 1 FROM usuarios WHERE usuario = '"+usuario+"' AND pass= sha1('"+password+"')";
        ResultSet rs = comando.executeQuery(qry);
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }
}
