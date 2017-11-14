/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Activities;

import android.app.Activity;
import android.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.tarea2.adaptadores.AdaptadorCompra;
import com.tarea2.adaptadores.AdaptadorProd;
import com.tarea2.models.Base;
import com.tarea2.models.Cliente;
import com.tarea2.models.Producto;
import com.tarea2.models.Vendedor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandra
 */
public class Tercero extends Activity {

    
    String cadena="";
    ArrayList<Cliente> listaC;
    String [] array;
    ArrayAdapter adaptador;
    
    
    ArrayList<Producto> productos =new ArrayList<Producto>();
    Producto p;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.tercero);
        
        try {
            Spinner lista = (Spinner)findViewById(R.id.spClientes);
            listaC = Tarea2U2.bd.listaClientes();
            for(int i=0; i < listaC.size(); i++){
                cadena+=listaC.get(i).getNombre()+",";
            }
            array = cadena.split(",");
            adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
            //adaptador
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            lista.setAdapter(adaptador);
        
            //Toast.makeText(this, cadena, 1).show();
            // ToDo add your GUI initialization code here        
        } catch (Exception ex) {
            Toast.makeText(this, "No se puede poner en el spinner"+ex, 1).show();
            Logger.getLogger(Segundo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            hacerLista();
        } catch (Exception ex) {
            Toast.makeText(this, "Error al listar "+ex, 1).show();
            Logger.getLogger(Tercero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }
    
    public void hacerLista() throws Exception{
        try{
            ListView listaCompra = (ListView)findViewById(R.id.lvListaCompra);
        
        SQLiteDatabase db = Tarea2U2.bd.getReadableDatabase();
        Cursor miCursor;
        final ArrayList<Producto> productos = new ArrayList<Producto>();
        
        String qry = "SELECT * FROM productos";
        //String qry = "SELECT *FROM usuarios";
        miCursor = db.rawQuery(qry, null);
        
        if(miCursor.moveToFirst()){
            do{
                Producto u = new Producto();
               u.setId(miCursor.getInt(0));
               u.setNombre(miCursor.getString(1));
               u.setPrecio(miCursor.getInt(2));
               u.setCantidad(miCursor.getInt(3));
               productos.add(u);
            }while(miCursor.moveToNext());
        }
        db.close();
        
        AdaptadorCompra adap = new AdaptadorCompra(this, productos, R.layout.rengloncomprar) {
            @Override
            public void renglonLista(View view, int pos) {
                TextView nombre = (TextView)findViewById(R.id.tvNombre);
                TextView precio = (TextView)findViewById(R.id.tvPrecio);
                TextView cantidad = (TextView)findViewById(R.id.tvCantidad);
                
                EditText comprados = (EditText)findViewById(R.id.etCuantos);
                CheckBox cb = (CheckBox)findViewById(R.id.cb);
                
                nombre.setText(productos.get(pos).getNombre());
                precio.setText(productos.get(pos).getPrecio());
                cantidad.setText(productos.get(pos).getCantidad());
            }
        };
        
        listaCompra.setAdapter(adap);
        }catch (Exception e){
            Toast.makeText(this, e.toString(), 1).show();
        }
        
        
    }
    
    public void evtComprar(View v){
        
    }
    
}
