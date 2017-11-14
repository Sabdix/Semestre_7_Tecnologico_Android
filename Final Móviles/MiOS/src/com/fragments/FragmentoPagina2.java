package com.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.mios.AppCalendario;
import com.mios.AppNotas;

import com.mios.R;

/**
 *
 * @author Alexander
 */
public class FragmentoPagina2 extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) 
    {
        super.onCreateView(li, vg, bundle);
        
        View view = li.inflate(R.layout.fragmento_pagina2, null);
        
        ImageView bt = (ImageView)view.findViewById(R.id.ivAppCalendario);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostrarAppCalendario(v);
            }
        });
        ImageView btNotas = (ImageView)view.findViewById(R.id.ivAppNotas);
        btNotas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostrarAppNotas(v);
            }
        });
        
        return view;
    }
    
    private void mostrarAppCalendario(View view)
    {
        Intent intent = new Intent(
            view.getContext(), AppCalendario.class
        );
        startActivity(intent);
        this.getActivity().finish();
    }
    
    private void mostrarAppNotas(View view)
    {
        Intent intent = new Intent(
            view.getContext(), AppNotas.class
        );
        startActivity(intent);
        this.getActivity().finish();
    }
    
}
