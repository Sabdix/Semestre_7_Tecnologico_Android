/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author sabdi
 */
public class Entrada extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.entrada);
        
        String texto="";
        
        

        try {
            texto = MainActivity.bd.logIn(this.getIntent().getStringExtra("nombre"), this.getIntent().getStringExtra("pass"));
        } catch (Exception ex) {
            Toast.makeText(this, "Error en la Consulta \n"+ex.getMessage(), 1).show();
        }
        try {
            MainActivity.bd.actualizarFecha(this.getIntent().getStringExtra("nombre"));
        } catch (Exception ex) {
            Toast.makeText(this, "Error en la Actualizacion \n"+ex.getMessage(), 1).show();
        }

        TextView etResultado = (TextView)findViewById(R.id.etTexto);
        etResultado.setText(texto);
    }
    
}
