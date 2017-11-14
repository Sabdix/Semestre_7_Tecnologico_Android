package com.examen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.Clases.GraficaBarras;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    int sueldoP = 4000;
    int sueldo = 0;
    int contador = 4;
    int sumaPLaboran = 2;
    int sumaPNoLabora = 0;
    int EdadsumaLabora = 30;
    int EdadsumaNoLabora = 40;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btSiguiente = (Button)findViewById(R.id.btAgregar);
        Button btPromedioEdad = (Button)findViewById(R.id.btPromedioEdad);
        Button btProfesionistas = (Button)findViewById(R.id.btProfesionistas);
        Button btPromedioSalario = (Button)findViewById(R.id.btPromedioSalario);
        
        btPromedioSalario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarPromedio();
            }
        });
        
        btProfesionistas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pasarNumero();
            }
        });
        
        btPromedioEdad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pasarPromedio();
            }
        });
        
        btSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.activity2);
                dialog.setTitle("Agregar");
                
                final EditText Edad = (EditText)dialog.findViewById(R.id.etEdad);
                final EditText Labora = (EditText)dialog.findViewById(R.id.etTrabaja);
                final EditText Profesionista = (EditText)dialog.findViewById(R.id.etProfesion);
                final EditText Sueldo = (EditText)dialog.findViewById(R.id.etSueldo);
                Button dialogAgregar = (Button)dialog.findViewById(R.id.btAgregar);
                dialogAgregar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        contador++;
                        if (Labora.getText().toString().equalsIgnoreCase("Si")) {
                            EdadsumaLabora += Integer.parseInt(Edad.getText().toString());
                            if (Profesionista.getText().toString().equalsIgnoreCase("Si")) {
                                sumaPLaboran++;
                                sueldoP += Integer.parseInt(Sueldo.getText().toString());
                            } else {
                                sueldo += Integer.parseInt(Sueldo.getText().toString());
                            }
                        } else {
                            if (Profesionista.getText().toString().equalsIgnoreCase("Si")) {
                                sumaPNoLabora++;
                            }
                            EdadsumaNoLabora += Integer.parseInt(Edad.getText().toString());
                        }
                        dialog.dismiss();
                    }
                });
                
                dialog.show();
            }
        });
    }
    
    private void pasarPromedio() {
        /*
        Intent intento = new Intent(this, Activity3.class);
        intento.putExtra("noLaboraEdad", EdadsumaNoLabora/contador+"");
        intento.putExtra("LaboraEdad", EdadsumaLabora/contador+"");
        startActivity(intento);
        */
        int array[] = {(EdadsumaNoLabora/contador),(EdadsumaLabora/contador)};
        GraficaBarras bar = new GraficaBarras();
        Intent lineIntent = bar.getIntent(this, array, "Promedio de Edad 1.- No laboran 2.- Laboran");
        startActivity(lineIntent);
    }
    
    private void pasarNumero() {
        /*
        Intent intento = new Intent(this, Activity4.class);
        intento.putExtra("Laboran", sumaPLaboran+"");
        intento.putExtra("noLaboran", sumaPNoLabora+"");
        startActivity(intento);
        */
        int array[] = {sumaPLaboran,sumaPNoLabora};
        GraficaBarras bar = new GraficaBarras();
        Intent lineIntent = bar.getIntent(this, array, "1.- Profesionistas que Laboran 2.- Profesionistas que no Laboran");
        startActivity(lineIntent);
    }
    
    private void enviarPromedio() {
        /*
        Intent intento = new Intent(this, Activity5.class);
        intento.putExtra("sueldoP", sueldoP/contador+"");
        intento.putExtra("sueldo", sueldo/contador+"");
        startActivity(intento);
        */
        int array[] = {(sueldo/contador),(sueldoP/contador)};
        GraficaBarras bar = new GraficaBarras();
        Intent lineIntent = bar.getIntent(this, array, "Promedio de nómina mensual 1.- No profesionista 2.- Profesionaista");
        startActivity(lineIntent);
    }
}
