package com.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity
{
    String nombre;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
        
    public void evtPartido1(View v) {
        EditText etNombre = (EditText)findViewById(R.id.etJugador);
        nombre = etNombre.getText().toString();
        
        Intent intento = new Intent(this,Partido1.class);
        intento.putExtra("nombre", nombre);
        startActivity(intento);
    }
}
