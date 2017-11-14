/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.Clases.Carrito;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Total extends Activity {

    ListView lvProductos;
    ArrayList<String> productos = new ArrayList<String>();
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.total);
        lvProductos = (ListView)findViewById(R.id.Productos);
        TextView total = (TextView)findViewById(R.id.tvTotal);
        TextView subtotal = (TextView)findViewById(R.id.tvSubtotal);
        
        float Total = Carrito.sPrecio1 + Carrito.sPrecio2 + Carrito.sPrecio3 + 
                Carrito.hPrecio1 + Carrito.hPrecio2 + Carrito.hPrecio3 + 
                Carrito.jPrecio1 + Carrito.jPrecio2 + Carrito.jPrecio3;
        float STotal = 0;
        subtotal.setText("Total $"+Total);
        
        if (Carrito.articulos >= 4) {
            STotal = Total - ((float)(Total * .10));
            total.setText("Subtotal $"+STotal+ "  <----Descuento del 10% por 4 articulos");
        } else {
            total.setText("Subtotal $"+Total);
        }
        
        if (Carrito.sB1==false) {
            productos.add(Carrito.s1 + " $" + Carrito.sPrecio1);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
        }
        if (Carrito.sB2==false) {
            productos.add(Carrito.s2 + " $" + Carrito.sPrecio2);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
        }
        if (Carrito.sB3==false) {
            productos.add(Carrito.s3 + " $" + Carrito.sPrecio3);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
        if (Carrito.jB1==false) {
            productos.add(Carrito.j1 + " $" + Carrito.jPrecio1);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
        if (Carrito.jB2==false) {
            productos.add(Carrito.j2 + " $" + Carrito.jPrecio3);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
        if (Carrito.jB3==false) {
            productos.add(Carrito.j3 + " $" + Carrito.jPrecio3);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
        if (Carrito.hB1==false) {
            productos.add(Carrito.h1 + " $" + Carrito.hPrecio1);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
        if (Carrito.hB2==false) {
            productos.add(Carrito.h2 + " $" + Carrito.hPrecio2);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
        if (Carrito.hB3==false) {
            productos.add(Carrito.h3 + " $" + Carrito.hPrecio3);
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            adaptador.notifyDataSetChanged();
            lvProductos.setAdapter(adaptador);
            
        }
    }
    
}
