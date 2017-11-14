/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author sabdi
 */
public class Semifinal extends Activity {
    Button btSimulacion2;
    Button btSiguiente2;
    EditText tvEquipo1;
    EditText tvEquipo2;
    EditText tvEquipo3;
    EditText tvEquipo4;
    TextView tvResSemiEquipo1;
    TextView tvResSemiEquipo2;
    TextView tvResSemiEquipo3;
    TextView tvResSemiEquipo4;
    String sEquipo1, sEquipo2;
    int a,b;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.semifinal);
        
        btSimulacion2 = (Button)findViewById(R.id.btSimulacion2);
        btSiguiente2 = (Button)findViewById(R.id.btSiguiente2);
        tvEquipo1 = (EditText)findViewById(R.id.tvEquipo1);
        tvEquipo2 = (EditText)findViewById(R.id.tvEquipo2);
        tvEquipo3 = (EditText)findViewById(R.id.tvEquipo3);
        tvEquipo4 = (EditText)findViewById(R.id.tvEquipo4);
        tvResSemiEquipo1 = (TextView)findViewById(R.id.tvResSemiEquipo1);
        tvResSemiEquipo2 = (TextView)findViewById(R.id.tvResSemiEquipo2);
        tvResSemiEquipo3 = (TextView)findViewById(R.id.tvResSemiEquipo3);
        tvResSemiEquipo4 = (TextView)findViewById(R.id.tvResSemiEquipo4);
        Intent intento = this.getIntent();
        tvEquipo1.setText(intento.getStringExtra("Equipo1"));
        tvEquipo2.setText(intento.getStringExtra("Equipo2"));
        tvEquipo3.setText(intento.getStringExtra("Equipo3"));
        tvEquipo4.setText(intento.getStringExtra("Equipo4"));
        
        btSimulacion2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResSemiEquipo1.setText(a+"");
                    tvResSemiEquipo2.setText(b+"");
                } while(a == b);
                do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResSemiEquipo3.setText(a+"");
                    tvResSemiEquipo4.setText(b+"");
                }while(a == b);
            }
        });
        
        btSiguiente2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!tvResSemiEquipo1.getText().toString().equals("")) {
                    if (Integer.parseInt(tvResSemiEquipo1.getText().toString()) > Integer.parseInt(tvResSemiEquipo2.getText().toString())) {
                        sEquipo1 = tvEquipo1.getText().toString();
                    } else {
                        sEquipo1 = tvEquipo2.getText().toString();
                    }
                    
                    if (Integer.parseInt(tvResSemiEquipo3.getText().toString()) > Integer.parseInt(tvResSemiEquipo4.getText().toString())) {
                        sEquipo2 = tvEquipo3.getText().toString();
                    } else {
                        sEquipo2 = tvEquipo4.getText().toString();
                    }
                    irFinal();
                } else {
                    Toast.makeText(v.getContext(), "Simule los marcadores", 1).show();
                }
            }
        });
        
                
    }
    
    private void irFinal() {
        Intent intento = new Intent(this, Final.class);
        intento.putExtra("EFquipo1", sEquipo1);
        intento.putExtra("EFquipo2", sEquipo2);
        startActivity(intento);
    }
    
}
