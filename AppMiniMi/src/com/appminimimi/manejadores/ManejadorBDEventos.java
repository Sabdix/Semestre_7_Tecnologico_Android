/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appminimimi.manejadores;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class ManejadorBDEventos extends SQLiteOpenHelper{

    public ManejadorBDEventos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) 
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
            "CREATE TABLE agendaEventos ("+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "FECHA TEXT NOT NULL,"+
                "NOMBRE TEXT NOT NULL,"+
                "HORA TEXT,"+
                "LUGAR TEXT"+
            ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
    
    public void agregarEvento(String fecha, String nombre, String hora, String lugar) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(
                "INSERT INTO agendaEventos(FECHA, NOMBRE, HORA, LUGAR)"
                + " VALUES("
                + "'" + fecha + "','" + nombre + "','" + hora + "','" + lugar +"')"
        );
        db.close();
    }
    
        public ArrayList<String> buscarTodosEventos(){
        ArrayList<String> resultados = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor apuntador = db.rawQuery(
            "SELECT * FROM agendaEventos",
            null
        );
        while(apuntador.moveToNext())
        {
            resultados.add(
                apuntador.getInt(0)+"%"+
                apuntador.getString(1)+"%"+
                apuntador.getString(2)+"%"+
                apuntador.getString(3)+"%"+
                apuntador.getString(4)+"%"
            );
        }
        apuntador.close();
        db.close();
        return resultados;
    }
}
