/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appminimi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 *
 * @author JoséMendoza
 */
public class AppNotepad extends Activity {

    Spinner spinner_fuente, spinnerTam;
    EditText et_pagina;
    String [] fuentes = {"Monospace","Sans","Serif"};
    String [] tams = {"8","16","32"};
    boolean modoGuardar;
    byte [] archivo;
    boolean modoVinieta;
    
    
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.notepad);
        // ToDo add your GUI initialization code here 
        
        spinner_fuente = (Spinner)this.findViewById(R.id.spinner_fuente);
        spinnerTam = (Spinner)this.findViewById(R.id.spinnerTam);
        et_pagina = (EditText)this.findViewById(R.id.et_pagina);
        
        
        
        spinner_fuente.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, fuentes)
        );
        
        spinnerTam.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item,tams));
         
        spinnerTam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
                switch(position){
                    case 0:
                        et_pagina.setTextSize(8);
                        break;
                    case 1:
                        et_pagina.setTextSize(16);
                        break;
                    case 2:
                        et_pagina.setTextSize(32);
                        break;    
            
                }
            }
          
          

            public void onNothingSelected(AdapterView<?> parent) {
                
            }
        });
               
        spinner_fuente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
                switch(position){
                    case 0:
                        et_pagina.setTypeface(Typeface.MONOSPACE);
                        break;
                    case 1:
                        et_pagina.setTypeface(Typeface.SANS_SERIF);
                        break;
                    case 2:
                        et_pagina.setTypeface(Typeface.SERIF);
                        break;    
            
                }
            }
            
            public void onNothingSelected(AdapterView<?> parent) {
                
            }
        });
        
        et_pagina.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (modoVinieta) {
                    if(s.toString().substring(start).contains("\n")){
                        et_pagina.append("♦ ");
                    }
                }
            }
            public void afterTextChanged(Editable arg0) {
            }

        });    
    }
 
    public void eventoNegritas(View view)
    {
    android.widget.ToggleButton tgBt = (android.widget.ToggleButton)view;
    if(tgBt.isChecked())
    {
        et_pagina.setTypeface(et_pagina.getTypeface(),Typeface.BOLD);
    }else
        {
            et_pagina.setTypeface(et_pagina.getTypeface(),Typeface.NORMAL);
        }
    }
    
    public void eventoCursiva(View view)
    {
    android.widget.ToggleButton tgBt = (android.widget.ToggleButton)view;
    if(tgBt.isChecked())
    {
        et_pagina.setTypeface(et_pagina.getTypeface(),Typeface.ITALIC);
    }else
        {
            et_pagina.setTypeface(et_pagina.getTypeface(),Typeface.NORMAL);
        }
    }
    
    public void eventoIzquierda(View v)
    {
        et_pagina.setGravity(Gravity.LEFT);
    }
    
    public void eventoCentrado(View v)
    {
        et_pagina.setGravity(Gravity.CENTER_HORIZONTAL);
    }
    public void eventoDerecha(View v)
    {
        et_pagina.setGravity(Gravity.RIGHT);
    }
    
    public void eventoColor(View v)
    {
        et_pagina.setTextColor(android.graphics.Color.RED);
    }
    
    
    public void eventoVinietas(View v) {
        android.widget.ToggleButton tgbt = (android.widget.ToggleButton) v;
        if (tgbt.isChecked()) {
            modoVinieta = true;
        } else {
            modoVinieta = false;
        }
    }
    
    public void eventoInterlineado(View v) {
        android.widget.CheckBox cb = (android.widget.CheckBox) v;
        if (cb.isChecked()) {
            et_pagina.setLineSpacing(2,2);
        } else {
            et_pagina.setLineSpacing(1,1);
        }
    }
   
    public void eventoGuardar(View view)
    {
    modoGuardar =true;
    Intent i = new Intent(this, Abrir_guardar.class);
    i.putExtra("modoGuardar", modoGuardar);
    this.startActivityForResult(i, 1);
    }
    
    public void eventoAbrir(View view)
    {
    modoGuardar =false;
    Intent i = new Intent(this, Abrir_guardar.class);
    i.putExtra("modoGuardar", modoGuardar);
    this.startActivityForResult(i, 1);
    }
    
   

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode==1)&&resultCode==RESULT_OK )
            {
                Toast.makeText(this, "Exito! ", 1).show();
            }else
                {
                    archivo = data.getByteArrayExtra("archivo");
                    et_pagina.setText("");
                    for(int i=0;i<archivo.length;i++)
                    {
                        et_pagina.append(""+(char)archivo[i]);
                    }
                }
    }
}
