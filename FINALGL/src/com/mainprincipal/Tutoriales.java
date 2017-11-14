/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mainprincipal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.mainprincipal.R;

/**
 *
 * @author sabdi
 */
public class Tutoriales extends Activity {

    
    TextView tvTitulo;
    TextView tvContenido;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tutorial);
 
        tvTitulo = (TextView)findViewById(R.id.tvTituloTutorial);
        tvContenido = (TextView)findViewById(R.id.tvContenidoTutorial);
        
        tvTitulo.setText(this.getIntent().getStringExtra("titulo"));
        tvContenido.setText(this.getIntent().getStringExtra("contenido"));
    }
    
}
