/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.Clases.Carrito;

/**
 *
 * @author sabdi
 */
public class Software extends Activity {

    Button boton1, boton2, boton3;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.software);
        
        boton1 = (Button)findViewById(R.id.btSComprar1);
        boton2 = (Button)findViewById(R.id.btSComprar2);
        boton3 = (Button)findViewById(R.id.btSComprar3);
        
        if (Carrito.sB1==false) {
            boton1.setVisibility(boton1.INVISIBLE);
        }
        if (Carrito.sB2==false) {
            boton2.setVisibility(boton2.INVISIBLE);
        }
        if (Carrito.sB3==false) {
            boton3.setVisibility(boton3.INVISIBLE);
        }   
    }
    
    public void Comprar1(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.s1 = "Office 2016";
        Carrito.sPrecio1 = 2000;
        Carrito.sB1 = false;
        Carrito.articulos++;
        boton1.setVisibility(boton1.INVISIBLE);
    }
    
    public void Comprar2(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.s2 = "Windows 10";
        Carrito.sPrecio2 = 2500;
        Carrito.sB2 = false;
        Carrito.articulos++;
        boton2.setVisibility(boton2.INVISIBLE);
    }
    
    public void Comprar3(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.s3 = "Norton";
        Carrito.sPrecio3 = 500;
        Carrito.sB3 = false;
        Carrito.articulos++;
        boton3.setVisibility(boton3.INVISIBLE);
    }
    
}
