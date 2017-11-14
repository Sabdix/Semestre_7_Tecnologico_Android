/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ModeloBD;

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
public class ModeloBD extends SQLiteOpenHelper{

    public ModeloBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE adeudo("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "consumo INTEGER NOT NULL, "
                + "monto INTEGER NOT NULL, "
                + "fecha TEXT NOT NULL)";
        db.execSQL(qry);
        qry = "CREATE TABLE pagos("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "monto INTEGER NOT NULL, "
                + "id_adeudo INTEGER NOT NULL, "
                + "fecha TEXT NOT NULL, "
                + "FOREIGN KEY(id_adeudo) REFERENCES adeuco(id))";
        db.execSQL(qry);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    
    public void generarAdeudo(int consumo, int monto) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        Date fecha = new Date();
        String qry = "INSERT INTO adeudo(consumo, monto, fecha) VALUES ('"+consumo+"', '"+monto+"', '"+fecha.toString()+"')";
        db.execSQL(qry);
        db.close();
    }
    
    public ArrayList<Adeudo> listarAdeudos() throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor miCursor;
        ArrayList <Adeudo> ventas = new ArrayList<Adeudo>();
        
        String qry = "SELECT * FROM adeudo";
        
        miCursor = db.rawQuery(qry, null);
        while(miCursor.moveToNext()) {
            Adeudo p = new Adeudo();
            p.setId(miCursor.getInt(0));
            p.setConsumo(miCursor.getInt(1));
            p.setMonto(miCursor.getInt(2));
            p.setFecha(miCursor.getString(3));
            ventas.add(p);
        }
        db.close();
        return ventas;
    }
}
