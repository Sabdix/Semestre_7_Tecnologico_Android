/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class MiAdaptador extends BaseAdapter
{
    private ArrayList<?> miLista;
    private Context contexto;
    private int recurso;
    
    public MiAdaptador(Context contexto, int recurso, ArrayList<?> miLista)
    {
        this.miLista = miLista;
        this.contexto = contexto;
        this.recurso = recurso;
    }

    public int getCount() 
    {
        return miLista.size();
    }

    public Object getItem(int position) 
    {
        return miLista.get(position);
    }

    public long getItemId(int position) 
    {
        return -1;
    }

    public View getView(int position, View convertView, ViewGroup parent) 
    {
        if(convertView == null)
        {
            LayoutInflater li = (LayoutInflater)
                contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(recurso, null);
        }
        porCadaRenglon(convertView, miLista.get(position), position);
        return convertView;
    }
    
    abstract public void porCadaRenglon(View view, Object object, int index);
    
}
