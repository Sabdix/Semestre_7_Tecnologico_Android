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
import android.widget.CheckBox;
import com.Clases.Estadistica;

/**
 *
 * @author sabdi
 */
public class Partido3 extends Activity {

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.partido3);
        
        cb1 = (CheckBox)findViewById(R.id.cbJugo3);
        cb2 = (CheckBox)findViewById(R.id.cbGano3);
        cb3 = (CheckBox)findViewById(R.id.cbDestacado3);
        cb4 = (CheckBox)findViewById(R.id.cbSalud3);
    }
    
    public void evtPartido3(View v) {
        if (cb1.isChecked()) {
            Estadistica.rendimiento[0][2] = 1;
        } else {
            Estadistica.rendimiento[0][2] = 0;
        }
        if (cb2.isChecked()) {
            Estadistica.rendimiento[1][2] = 1;
        } else {
            Estadistica.rendimiento[1][2] = 0;
        }
        if (cb3.isChecked()) {
            Estadistica.rendimiento[2][2] = 1;
        } else {
            Estadistica.rendimiento[2][2] = 0;
        }
        if (cb4.isChecked()) {
            Estadistica.rendimiento[3][2] = 1;
        } else {
            Estadistica.rendimiento[3][2] = 0;
        }
        Intent intento = new Intent(this, Partido4.class);
        intento.putExtra("nombre", this.getIntent().getStringExtra("nombre"));
        startActivity(intento);
    }
    
}
