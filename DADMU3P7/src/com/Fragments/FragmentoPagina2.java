package com.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.Activities.AppCalendario;
import com.Activities.R;

/**
 *
 * @author sabdi
 */
public class FragmentoPagina2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) {
        super.onCreateView(li, vg, bundle); 
        View view = li.inflate(R.layout.fragmento_pagina2, null);
        Button cal = (Button)view.findViewById(R.id.btAppCalendario);
        
        cal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostrarAppCalendario(v);
            }
        });
        
        return view;
    }
    
    private void mostrarAppCalendario(View v) {
        Intent intento = new Intent(v.getContext(), AppCalendario.class);
        startActivity(intento);
        this.getActivity().finish();
    }
    
}
