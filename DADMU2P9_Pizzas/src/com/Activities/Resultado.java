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
import android.widget.TextView;

/**
 *
 * @author sabdi
 */
public class Resultado extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.resultado);
        int numerador = this.getIntent().getIntExtra("numerador", -1);
        int seleccion = this.getIntent().getIntExtra("seleccion", -1);
        
        if (numerador != -1 | seleccion != -1) {
            if (numerador == seleccion) {
                TextView tvResultado = (TextView)findViewById(R.id.tvResultadoFinal);
                tvResultado.setText("Resultado Correcto "+numerador+"/8");
            }
        }
    }
    
    public void eventoPlayAgain(View view) {
        Intent intento = new Intent(this, MainActivity.class);
        startActivity(intento);
        finish();
    }
}
