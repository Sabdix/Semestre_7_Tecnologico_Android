package com.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.Activities.R;

/**
 *
 * @author sabdi
 */
public class Fragmento2 extends Fragment implements View.OnClickListener {

    public static int numerador = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento2, null);
        
        ImageView pizza1 = (ImageView)view.findViewById(R.id.imagePizza1);
        ImageView pizza2 = (ImageView)view.findViewById(R.id.imagePizza2);
        ImageView pizza3 = (ImageView)view.findViewById(R.id.imagePizza3);
        ImageView pizza4 = (ImageView)view.findViewById(R.id.imagePizza4);
        ImageView pizza5 = (ImageView)view.findViewById(R.id.imagePizza5);
        ImageView pizza6 = (ImageView)view.findViewById(R.id.imagePizza6);
        ImageView pizza7 = (ImageView)view.findViewById(R.id.imagePizza7);
        ImageView pizza8 = (ImageView)view.findViewById(R.id.imagePizza8);
        numerador = 0;
        pizza1.setOnClickListener(this);
        pizza2.setOnClickListener(this);
        pizza3.setOnClickListener(this);
        pizza4.setOnClickListener(this);
        pizza5.setOnClickListener(this);
        pizza6.setOnClickListener(this);
        pizza7.setOnClickListener(this);
        pizza8.setOnClickListener(this);
        
        return view;
    }

    public void onClick(View v) {
        ImageView iv = (ImageView)v;
        numerador++;
        iv.setVisibility(View.INVISIBLE);    
    }
}
