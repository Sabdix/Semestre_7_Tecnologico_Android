/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author sabdi
 */
public class Segundo extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.segundo);
        
        LinearLayout linearSegundo = (LinearLayout)findViewById(R.id.linearSegundo);
        linearSegundo.setGravity(Gravity.CENTER);
        linearSegundo.setBackgroundResource(R.drawable.ic_launcher);
        
        TextView tvMensaje = new TextView(this);
        tvMensaje.setText("Tu Mensaje");
        tvMensaje.setTextColor(Color.MAGENTA);
        linearSegundo.addView(tvMensaje);
        
        final EditText etMensaje = new EditText(this);
        etMensaje.setHint("Ingresa tu mensaje");
        etMensaje.setHeight(200);
        etMensaje.setWidth(200);
        etMensaje.setGravity(Gravity.START);
        linearSegundo.addView(etMensaje);
        
        CheckBox checkEnviar = new CheckBox(this);
        checkEnviar.setText("Enviar");
        checkEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               invocaEnviar(etMensaje.getText());
            }
        });
        linearSegundo.addView(checkEnviar);
        
                
    }
    
    private void invocaEnviar(Editable mensaje) {
        String cel = this.getIntent().getStringExtra("cel");
        
        try {
                Intent intento = new Intent(this, Tercero.class);
                intento.putExtra("cel", cel);
                intento.putExtra("msg", mensaje.toString());
                startActivity(intento);
            } catch (Exception e) {
                Toast.makeText(this, "Error al invocar. \n" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
    }
    
}
