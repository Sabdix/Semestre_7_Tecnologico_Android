package com.appminimimi.manejadores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ManejadorBDContactos extends SQLiteOpenHelper
{

    public ManejadorBDContactos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) 
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) 
    {
        db.execSQL(
            "CREATE TABLE agendaContactos ("+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "NOMBRE TEXT NOT NULL,"+
                "APELLIDOS TEXT,"+
                "TELEFONO TEXT,"+
                "CORREO TEXT,"+
                "TELEFONO2 TEXT"+
            ")"
        );
//        db.execSQL(
//            "CREATE TABLE agendaEventos ("+
//                "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
//                "FECHA TEXT NOT NULL,"+
//                "NOMBRE TEXT NOT NULL,"+
//                "HORA TEXT,"+
//                "LUGAR TEXT"+
//            ")"
//        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
    {
    }
    
    //-------------------------Eventos -------------------------------------------------------
//        public void agregarEvento(String fecha, String nombre, String hora, String lugar) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL(
//                "INSERT INTO agendaEventos(FECHA, NOMBRE, HORA, LUGAR)"
//                + " VALUES("
//                + "'" + fecha + "','" + nombre + "','" + hora + "','" + lugar + "')"
//        );
//        db.close();
//    }
//
//    public ArrayList<String> buscarTodosEventos() {
//        ArrayList<String> resultados = new ArrayList<String>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor apuntador = db.rawQuery(
//                "SELECT * FROM agendaEventos",
//                null
//        );
//        while (apuntador.moveToNext()) {
//            resultados.add(
//                    apuntador.getInt(0) + "%"
//                    + apuntador.getString(1) + "%"
//                    + apuntador.getString(2) + "%"
//                    + apuntador.getString(3) + "%"
//                    + apuntador.getString(4) + "%"
//            );
//        }
//        apuntador.close();
//        db.close();
//        return resultados;
//    }
    //--------------------------------------------------------------------------------
    
    public String buscarContacto(String id)
    {
        String resultado = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor apuntador = db.rawQuery(
            "SELECT * FROM agendaContactos WHERE ID="+id, 
            null
        );
        if(apuntador.moveToNext())
        {
            resultado = apuntador.getInt(0)+"%"+
                    apuntador.getString(1)+"%"+
                    apuntador.getString(2)+"%"+
                    apuntador.getString(3)+"%"+
                    apuntador.getString(4)+"%"+
                    apuntador.getString(5);
        }
        apuntador.close();
        db.close();
        return resultado;
    }
    
     public ArrayList<String> buscarCon(String id)
    {
        ArrayList<String> resultados = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor apuntador = db.rawQuery(
        		"SELECT * FROM agendaContactos WHERE ID="+id,
                null
        );
        while(apuntador.moveToNext())
        {
            resultados.add(
                apuntador.getInt(0)+"%"+
                apuntador.getString(1)+"%"+
                apuntador.getString(2)+"%"+
                apuntador.getString(3)+"%"+
                apuntador.getString(4)+"%"+
                apuntador.getString(5)
            );
        }
        apuntador.close();
        db.close();
        return resultados;
    }
    
    public ArrayList<String> buscarTodos()
    {
        ArrayList<String> resultados = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor apuntador = db.rawQuery(
            "SELECT * FROM agendaContactos ORDER BY NOMBRE COLLATE NOCASE ASC",
            null
        );
        while(apuntador.moveToNext())
        {
            resultados.add(
                apuntador.getInt(0)+"%"+
                apuntador.getString(1)+"%"+
                apuntador.getString(2)+"%"+
                apuntador.getString(3)+"%"+
                apuntador.getString(4)+"%"+
                apuntador.getString(5)
            );
        }
        apuntador.close();
        db.close();
        return resultados;
    }
    
        public ArrayList<String> buscarPorPatron(String patron){
        ArrayList<String> resultados = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor apuntador = db.rawQuery(
            "SELECT * FROM agendaContactos WHERE NOMBRE LIKE '%"+patron+"%' OR APELLIDOS LIKE '%"+patron+"%'",
            null
        );
        while(apuntador.moveToNext())
        {
            resultados.add(
                apuntador.getInt(0)+"%"+
                apuntador.getString(1)+"%"+
                apuntador.getString(2)+"%"+
                apuntador.getString(3)+"%"+
                apuntador.getString(4)+"%"+
                apuntador.getString(5)
            );
        }
        apuntador.close();
        db.close();
        return resultados;
    }
    
    public void agregarContacto(String nombre, String ape, String tel, String correo, String tel2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(
            "INSERT INTO agendaContactos(NOMBRE, APELLIDOS, TELEFONO, CORREO, TELEFONO2)"+
            " VALUES("+
                "'"+nombre+"','"+ape+"','"+tel+"','"+correo+"','"+tel2+"'"+
            ")"
        );
        db.close();
    }
    
    public void borrarContacto(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(
            "DELETE FROM agendaContactos WHERE ID="+id
        );
        db.close();
    }
    
    public void modificaContacto(String id, String nombre, String ape, String tel, String correo, String tel2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(
            "UPDATE agendaContactos SET NOMBRE='"+nombre+"', "+
                "APELLIDOS='"+ape+"', TELEFONO='"+tel+"', "+
                "CORREO='"+correo+"', TELEFONO2='"+tel2+"' "+
            " WHERE ID="+id
        );
        db.close();
    }
    
}