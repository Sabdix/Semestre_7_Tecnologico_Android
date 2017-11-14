package com.compus1;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import static android.util.Log.v;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends Activity
{
  
    LinearLayout lMain;
    EditText nombre;
    Button guarda,regresar;
    public ArrayList<Equipo> lista=new ArrayList<Equipo>();
    ArrayList<String> coctel = new ArrayList<String>();
    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        nombre = (EditText)findViewById(R.id.nombre);
     //   guarda = (Button)findViewById(R.id.agregar);
      //  regresar = (Button)findViewById(R.id.verCom);
      
     /* guarda.setOnClickListener(new View.OnClickListener(){
             Equipo obj = new Equipo();
            public void onClick(View v){
               lista.add(obj);
               lista.get(lista.size()-1).setNombre(nombre.getText().toString().substring(3));
               lista.get(lista.size()-1).setCompu(lista.size()-1);
          //     lista.get(lista.size()).
            //   obj.setNombre(nombre.getText().toString().substring(3));
             //  obj.setCompu(lista.size()+1);
             
                if(nombre.getText().toString().contains("1")==true){
                    lista.get(lista.size()-1).setFunciona(true);
               //     obj.setFunciona(true);
                }else{
                    lista.get(lista.size()-1).setFunciona(false);
                 //   obj.setFunciona(false);
                }
               // lista.add(obj);
                copiarArreglo(lista.size()+1);
              
            }
        });*/
        
        regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.votar);
                dialog.setTitle("Partes");
                Button dialogbtCancelar = (Button)dialog.findViewById(R.id.btDCancelar);
                final Spinner spCocteles = (Spinner)dialog.findViewById(R.id.spCocteles);
                
                ArrayAdapter adaptador = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, coctel);
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCocteles.setAdapter(adaptador);
                
                dialogbtCancelar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
              
                dialog.show();
            }
        });
        
    }
    
    
    public void Guardar(View view) {
         Equipo obj = new Equipo();
               lista.add(obj);
              // lista.get(lista.size()-1).setNombre(nombre.getText().toString().substring(3));
             //  lista.get(lista.size()-1).setCompu(lista.size()-1);
          //     lista.get(lista.size()).
               obj.setNombre(nombre.getText().toString().substring(3));
               obj.setCompu(lista.size()+1);
             
                if(nombre.getText().toString().contains("1")==true){
                  //  lista.get(lista.size()-1).setFunciona(true);
                    obj.setFunciona(true);
                }else{
                   // lista.get(lista.size()-1).setFunciona(false);
                    obj.setFunciona(false);
                }
                lista.add(obj);
                copiarArreglo(lista.size()-1);
        }
     
    
    private void copiarArreglo(int i) {
        //coctel.clear();
        coctel.add(lista.get(i).getNombre()+" "+lista.get(i).getCompu());
         Toast.makeText(this, lista.get(lista.size()).getNombre(),Toast.LENGTH_LONG).show();
    }
}
    
     
     

