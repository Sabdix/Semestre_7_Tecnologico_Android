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

/**
 *
 * @author Alejandra
 */
public class ActVendedor extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.vendedor);
        // ToDo add your GUI initialization code here        
    }
    
    public void evtRegresar(View v){
         Intent intento = new Intent(this, Tarea2U2.class);
        startActivity(intento);
    }
    
}
