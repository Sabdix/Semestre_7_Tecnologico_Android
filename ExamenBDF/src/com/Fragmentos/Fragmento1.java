/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.Activities.R;
import com.Modelo.ModeloBD;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Fragmento1 extends Fragment {
    View view;
    static ListView lvResultados;
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragmento1, null);
        
        lvResultados = (ListView)view.findViewById(R.id.lvResultados);
        
        
        return view;
    }
     
     public static void setCasas(ArrayAdapter adaptador) {
         lvResultados.setAdapter(adaptador);
     }
}
