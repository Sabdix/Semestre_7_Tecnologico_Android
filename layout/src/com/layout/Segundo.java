/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *
 * @author sabdi
 */
public class Segundo extends Activity {

    Button bSiguiente;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.relative);
        bSiguiente = (Button)findViewById(R.id.Siguiente2);
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                siguienteView();
            }
        });
        
    }
    
    private void siguienteView() {
        try {
            Intent intento = new Intent(this, Tercero.class);
            startActivity(intento);
        } catch (Exception e) {
        }
    }
    
}
