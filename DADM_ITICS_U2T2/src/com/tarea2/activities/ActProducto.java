/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.tarea2.adaptadores.AdaptadorProd;
import com.tarea2.models.Base;
import com.tarea2.models.Cliente;
import com.tarea2.models.Producto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandra
 */
public class ActProducto extends Activity {

    Spinner lista;
    String cadena="";
    Base bd;
    String [] array;
    Adapter adaptador;
    ArrayList<Producto> listaP;
    ListView listaProducto;
    AdaptadorProd adapLista;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.producto);
        // ToDo add your GUI initialization code here  
        listaProducto = (ListView)findViewById(R.id.lvListaProducto);
        try {
            
        listaP = bd.listaProductos();
        adapLista = new AdaptadorProd(this, listaP, R.layout.renglonproducto) {
            @Override
            public void renglonLista(View view, int pos) {
                TextView nombre = (TextView)view.findViewById(R.id.tvNombre);
                TextView precio = (TextView)view.findViewById(R.id.tvPrecio);
                TextView cantidad = (TextView)view.findViewById(R.id.tvCantidad);
                
                nombre.setText(listaP.get(pos).getNombre());
                precio.setText(listaP.get(pos).getPrecio());
                cantidad.setText(listaP.get(pos).getPrecio());
            }
        };
        
        listaProducto.setAdapter(adapLista);
        } catch (Exception ex) {
            Toast.makeText(this, "no "+ex.getMessage(), 1).show();
            Logger.getLogger(ActProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void evtRegresar(View v){
         Intent intento = new Intent(this, Tarea2U2.class);
        startActivity(intento);
    }
    
    public void hacerLista() throws Exception{
        
        
    
}
    
}
