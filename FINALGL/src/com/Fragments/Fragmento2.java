/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragments;

import ModeloBd.ModeloBD;
import ModeloBd.Tutorial;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.mainprincipal.R;
import com.mainprincipal.MainActivity;
import com.mainprincipal.Tutoriales;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sabdi
 */
public class Fragmento2 extends Fragment {
    
    ListView lvTutoriales;
    
    ModeloBD mibd;
    ArrayList<Tutorial> tutos;
    ArrayList<String> tTutos;
    View view;
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) {
        view = li.inflate(R.layout.tab2, vg, false);
        
        lvTutoriales = (ListView)view.findViewById(R.id.lvTutoriales);
        tTutos = new ArrayList<String>();
        mibd = MainActivity.mibd;
        setElements();
        lvTutoriales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intento = new Intent(view.getContext(), Tutoriales.class);
                intento.putExtra("titulo", tutos.get(position).getTitulo());
                intento.putExtra("contenido", tutos.get(position).getContenido());
                startActivity(intento);
            }
        });
        return view;
    }
    
    private void setElements() {
        try {
            tutos = mibd.listarTutoriales();
            for (int i=0; i<tutos.size(); i++) {
                tTutos.add(tutos.get(i).toString());
            }
            ArrayAdapter adaptador = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, tTutos);
            adaptador.notifyDataSetChanged();
            lvTutoriales.setAdapter(adaptador);
        } catch (Exception ex) {
            Toast.makeText(view.getContext(), "Error al listar tutoriales", 1).show();
        }
    }
    
}
