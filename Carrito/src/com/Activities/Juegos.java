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
public class Juegos extends Activity {

    Button boton1, boton2, boton3;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.juegos);
        
        Carrito carrito = new Carrito();
        
        boton1 = (Button)findViewById(R.id.btJComprar1);
        boton2 = (Button)findViewById(R.id.btJComprar2);
        boton3 = (Button)findViewById(R.id.btJComprar3);
        
        if (Carrito.jB1==false) {
            boton1.setVisibility(boton1.INVISIBLE);
        }
        if (Carrito.jB2==false) {
            boton2.setVisibility(boton2.INVISIBLE);
        }
        if (Carrito.jB3==false) {
            boton3.setVisibility(boton3.INVISIBLE);
        }        
    }
    
    public void Comprar1(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.j1 = "Age of Empires";
        Carrito.jPrecio1 = 250;
        Carrito.jB1 = false;
        Carrito.articulos++;
        boton1.setVisibility(boton1.INVISIBLE);
    }
    
    public void Comprar2(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.j2 = "Batman Arkham Knight";
        Carrito.jPrecio2 = 800;
        Carrito.jB2 = false;
        Carrito.articulos++;
        boton2.setVisibility(boton2.INVISIBLE);
    }
    
    public void Comprar3(View v) {
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
        Carrito.j3 = "Outlast";
        Carrito.jPrecio3 = 150;
        Carrito.jB3 = false;
        Carrito.articulos++;
        boton3.setVisibility(boton3.INVISIBLE);
    }
    
}
