/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragmentos;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.Activities.R;
import com.ModeloBD.Adeudo;
import com.ModeloBD.ModeloBD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sabdi
 */
public class FragmentoAdeudos extends ListFragment {
    static ModeloBD bd;
    static ListView lista;
    static View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState); 
         view = inflater.inflate(R.layout.fragmento_adeudos, null);
         lista = (ListView)view.findViewById(android.R.id.list);
         
         return view;   
    }
    
    public void generarConsumo() {
        int consumo = (int)(Math.random()*144);
        
        try {
            bd.generarAdeudo(consumo, (int)(consumo * 2.24));
        } catch (Exception ex) {
            Toast.makeText(view.getContext(), "Error en Generar Consumo" + ex.getMessage(), 1);
        }
        
        
    }
    
    public static void setAdeudos(ArrayAdapter adaptador) {
        lista.setAdapter(adaptador);
    }
    
    
}
