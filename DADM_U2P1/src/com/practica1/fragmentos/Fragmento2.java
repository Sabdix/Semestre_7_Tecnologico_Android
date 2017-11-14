package com.practica1.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.practica1.activity.R;

/**
 *
 * @author sabdi
 */
public class Fragmento2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento2, null);
        
        Button bt = (Button)view.findViewById(R.id.btFragmentSaludar);
        
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Bonjour Fragmento 2", 1).show();
            }
        });
        
        return view;
    }
    
}
