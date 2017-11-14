/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 *
 * @author sabdi
 */
public class Enviar_Msg extends Activity {
    EditText etMensaje;
    String destino;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.enviar_msg);
        etMensaje = (EditText)findViewById(R.id.etMensaje);
        
        //Interceptamos valor de la pila del activity anterior
        Intent intento = this.getIntent();
        destino = intento.getStringExtra("destino");
    }
    
    public void evtOnClickEnviar(View v) {
        Toast.makeText(this, 
                "El mensaje para: " + destino + "\n" + 
                "Contenido: " + etMensaje.getText() + "\n" +
                " \nHa sido enviado!", 
                Toast.LENGTH_LONG
        ).show();
        
    }
    
}
