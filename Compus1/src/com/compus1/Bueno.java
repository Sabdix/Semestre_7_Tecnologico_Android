/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compus1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author supernona
 */
public class Bueno extends Activity implements Serializable{
    TextView listaBuenos, listaMalos;
    LinearLayout bueno, malo;
    ListView mainListView;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.buenos);
        
       bueno = (LinearLayout)findViewById(R.id.buenos);
        malo = (LinearLayout)findViewById(R.id.malos);
        
        //mainListView = (ListView) findViewById(R.id.ListView);
        
       Intent intent = getIntent();
       ArrayList<Equipo> buenos =  (ArrayList<Equipo>) intent.getExtras().getSerializable("lista");
    
        for(int i=0; i<buenos.size(); i++){
            
            
            if(buenos.get(i).getFunciona()==true){
                
            TextView j = new TextView(this);
            j.setText(buenos.get(i).getNombre()+" "+buenos.get(i).getCompu()+" Funciona");
            bueno.addView(j);
          
            }else{
                TextView j = new TextView(this);
                j.setText(buenos.get(i).getNombre()+" "+buenos.get(i).getCompu()+" No Funciona");
                bueno.addView(j);
                
             //  listaMalos.setText(buenos.get(i).getNombre()+" "+buenos.get(i).getCompu()+" No Funciona");
        
            }
        }
    }
    
}
