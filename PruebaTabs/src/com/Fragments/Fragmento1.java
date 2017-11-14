/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.Activities.R;

/**
 *
 * @author sabdi
 */
public class Fragmento1 extends Fragment {
    private final static String KEY_REG_TEXT = "texto";
    
    public static Fragmento1 newInstance(String text) {
        Fragmento1 frag = new Fragmento1();
        
        Bundle args = frag.getArguments();
        if(args == null) {
            args.putString(KEY_REG_TEXT, text);
        }
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        // Inflamos la Vista que se debe mostrar en pantalla.
    View rootView = inflater.inflate(R.layout.layout1, container,
            false);
    // Creamos instancia del TextView.
    TextView tvText =  (TextView)rootView.findViewById(R.id.tvText);
    // Recogemos el texto que guardamos al crear el Fragment.
    String text = getArguments().getString(KEY_REG_TEXT);
    // Mostramos el texto en el TextView.
    tvText.setText(text);
         
    // Devolvemos la vista para que se muestre en pantalla.
    return rootView;
    }
    
    
}
