package com.Fragmentos;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.Model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public abstract class MiAdaptador extends BaseAdapter {
    private Context contexto;
    private ArrayList<Usuario> lista;
    private int interfazResource;

    public MiAdaptador(Context contexto, int interfazResource, ArrayList<Usuario> lista) {
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

    public View getView(int position, View view, ViewGroup parent) {
        if(view == null) {
            LayoutInflater inflador = (LayoutInflater)contexto.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            view = inflador.inflate(interfazResource, null);
        }
        
        //Para trabajar con cada renglon individual de forma independiente
        renglonLista(view, position);
        
        return view;
    }
    
    abstract public void renglonLista(View view, int pos);
    
    
}
