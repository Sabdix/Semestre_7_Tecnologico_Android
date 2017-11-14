/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sabdi
 */
public class ModeloBD extends SQLiteOpenHelper {
    public ModeloBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE casas("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "ninos INTEGER NOT NULL)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    
    public ArrayList<Casa> listarCasas() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Casa> productos = new ArrayList<Casa>();
        
        String qry = "SELECT * FROM casas";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Casa p = new Casa();
            p.setId(miCursor.getInt(0));
            p.setNinos(miCursor.getInt(1));
            productos.add(p);
        }
        db.close();
        return productos;
    }
    
    public void insertNinos(int ninos) {
        SQLiteDatabase db = this.getWritableDatabase();
        Date fecha = new Date();
        String qry = "INSERT INTO casas(ninos) VALUES('"+ninos+"')";
        db.execSQL(qry);
        db.close();
    }
    
    public int calcularPromedio() throws Exception{
        int total, sumaNino;
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "SELECT COUNT(*) FROM casas";
        Cursor miCursor;
        miCursor = db.rawQuery(qry, null);
        miCursor.moveToFirst();
        total = miCursor.getInt(0);
        qry = "SELECT COUNT(*) FROM casas WHERE ninos >= 1";
        miCursor = db.rawQuery(qry, null);
        miCursor.moveToFirst();
        sumaNino = miCursor.getInt(0);
        db.close();
        
        return sumaNino * 100/total;
        


    }
    /*
    public void setDetalle(int id, int cantidad, int precio) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "INSERT INTO detalle(id_factura, id_producto, cantidad, precio) "
                + "VALUES((SELECT MAX(id) FROM factura), '"+id+"', '"+cantidad+"', '"+(precio*cantidad)+"')";
        db.execSQL(qry);
        db.close();
    }
    
    public void deleteDetalle(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "DELETE FROM detalle WHERE id="+id+"";
        db.execSQL(qry);
        db.close();
    }
    
    public void modificarProducto(int stock, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "UPDATE producto SET stock=(stock - "+stock+") "
                + "WHERE id="+id;
        db.execSQL(qry);
        db.close();
    }
    */
}
