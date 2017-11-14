package com.Activities;

import ModeloBD.ModeloBD;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity
{
    static ModeloBD bd;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bd = new ModeloBD(this, "Login", null, 1);
        

    }
    
    public void evtAcceder(View v) {
        EditText etUsuario = (EditText)findViewById(R.id.etUsser);
        EditText etPass = (EditText)findViewById(R.id.etPass);
        Intent intento = new Intent(this, Entrada.class);
        intento.putExtra("nombre", etUsuario.getText().toString());
        intento.putExtra("pass", etPass.getText().toString());
        startActivity(intento);
    }
}
