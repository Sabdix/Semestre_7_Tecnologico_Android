/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @author sabdi
 */
public class Tercero extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.tercero);
        
        LinearLayout linearTercero= (LinearLayout)findViewById(R.id.linearTercero);
        linearTercero.setGravity(Gravity.CENTER);
        linearTercero.setBackgroundColor(Color.GREEN);
        
        String cel = this.getIntent().getStringExtra("cel");
        String msg = this.getIntent().getStringExtra("msg");
        TextView tvMensaje = new TextView(this);
        tvMensaje.setGravity(Gravity.CENTER);
        tvMensaje.setText("Mensaje enviado al número "+ cel + "\n\n" + "Mensaje: " + msg);
        tvMensaje.setTextColor(Color.MAGENTA);
        linearTercero.addView(tvMensaje);
    }
    
}
