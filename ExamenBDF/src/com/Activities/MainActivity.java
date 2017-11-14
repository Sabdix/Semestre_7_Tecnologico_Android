package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.Fragmentos.Fragmento1;
import com.Fragmentos.Fragmento2;
import com.Modelo.Casa;
import com.Modelo.ModeloBD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends Activity
{
    ModeloBD bd;
    EditText etNinos;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bd = new ModeloBD(this, "Base1", null, 1);
        refrescarCasas();
        refreshPromedio();
        
        etNinos = (EditText)findViewById(R.id.etNino);
        Button etAgregarNino = (Button)findViewById(R.id.btAgregarNino);
        
        etAgregarNino.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bd.insertNinos(Integer.parseInt(etNinos.getText().toString()));
                etNinos.setText("");
                refrescarCasas();
                refreshPromedio();
                
                
            }
        });
        
        
    }
    
    public void refrescarCasas() {
        ArrayList<String> casas = new ArrayList<String>();
        try {
            ArrayList<Casa> array = bd.listarCasas();
            for (int i=0; i<array.size(); i++) {
                casas.add(array.get(i).toString());
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error en listar Adeudos" + e.getMessage(), 1).show();
        }
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, casas);
        adaptador.notifyDataSetChanged();
        Fragmento1.setCasas(adaptador);
    }
    
    public void refreshPromedio() {
        int promedio;
        try {
            promedio = bd.calcularPromedio();
            Fragmento2.setPromedio(promedio);
        } catch (Exception ex) {
            Toast.makeText(this, "Error en Promedio " + ex.getMessage(), 1).show();
        }

    }
}
