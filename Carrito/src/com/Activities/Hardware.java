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
public class Hardware extends Activity {

    Button boton1, boton2, boton3;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.hardware);
        
        Carrito carrito = new Carrito();
        
        boton1 = (Button)findViewById(R.id.btHComprar1);
        boton2 = (Button)findViewById(R.id.btHComprar2);
        boton3 = (Button)findViewById(R.id.btHComprar3);
        
        if (Carrito.hB1==false) {
            boton1.setVisibility(boton1.INVISIBLE);
        }
        if (Carrito.hB2==false) {
            boton2.setVisibility(boton2.INVISIBLE);
        }
        if (Carrito.hB3==false) {
            boton3.setVisibility(boton3.INVISIBLE);
        }   
    }
    
    public void Comprar1(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.h1 = "Mouse";
        Carrito.hPrecio1 = 100;
        Carrito.hB1 = false;
        Carrito.articulos++;
        boton1.setVisibility(boton1.INVISIBLE);
    }
    
    public void Comprar2(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.h2 = "Teclado";
        Carrito.hPrecio2 = 250;
        Carrito.hB2 = false;
        Carrito.articulos++;
        boton2.setVisibility(boton2.INVISIBLE);
    }
    
    public void Comprar3(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.h3 = "Audífonos";
        Carrito.hPrecio3 = 250;
        Carrito.hB3 = false;
        Carrito.articulos++;
        boton3.setVisibility(boton3.INVISIBLE);
    }
    
}
