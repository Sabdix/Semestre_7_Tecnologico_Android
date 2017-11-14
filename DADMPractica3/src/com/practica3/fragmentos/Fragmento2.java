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
public class Fragmento2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento2, container);
        
        final EditText etFragmento2 = (EditText)view.findViewById(R.id.etFragmento2);
        Button btFragmento2 = (Button)view.findViewById(R.id.btEnviarF3);
        
        btFragmento2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pasarMensaje(etFragmento2);
            }
        });
        return view;
        
    }
    
    private void pasarMensaje(EditText etMsg) {
        Fragmento3 f3 = (Fragmento3) this.getFragmentManager().findFragmentById(R.id.fragmento3);
        EditText etF3 = (EditText)f3.getActivity().findViewById(R.id.etFragmento3);
        etF3.setText("Frag2 dijo: "+etMsg.getText());
        etMsg.setText("");
    }
}
