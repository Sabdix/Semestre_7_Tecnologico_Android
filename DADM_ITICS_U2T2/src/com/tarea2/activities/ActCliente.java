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
public class ActCliente extends Activity {

    /**
     * Called when the activity is first created.
     */
    Spinner lista;
    String cadena="";
    Base bd;
    String [] array;
    Adapter adaptador;
    ArrayList<Cliente> listaP;
    ListView listaProducto;
    AdaptadorProd adapLista;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.cliente);
        
        listaProducto = (ListView)findViewById(R.id.lvListaCliente);
        try {
            
        listaP = bd.listaClientes();
        
//        adapLista = new AdaptadorProd(this, listaP, R.layout.rengloncliente) {
//            @Override
//            public void renglonLista(View view, int pos) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        };
        
        listaProducto.setAdapter(adapLista);
        } catch (Exception ex) {
            Toast.makeText(this, "no "+ex.getMessage(), 1).show();
            Logger.getLogger(ActProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ToDo add your GUI initialization code here        
    }
    
    public void evtRegresar(View v){
         Intent intento = new Intent(this, Tarea2U2.class);
        startActivity(intento);
    }
    
}
