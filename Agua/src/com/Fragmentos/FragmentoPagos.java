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
import android.widget.ListView;
import com.Activities.R;

/**
 *
 * @author sabdi
 */
public class FragmentoPagos extends ListFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState); 
         View view = inflater.inflate(R.layout.fragmento_pagos, null);
         ListView lista = (ListView)view.findViewById(android.R.id.list);
         
         return view;
    }
}
