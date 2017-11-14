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
public class PaginaApps2 extends Fragment
{
    ImageButton btAppNav, btAppReproductor;
    View vista;
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) 
    {
        super.onCreateView(li, vg, bundle);
        vista = li.inflate(R.layout.paginaapps2, vg, false);
        
       

        btAppNav = (ImageButton)vista.findViewById(R.id.btAppNavegador);
        
        btAppReproductor = (ImageButton)vista.findViewById(R.id.btAppReproductor);
        
        
        
        btAppNav.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) 
            {
                eventoNav(v);
            }
        });
        
        btAppReproductor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) 
            {
                eventoReproductor(v);
            }
        });
        
        return vista;
    }
    
    
    
    public void eventoNav(View v){
        Intent intento = new Intent(vista.getContext(), AppNavegador.class);
        startActivity(intento);
    }
    
    public void eventoReproductor(View v){
        Intent intento = new Intent(vista.getContext(), AppReproductor.class);
        startActivity(intento);
    }
    
}
