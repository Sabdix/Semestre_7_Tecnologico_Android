package com.computer;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    int componentes [];
    int contador;
    TextView total;
    Button btAgregar;
    ListView lvComponentes;
    ArrayList<String> goodComponentes = new ArrayList<String>();
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        componentes = new int[7];
        inicializar();
       
        
        total = (TextView)findViewById(R.id.total);
        btAgregar = (Button)findViewById(R.id.btAgregar);
        
        lvComponentes = (ListView)findViewById(R.id.lvComponentes);
        lvComponentes.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, goodComponentes));
        
        calcularComputadoras();
        colocarLista();
        btAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.agregar);
                dialog.setTitle("Agregar Componente");
                
                Button dialogButton = (Button)dialog.findViewById(R.id.btAgregar);
                
                final Spinner spComponentes = (Spinner)dialog.findViewById(R.id.spComponentes);
                final EditText etCantidad = (EditText)dialog.findViewById(R.id.etCantidad);
                
                spComponentes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                         Toast.makeText(view.getContext(), componentes[0]+"", 1).show();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {}
                    
                });
                
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                       componentes[(int)spComponentes.getSelectedItemId()] = Integer.parseInt(etCantidad.getText().toString());
                       modificarLista();
                       calcularComputadoras();
                       ArrayAdapter adaptador = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, goodComponentes);
                       adaptador.notifyDataSetChanged();
                       lvComponentes.setAdapter(adaptador);
                       total.setText("Computadoras que se pueden crear: " + contador);
                       dialog.dismiss();
                        
                    }
                });
                dialog.show();
            }
        });
        
    }
    
    private void colocarLista() {
        goodComponentes.add("Memoria Ram " + componentes[0]);
        goodComponentes.add("Tarjeta Madre " + componentes[1]);
        goodComponentes.add("Procesador " + componentes[2]);
        goodComponentes.add("Fuente de Poder " + componentes[3]);
        goodComponentes.add("Disco Duro " + componentes[4]);
        goodComponentes.add("Unidad de Disco " + componentes[5]);
        goodComponentes.add("Cooler " + componentes[6]);

    }
    
    private void modificarLista() {
        goodComponentes.clear();
        goodComponentes.add("Memoria Ram " + componentes[0]);
        goodComponentes.add("Tarjeta Madre " + componentes[1]);
        goodComponentes.add("Procesador " + componentes[2]);
        goodComponentes.add("Fuente de Poder " + componentes[3]);
        goodComponentes.add("Disco Duro " + componentes[4]);
        goodComponentes.add("Unidad de Disco " + componentes[5]);
        goodComponentes.add("Cooler " + componentes[6]);
    }
    
    private void inicializar() {
        for (int i=0; i<7; i++) {
            componentes[i] = 0;
        }
        
    }
    
    private void calcularComputadoras() {
        for (int i=0; i<7; i++) {
            contador = componentes[0];
            if (componentes[i] < contador)
                contador = componentes[i];
        }
    }
}
