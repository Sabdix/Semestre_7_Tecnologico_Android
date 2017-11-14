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
                setContentView(R.layout.table);
       
    }
    
    public void evtSiguiente(View v) {
        try {
            Intent intento = new Intent(this, Cuarto.class);
            startActivity(intento);
        } catch (Exception e) {
        }
    }
    
}
