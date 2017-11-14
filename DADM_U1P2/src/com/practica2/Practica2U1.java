package com.practica2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Practica2U1 extends Activity
{
    EditText etDestinatario;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etDestinatario = (EditText)findViewById(R.id.etDestinatario);
    }
    
    public void evtOnClickSiguiente(View v) {
        String destino = etDestinatario.getText().toString().trim();
        
        Intent intento = new Intent(this, Enviar_Msg.class);
        intento.putExtra("destino", destino);
        startActivity(intento);
        this.finish();
    }
}
