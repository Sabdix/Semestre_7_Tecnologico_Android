package com.parselables;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    private Nona obj = new Nona();
    @Override

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btSiguiente = (Button)findViewById(R.id.btSiguiente);
        
        btSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                siguienteActivity(obj);
            }
        });
    }
    
    private void siguienteActivity(Nona obj) {
        Intent intento = new Intent(this, Activity2.class); 
        intento.putExtra("obj", obj);
        startActivity(intento);
    }
}
