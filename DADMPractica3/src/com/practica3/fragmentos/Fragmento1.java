/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica3.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.practica3.activitiys.R;

/**
 *
 * @author sabdi
 */
public class Fragmento1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento1, container);
        
        final EditText etFragmento1 = (EditText)view.findViewById(R.id.etFragmento1);
        Button btFragmento1 = (Button)view.findViewById(R.id.btEnviarF2);
        
        btFragmento1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pasarMensaje(etFragmento1);
            }
        });
        return view;
        
    }
    
    private void pasarMensaje(EditText etMsg) {
        Fragmento2 f2 = (Fragmento2) this.getFragmentManager().findFragmentById(R.id.fragmento2);
        EditText etF2 = (EditText)f2.getActivity().findViewById(R.id.etFragmento2);
        etF2.setText("Frag1 dijo: "+etMsg.getText());
        etMsg.setText("");
    }
}
