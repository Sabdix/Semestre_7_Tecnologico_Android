package com.torneo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    Button btSimulacion1;
    Button btSiguiente1;
    TextView tvResEquipo1;
    TextView tvResEquipo2;
    TextView tvResEquipo3;
    TextView tvResEquipo4;
    TextView tvResEquipo5;
    TextView tvResEquipo6;
    TextView tvResEquipo7;
    TextView tvResEquipo8;
    EditText etEquipo1;
    EditText etEquipo2;
    EditText etEquipo3;
    EditText etEquipo4;
    EditText etEquipo5;
    EditText etEquipo6;
    EditText etEquipo7;
    EditText etEquipo8;
    int a=0, b=0;
    String sEquipo1, sEquipo2, sEquipo3, sEquipo4;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btSimulacion1 = (Button)findViewById(R.id.btSimulacion1);
        btSiguiente1 = (Button)findViewById(R.id.btSiguiente1);
        
        tvResEquipo1 = (TextView)findViewById(R.id.tvResEquipo1);
        tvResEquipo2 = (TextView)findViewById(R.id.tvResEquipo2);
        tvResEquipo3 = (TextView)findViewById(R.id.tvResEquipo3);
        tvResEquipo4 = (TextView)findViewById(R.id.tvResEquipo4);
        tvResEquipo5 = (TextView)findViewById(R.id.tvResEquipo5);
        tvResEquipo6 = (TextView)findViewById(R.id.tvResEquipo6);
        tvResEquipo7 = (TextView)findViewById(R.id.tvResEquipo7);
        tvResEquipo8 = (TextView)findViewById(R.id.tvResEquipo8);
        
        etEquipo1 = (EditText)findViewById(R.id.etEquipo1);
        etEquipo2 = (EditText)findViewById(R.id.etEquipo2);
        etEquipo3 = (EditText)findViewById(R.id.etEquipo3);
        etEquipo4 = (EditText)findViewById(R.id.etEquipo4);
        etEquipo5 = (EditText)findViewById(R.id.etEquipo5);
        etEquipo6 = (EditText)findViewById(R.id.etEquipo6);
        etEquipo7 = (EditText)findViewById(R.id.etEquipo7);
        etEquipo8 = (EditText)findViewById(R.id.etEquipo8);
        
        btSimulacion1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResEquipo1.setText(a+"");
                    tvResEquipo2.setText(b+"");
                } while(a == b);
                do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResEquipo3.setText(a+"");
                    tvResEquipo4.setText(b+"");
                }while(a == b);
                 do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResEquipo5.setText(a+"");
                    tvResEquipo6.setText(b+"");
                } while(a == b);
                 do {
                    a = (int)(1+Math.random()*5);
                    b = (int)(1+Math.random()*5);
                    tvResEquipo7.setText(a+"");
                    tvResEquipo8.setText(b+"");
                } while(a == b);
            }
        });
        
        btSiguiente1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!etEquipo1.getText().toString().equals("") & !etEquipo2.getText().toString().equals("") & !etEquipo3.getText().toString().equals("") & !etEquipo4.getText().toString().equals("") &
                        !etEquipo5.getText().toString().equals("") & !etEquipo6.getText().toString().equals("") & !etEquipo7.getText().toString().equals("") & !etEquipo8.getText().toString().equals("") &
                        !tvResEquipo1.getText().toString().equals("")) {
                    if (Integer.parseInt(tvResEquipo1.getText().toString()) > Integer.parseInt(tvResEquipo2.getText().toString())) {
                        sEquipo1 = etEquipo1.getText().toString();
                    } else {
                        sEquipo1 = etEquipo2.getText().toString();
                    }
                    
                    if (Integer.parseInt(tvResEquipo3.getText().toString()) > Integer.parseInt(tvResEquipo4.getText().toString())) {
                        sEquipo2 = etEquipo3.getText().toString();
                    } else {
                        sEquipo2 = etEquipo4.getText().toString();
                    }
                    
                    if (Integer.parseInt(tvResEquipo5.getText().toString()) > Integer.parseInt(tvResEquipo6.getText().toString())) {
                        sEquipo3 = etEquipo5.getText().toString();
                    } else {
                        sEquipo3 = etEquipo6.getText().toString();
                    }
                    
                    if (Integer.parseInt(tvResEquipo7.getText().toString()) > Integer.parseInt(tvResEquipo8.getText().toString())) {
                        sEquipo4 = etEquipo7.getText().toString();
                    } else {
                        sEquipo4 = etEquipo8.getText().toString();
                    }
                    irSemifinales();
                } else {
                    Toast.makeText(v.getContext(), "Llene todos los campos y simule los marcadores", 1).show();
                }
            }
        });
    }
    
    private void irSemifinales() {
        Intent intento = new Intent(this, Semifinal.class);
        intento.putExtra("Equipo1", sEquipo1);
        intento.putExtra("Equipo2", sEquipo2);
        intento.putExtra("Equipo3", sEquipo3);
        intento.putExtra("Equipo4", sEquipo4);
        startActivity(intento);
    }
}
