/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea2.adaptadores;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tarea2.models.Producto;
import java.util.ArrayList;

/**
 *
 * @author Alejandra
 */
public abstract class AdaptadorProd extends BaseAdapter {
    private Context contexto;
    private ArrayList<Producto> lista;
    private int interfazResource;

    public AdaptadorProd(Context contexto, ArrayList<Producto> lista, int interfazResource) {
        this.contexto = contexto;
        this.lista = lista;
        this.interfazResource = interfazResource;
    }
    

    public int getCount() {
        return lista.size();
    }

    public Object getItem(int position) {
        return lista.get(position);
    }

    public long getItemId(int position) {
        return -1;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null){
            LayoutInflater inflador = (LayoutInflater)contexto.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            convertView = inflador.inflate(interfazResource, null);
        }
        
        //Para trabajar con cada rengl[on individual de forma independiente
        renglonLista(convertView, position);
        return convertView;
    }
    
    
    
    public abstract void renglonLista(View view, int pos);
    
}
