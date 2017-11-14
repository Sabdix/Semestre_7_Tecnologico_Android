/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea2.models;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import java.util.ArrayList;

/**
 *
 * @author Alejandra
 */
public class Base extends SQLiteOpenHelper {

    public Base(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE productos(";
        qry+="id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT NOT NULL, "
                + "precio INTEGER NOT NULL, cantidad INTEGER NOT NULL)";
        db.execSQL(qry);
        
        qry = "CREATE TABLE vendedores(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "nombre TEXT NOT NULL)";
        db.execSQL(qry);
        
        qry = "CREATE TABLE clientes(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "nombre TEXT NOT NULL, puntos INTEGER NOT NULL)";
        db.execSQL(qry);
        
        
        qry = "INSERT INTO productos VALUES (1, 'Leche', '12', '2')";
        db.execSQL(qry);
        
        qry = "INSERT INTO productos(nombre, precio, cantidad) VALUES('Agua', '5', '3')";
        db.execSQL(qry);
        
        qry = "INSERT INTO vendedores VALUES (1, 'Jose')";
        db.execSQL(qry);
        
        qry = "INSERT INTO vendedores(nombre) VALUES('Alex')";
        db.execSQL(qry);
        
        qry = "INSERT INTO clientes VALUES (1, 'Leo', 0)";
        db.execSQL(qry);
        
        qry = "INSERT INTO clientes(nombre, puntos) VALUES('Pablo', 0)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
    public ArrayList<Producto> listaProductos() throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList<Producto> producto = new ArrayList<Producto>();
        
        String qry = "SELECT * FROM productos";
        //String qry = "SELECT *FROM usuarios";
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()){
           Producto u = new Producto();
           u.setId(miCursor.getInt(0));
           u.setNombre(miCursor.getString(1));
           u.setPrecio(miCursor.getInt(2));
           u.setCantidad(miCursor.getInt(3));
           producto.add(u);
        }
        db.close();
        return producto;
    }
    
    public ArrayList<Cliente> listaClientes() throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList<Cliente> producto = new ArrayList<Cliente>();
        
        String qry = "SELECT * FROM clientes";
        //String qry = "SELECT *FROM usuarios";
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()){
           Cliente u = new Cliente();
           u.setId(miCursor.getInt(0));
           u.setNombre(miCursor.getString(1));
           u.setPuntos(miCursor.getInt(2));
           producto.add(u);
        }
        db.close();
        return producto;
    }
    
    public ArrayList<Vendedor> listaVendedores() throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList<Vendedor> producto = new ArrayList<Vendedor>();
        
        String qry = "SELECT * FROM vendedores";
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()){
           Vendedor u = new Vendedor();
           u.setId(miCursor.getInt(0));
           u.setNombre(miCursor.getString(1));
           producto.add(u);
        }
        db.close();
        return producto;
    }
}
