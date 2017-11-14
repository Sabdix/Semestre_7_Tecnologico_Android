/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.tarea2.models.Base;
import com.tarea2.models.Vendedor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandra
 */
public class Segundo extends Activity {

    
    String cadena="";
    ArrayList<Vendedor> listaV;
    Base bd;
    String [] array;
    
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.segundo);
        
        bd = new Base(this, "Mi base", null, 1);
        try {
            Spinner lista = (Spinner)findViewById(R.id.spVendedores); 
            listaV = bd.listaVendedores();
            for(int i=0; i < listaV.size(); i++){
                cadena+=listaV.get(i).getNombre()+",";
            }
            array = cadena.split(",");
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
            //adaptador
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            lista.setAdapter(adaptador);
        
            //Toast.makeText(this, cadena, 1).show();
            // ToDo add your GUI initialization code here        
        } catch (Exception ex) {
            Toast.makeText(this, "No se puede"+ex, 1).show();
            Logger.getLogger(Segundo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void evtContinuar(View v) throws Exception{
        Intent intento = new Intent(this, Tercero.class);
        startActivity(intento);
    }
}
