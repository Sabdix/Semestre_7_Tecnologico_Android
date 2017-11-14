package com.codigo;


import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity
{
    LinearLayout layout;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        layout = (LinearLayout)findViewById(R.id.llPrincipal);
        
        Button btEjemplo = new Button(this);
        btEjemplo.setLayoutParams(new LayoutParams(55, 55));
        btEjemplo.setText("Ejemplo");
        layout.addView(btEjemplo);
    }
}
