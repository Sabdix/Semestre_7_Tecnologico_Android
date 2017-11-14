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
import android.widget.ListView;
import android.widget.TextView;
import com.Activities.R;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Fragmento2 extends Fragment {
    View view;
    static TextView tvprom;
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragmento2, null);
        
        tvprom = (TextView)view.findViewById(R.id.tvPrincipal);
        
        
        return view;
    }
     
     public static void setPromedio(int promedio) {
         tvprom.setText(promedio+"%");
     }
}
