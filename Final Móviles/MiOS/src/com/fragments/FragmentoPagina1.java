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
import com.mios.AppReproductor;

import com.mios.R;

/**
 *
 * @author Alexander
 */
public class FragmentoPagina1 extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) 
    {
        super.onCreateView(li, vg, bundle);
        
        View view = li.inflate(R.layout.fragmento_pagina1, null);
        ImageView bt = (ImageView)view.findViewById(R.id.ivAppReproductor);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostrarAppReproductor(v);
            }
        });
        
        return view;
    }
    
    private void mostrarAppReproductor(View view)
    {
        Intent intent = new Intent(
            view.getContext(), AppReproductor.class
        );
        startActivity(intent);
        this.getActivity().finish();
    }
    
}
