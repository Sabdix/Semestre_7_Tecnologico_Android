
package com.practica2.activitys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 *
 * @author sabdi
 */
public class Fregmento extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento, null);
        
        Button bt = (Button)view.findViewById(R.id.btFragmentSaludar);
        
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Bonjour Fragmento 1", 1).show();
            }
        });
        
        return view;
    }
}
