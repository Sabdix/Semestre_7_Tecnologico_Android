package com.cocteleria;

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
import com.clases_java.Coctel;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    ListView lvCocteles;
    Button btAgregar;
    Button btVotar;
    ArrayList<Coctel> cocteles = new ArrayList<Coctel>();
    ArrayList<String> coctel = new ArrayList<String>();
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        lvCocteles = (ListView)findViewById(R.id.lvCocteles);
        btAgregar = (Button)findViewById(R.id.btAgregar);
        btVotar = (Button)findViewById(R.id.btVotar);
        btVotar.setEnabled(false);
        
        btAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.agregar);
                dialog.setTitle("Agregar Coctel");
                Button Button;
                
                Button dialogButton = (Button)dialog.findViewById(R.id.btContinuar);
                Button dialogButton2 = (Button)dialog.findViewById(R.id.btCancelar);
                final EditText etNombre = (EditText)dialog.findViewById(R.id.etNombre);
                final EditText etIngredientes = (EditText)dialog.findViewById(R.id.etIngredientes);
                
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        cocteles.add(new Coctel(etNombre.getText().toString(), etIngredientes.getText().toString()));
                        btVotar.setEnabled(true);
                        copiarArreglo();
                        ArrayAdapter adaptador = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, coctel);
                        adaptador.notifyDataSetChanged();
                        lvCocteles.setAdapter(adaptador);
                        dialog.dismiss();
                    }
                });
                
                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();       
            }
        });
        
        btVotar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.votar);
                dialog.setTitle("Votar");
                
                Button dialogbtVotar = (Button)dialog.findViewById(R.id.btDVotar);
                Button dialogbtCancelar = (Button)dialog.findViewById(R.id.btDCancelar);
                final Spinner spCocteles = (Spinner)dialog.findViewById(R.id.spCocteles);
                
                ArrayAdapter adaptador = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, coctel);
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCocteles.setAdapter(adaptador);
                
                dialogbtVotar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        cocteles.get((int)spCocteles.getSelectedItemId()).setVotos( cocteles.get((int)spCocteles.getSelectedItemId()).getVotos()+1);
                        copiarArreglo();
                        ArrayAdapter adaptador = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, coctel);
                        adaptador.notifyDataSetChanged();
                        lvCocteles.setAdapter(adaptador);
                        dialog.dismiss();
                    }
                });
                dialogbtCancelar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        
        lvCocteles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.ingredientes);
                dialog.setTitle("Ingredientes");
                
                TextView tvIngredientes = (TextView)dialog.findViewById(R.id.tvIngredientes);
                Button btAceptar = (Button)dialog.findViewById(R.id.btAceptar);
                
                tvIngredientes.setText(cocteles.get(position).getIngredientes());
                
                btAceptar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
            
        });
    }
    
    private void copiarArreglo() {
        coctel.clear();
        for(int i=0; i<cocteles.size(); i++) {
            coctel.add(cocteles.get(i).getNombre()+" Votos: "+cocteles.get(i).getVotos());
        }
    }
}
