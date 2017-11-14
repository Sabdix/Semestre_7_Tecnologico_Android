/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicidad.fragmentos;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.publicidad.R;

/**
 *
 * @author sabdi
 */
public class Publicidad3 extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.fragmento3, null);
        view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    abrirPublicidad();
                }
            });
        return view;
    }
    
    private void abrirPublicidad() {
            Uri uri = Uri.parse("http://www.google.com");
            Intent intento = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intento);
            
            FragmentTransaction ft = this.getFragmentManager().beginTransaction();
            ft.remove(this);
            ft.commit();
            
            LinearLayout linear = (LinearLayout)this.getActivity().findViewById(R.id.llSecundario);
            
            linear.removeView(this.getActivity().findViewById(R.id.fragmento3));
        }
}
