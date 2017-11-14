
package com.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.Activities.R;
import java.util.Random;

/**
 *
 * @author sabdi
 */
public class Fragmento1 extends Fragment{
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento1, null);
        
        TextView tv = (TextView)view.findViewById(R.id.tvFragmento1);
        
        Random r = new Random();
        tv.setText("Select any pieces of pizza according to "+ (r.nextInt(8)+1) + " / 8");
        
        return view;
    }
}
