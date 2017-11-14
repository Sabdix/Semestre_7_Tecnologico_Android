/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Semifinal extends Activity {
    LinearLayout semi;
    RadioButton vsS11;
    RadioButton vsS12;
    RadioButton vsS21;
    RadioButton vsS22;
    ArrayList<String> ganadores = new ArrayList <String>();
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here 
        setContentView(R.layout.semifinal);
        
//        LinearLayout linearTercero = (LinearLayout)findViewById(R.id.);
//        linearSegundo.setGravity(Gravity.CENTER);
//        linearSegundo.setBackgroundResource(R.drawable.ic_launcher);
        
      vsS11 = (RadioButton)findViewById(R.id.vsS11);
      vsS12 = (RadioButton)findViewById(R.id.vsS12); 
      vsS21 = (RadioButton)findViewById(R.id.vsS21);
      vsS22 = (RadioButton)findViewById(R.id.vsS22);
      
      ArrayList <String> ganaCuartos = new ArrayList<String>();
      ganaCuartos = this.getIntent().getStringArrayListExtra("ganaCuartos");
      
      vsS11.setText(ganaCuartos.get(0));
       vsS12.setText(ganaCuartos.get(1));
        vsS21.setText(ganaCuartos.get(2));
         vsS22.setText(ganaCuartos.get(3));
         radioGroup1 = (RadioGroup)findViewById(R.id.partidoSemi1);
         radioGroup2 = (RadioGroup)findViewById(R.id.partidoSemi2);
        
        
        
    }
    
     public void evtOnClickSiguiente(View v) {
        Intent intent = new Intent(this,Finales.class);
        RadioButton TheTextIsHere = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
        ganadores.add(TheTextIsHere.getText().toString());
        
        
        RadioButton TheTextIsHere2 = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());
        ganadores.add(TheTextIsHere2.getText().toString());
       
        
        intent.putExtra("ganaSemi", ganadores);
        startActivity(intent);
        
        
        
    }
    
}
