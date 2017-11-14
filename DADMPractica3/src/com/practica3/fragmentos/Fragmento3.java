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
import com.practica3.activitiys.MainActivity;
import com.practica3.activitiys.R;

/**
 *
 * @author sabdi
 */
public class Fragmento3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento3, container);
        
        final EditText etFragmento3 = (EditText)view.findViewById(R.id.etFragmento3);
        Button btFragmento3 = (Button)view.findViewById(R.id.btEnviarActivity);
        
        btFragmento3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pasarMensaje(etFragmento3);
            }
        });
        return view;
        
    }
    
    private void pasarMensaje(EditText etMsg) {
        EditText etActivity = (EditText)getActivity().findViewById(R.id.etActivity);
        etActivity.setText("Frag3 dijo: "+etMsg.getText());
        etMsg.setText("");
    }
}
