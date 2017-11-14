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
import android.widget.Toast;

/**
 *
 * @author Admin
 */
public class PaginaApps1 extends Fragment
{
    View vista;
    ImageButton btAppExplorador, btAppBuscador, btAppNotepad, btAppCalculadora, btAppContactos, btAppCalendario;

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) 
    {
        super.onCreateView(li, vg, bundle);
        
        vista = li.inflate(R.layout.paginaapps1, vg, false);
        
        btAppExplorador = (ImageButton)vista.findViewById(R.id.btAppExplorador);
        btAppBuscador = (ImageButton)vista.findViewById(R.id.btAppBuscador);
        btAppNotepad = (ImageButton)vista.findViewById(R.id.btAppNotepad);
        btAppCalculadora = (ImageButton)vista.findViewById(R.id.btAppCalculadora);
        btAppContactos = (ImageButton)vista.findViewById(R.id.btAppContactos);
        btAppCalendario = (ImageButton)vista.findViewById(R.id.btAppCalendario);
        
        btAppExplorador.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try{
                eventoExplorador(v);
                } catch (Exception e) {
            Toast.makeText(vista.getContext(), "Fallo: " + e.getMessage(), 1).show();
        }
            }
        });
        
        btAppBuscador.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                eventoBuscador(v);
            }
        });
        
         btAppNotepad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                eventoNotepad(v);
            }
        });
        
         btAppCalculadora.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                eventoCalculadora(v);
            }
        });
         
         btAppContactos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                eventoContactos(v);
            }
        });
         
         btAppCalendario.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                eventoCalendario(v);
            }
        });
        return vista;
    }
    
    private void eventoExplorador(View v)
    {
        Intent intento = new Intent(vista.getContext(), AppExplorador.class);
        this.startActivity(intento);
    }
    
    private void eventoBuscador(View v)
    {
        Intent intento = new Intent(vista.getContext(), AppBuscador.class);
        this.startActivity(intento);
    }
    
     private void eventoNotepad(View v)
    {
        try {
            Intent intento = new Intent(vista.getContext(), AppNotepad.class);
            this.startActivity(intento);  
        } catch (Exception e) {
            Toast.makeText(vista.getContext(), "Fallo: " + e.getMessage(), 1).show();
        }
        
    }
    
     private void eventoCalculadora(View v)
    {
        try {
            Intent intento = new Intent(vista.getContext(), AppCalculadora.class);
            this.startActivity(intento);  
        } catch (Exception e) {
            Toast.makeText(vista.getContext(), "Fallo: " + e.getMessage(), 1).show();
        }
        
    }
     
    
    private void eventoContactos(View v)
    {
        try {
            Intent intento = new Intent(vista.getContext(), AppContactos.class);
            this.startActivity(intento);  
        } catch (Exception e) {
            Toast.makeText(vista.getContext(), "Fallo: " + e.getMessage(), 1).show();
        }
        
    }
    
    private void eventoCalendario(View v)
    {
        try {
            Intent intento = new Intent(vista.getContext(), AppCalendario.class);
            this.startActivity(intento);  
        } catch (Exception e) {
            Toast.makeText(vista.getContext(), "Fallo: " + e.getMessage(), 1).show();
        }
        
    }
}
