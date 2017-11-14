/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragments;

import ModeloBd.ModeloBD;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.mainprincipal.MainActivity;
import com.mainprincipal.R;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sabdi
 */
public class Fragmento3 extends Fragment {
    ModeloBD mibd;
    ToggleButton tbNotificaciones;
    View view;

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) {
        view = li.inflate(R.layout.tab3, vg, false);
        tbNotificaciones = (ToggleButton)view.findViewById(R.id.tgNotifiaciones);
        mibd = MainActivity.mibd;
        
        if (MainActivity.notific) {
        tbNotificaciones.setChecked(true);
        }else {
            tbNotificaciones.setChecked(false);
        }
        
        tbNotificaciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tbNotificaciones.isChecked()) {
                    try {
                        mibd.setCount("true, "+MainActivity.contadorVideos);
                        MainActivity.notific = true;
                    } catch (Exception ex) {
                         Toast.makeText(view.getContext(), "Error al activar notificaciones", 1).show();
                    }
                    Toast.makeText(view.getContext(), "Notifications Enabled", 1).show();
                } else {
                     try {
                        mibd.setCount("false, "+MainActivity.contadorVideos);
                        MainActivity.notific = false;
                    } catch (Exception ex) {
                         Toast.makeText(view.getContext(), "Error al desactivar notificaciones", 1).show();
                    }
                    Toast.makeText(view.getContext(), "Notifications Disabled", 1).show();
                }
            }
        });
        
        return view;
        
    }
}
