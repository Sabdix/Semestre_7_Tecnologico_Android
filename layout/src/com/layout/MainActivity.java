package com.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    Button bSiguiente;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bSiguiente = (Button)findViewById(R.id.Siguiente);
        
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                siguienteView();
            }
        });
    }
    
    private void siguienteView(){
        try {
            Intent intento = new Intent(this, Segundo.class);
            startActivity(intento);
        } catch (Exception e) {
        }
    }
    
}
