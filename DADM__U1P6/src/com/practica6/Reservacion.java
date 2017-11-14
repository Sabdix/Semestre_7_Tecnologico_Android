/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Reservacion extends Activity {

    Spinner spHoteles;
    ListView lvHabitaciones;
    String hoteles[] = {"El patito Modorsito", "Licky Couldron", "SabdiInn", "Taberna de Moe"};
    ArrayList<String> habitaciones = new ArrayList<String>();
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.reservacion);  
        spHoteles = (Spinner)findViewById(R.id.spHoteles);
        lvHabitaciones = (ListView)findViewById(R.id.lvHabitaciones);
        
        habitaciones.add("1 Cama");
        habitaciones.add("2 Camas");
        habitaciones.add("1 Litera");
        
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hoteles);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHoteles.setAdapter(adaptador);
        
        //Lo mismo que el adaptador per en una sola línea de código
        lvHabitaciones.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, habitaciones));
        
        lvHabitaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imprimirReservacion(view);
            }
        });
        
    }
    
    private void imprimirReservacion(View v) {
        try {
            TextView tv = (TextView) v;
            Toast.makeText(this, "Reservación: \n Destino: "+this.getIntent().getStringExtra("destino")+"\nPaquete: "+this.getIntent().getStringExtra("paquete")+"\nHotel: "+spHoteles.getSelectedItem()+"\nHabitacion: "+tv.getText().toString(), 1).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error. \n"+e.getMessage(), 1).show();
        }
    }
    
}
