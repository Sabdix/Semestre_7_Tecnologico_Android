/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 *
 * @author sabdi
 */
public class Resultado extends Activity {

    TextView tvResultado;
    String texto ="";
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);  
        setContentView(R.layout.resultado);
        tvResultado = (TextView)findViewById(R.id.tvResultado);
        
        Intent intento = this.getIntent();
        texto = intento.getStringExtra("Opcion");
        texto += intento.getStringExtra("Nombre");
        tvResultado.setText(texto);
    }
    
}
