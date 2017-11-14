/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragmentos;

import ModeloBD.Detalle;
import ModeloBD.ModeloBD;
import ModeloBD.Producto;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.Activities.MainActivity;
import com.Activities.R;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author sabdi
 */
public class Fragmento extends ListFragment{

    static View view;
    static MiAdaptador adaptador;
    static ArrayList<Detalle> detalle;
    static ArrayList<Detalle> productos;
    static ListView lista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragmento, null);
        lista = (ListView)view.findViewById(android.R.id.list);
        detalle = new ArrayList<Detalle>();
        return view;
    }
    
    public static void setElements(final ModeloBD bd) throws Exception {
        detalle.clear();
        detalle = bd.listarDetalle();
        productos = bd.listarDetalle();
        adaptador = new MiAdaptador(view.getContext(), R.layout.renglon, productos) {
            @Override
            public void renglonLista(View view, final int pos) {
                TextView et1 = (TextView)view.findViewById(R.id.tvProductoNombre);
                Button btEliminar = (Button)view.findViewById(R.id.btEliminar);
                et1.setText(productos.get(pos).getId_producto() +" Cantidad: " + productos.get(pos).getCantidad() + " $" + productos.get(pos).getPrecio());
                
                btEliminar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        bd.deleteDetalle(productos.get(pos).getId());
                        try {
                            setElements(bd);
                        } catch (Exception ex) {
                            Logger.getLogger(Fragmento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        };
        lista.setAdapter(adaptador);
    }
    
    public static int getTotal() {
        int suma = 0;
        if (detalle.size() > 0) {
            for (int i=0; i<detalle.size(); i++) {
                suma += detalle.get(i).getPrecio();
            }
        }
        return suma;
    }
    
    public static void realizarVenta(ModeloBD bd) {
        for (int i=0; i<detalle.size(); i++) {
            bd.modificarProducto(detalle.get(i).getCantidad(), detalle.get(i).getiD_producto());
        }
        detalle.clear();
        productos.clear();
    }
    
}
