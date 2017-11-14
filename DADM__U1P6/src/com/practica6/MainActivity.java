package com.practica6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    Spinner spDestino;
    ListView lvPaquetes;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        spDestino = (Spinner)findViewById(R.id.spDestino);
        lvPaquetes = (ListView)findViewById(R.id.lvPaquetes);
        
        final String destinos[] = this.getResources().getStringArray(R.array.destinos);
        
        //Evento para spinner
        spDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "Elegido: " + destinos[position], 1).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
        
        //Evento para ListView
        lvPaquetes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hacerReservacion(view);
            }
        });
    }
    
    private void hacerReservacion(View v) {
        try {
            TextView tv = (TextView)v;
            Intent intento = new Intent(this, Reservacion.class);
            intento.putExtra("destino", spDestino.getSelectedItem().toString());
            intento.putExtra("paquete", tv.getText().toString());
            startActivity(intento);
        } catch (Exception e) {
            Toast.makeText(this, "Error. \n"+e.getMessage(), 1).show();
        }
    }
}
