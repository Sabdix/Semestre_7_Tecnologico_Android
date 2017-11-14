/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 *
 * @author Admin
 */
public class PaginaApps3 extends Fragment
{
    ImageButton btAppJuego;
    View vista;
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) 
    {
        super.onCreateView(li, vg, bundle);
        vista = li.inflate(R.layout.paginaapps3, vg, false);
        
       
        btAppJuego = (ImageButton)vista.findViewById(R.id.btAppJuego);
        
        
        
        btAppJuego.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) 
            {
                eventoJuego(v);
            }
        });
        
        return vista;
    }
    
    
    public void eventoJuego(View v){
        Intent intento = new Intent(vista.getContext(), Blackjack.class);
        startActivity(intento);
    }
    
}
