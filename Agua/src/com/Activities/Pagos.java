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
 * @author sabdi
 */
public class Pagos extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.pagos);
    }
    
    public void evtAdeudo(View view) {
        Intent intento = new Intent(this, MainActivity.class);
        startActivity(intento);
        this.finish();
    }
    
    public void evtAgregarPago(View view) {
        
    }
    
}
