/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @author sabdi
 */
public class Final extends Activity {
    LinearLayout linearRelativo;
    Button btSiguiente3;
    EditText etFEquipo1;
    EditText etFEquipo2;
    EditText resultado;
    TextView tvResFinEquipo1;
    TextView tvResFinEquipo2;
    String sEquipo;
    
    int a,b;
    
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.finalista);
        Intent intento = this.getIntent();
        
        linearRelativo = (LinearLayout)findViewById(R.id.linearFinal);
        linearRelativo.setGravity(Gravity.CENTER);
        
        btSiguiente3 = new Button(this);
        btSiguiente3.setText("Simulacion");
        linearRelativo.addView(btSiguiente3);
        btSiguiente3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResFinEquipo1.setText(a+"");
                    tvResFinEquipo2.setText(b+"");
                } while(a == b);
                
                if (Integer.parseInt(tvResFinEquipo1.getText().toString()) > Integer.parseInt(tvResFinEquipo2.getText().toString())) {
                        sEquipo = etFEquipo1.getText().toString();
                        resultado.setText("Ganador "+sEquipo);
                        resultado.setBackgroundColor(Color.GREEN);
                        btSiguiente3.setEnabled(false);
                    } else {
                        sEquipo = etFEquipo2.getText().toString();
                        resultado.setText("Ganador "+sEquipo);
                        resultado.setBackgroundColor(Color.GREEN);
                        btSiguiente3.setEnabled(false);
                    }
            }
        });
        
        etFEquipo1 = new EditText(this);
        etFEquipo1.setText(intento.getStringExtra("EFquipo1"));
        etFEquipo1.setWidth(100);
        etFEquipo1.setHeight(200);
        etFEquipo1.setInputType(InputType.TYPE_NULL);
        linearRelativo.addView(etFEquipo1);
        
        tvResFinEquipo1 = new TextView(this);
        tvResFinEquipo1.setWidth(50);
        tvResFinEquipo1.setHeight(50);
        tvResFinEquipo1.setTextSize(25);
        tvResFinEquipo1.setBackgroundColor(Color.RED);
        linearRelativo.addView(tvResFinEquipo1);
        
        TextView tvVs = new TextView(this);
        tvVs.setText("VS");
        tvVs.setWidth(40);
        tvVs.setHeight(40);
        tvVs.setTextSize(25);
        linearRelativo.addView(tvVs);
        
        tvResFinEquipo2 = new TextView(this);
        tvResFinEquipo2.setWidth(50);
        tvResFinEquipo2.setHeight(50);
        tvResFinEquipo2.setTextSize(25);
        tvResFinEquipo2.setBackgroundColor(Color.RED);
        linearRelativo.addView(tvResFinEquipo2);
        
        etFEquipo2 = new EditText(this);
        etFEquipo2.setWidth(100);
        etFEquipo2.setHeight(200);
        etFEquipo2.setInputType(InputType.TYPE_NULL);
        etFEquipo2.setText(intento.getStringExtra("EFquipo2"));
        linearRelativo.addView(etFEquipo2);
        
        resultado = new EditText(this);
        resultado.setWidth(100);
        resultado.setHeight(100);
        resultado.setGravity(Gravity.START);
        linearRelativo.addView(resultado);
        
        
        
        
        
        
         
    }
    
}
