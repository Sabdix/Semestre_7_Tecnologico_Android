package com.practica1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practica1U1 extends Activity implements View.OnClickListener //Tercer Método
{
    EditText etNombre;
    Button btDespedir, btInvitar;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        etNombre = (EditText)findViewById(R.id.etNombre);
        btDespedir = (Button)findViewById(R.id.btDespedir);
        btInvitar = (Button)findViewById(R.id.btInvitar);
        
        //Segundo Método
        btDespedir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "See You Later " + etNombre.getText(), 1).show();
            }
        });
        btInvitar.setOnClickListener(this);
    }
    //Primer Método
    public void evtOnClickSaludar(View perenganito) 
    {
        Toast.makeText(this, "Hola " + etNombre.getText(), Toast.LENGTH_LONG).show();
                
    }
    //Tercer Método
    public void onClick(View v) {
        Toast.makeText(this, "Amo a pistear " + etNombre.getText(), Toast.LENGTH_LONG).show();
    }
}
