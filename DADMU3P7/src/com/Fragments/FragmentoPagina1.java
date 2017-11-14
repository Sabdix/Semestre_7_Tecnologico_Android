package com.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.Activities.R;

/**
 *
 * @author sabdi
 */
public class FragmentoPagina1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) {
        super.onCreateView(li, vg, bundle); 
        View view = li.inflate(R.layout.fragmento_pagina1, null);
        return view;
    }
    
}
