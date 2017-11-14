/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo;

import android.app.Activity;
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
public class Finales extends Activity {
    LinearLayout semi;
    RadioButton vsF1;
    RadioButton vsF2;
    ArrayList<String> ganadores = new ArrayList <String>();
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    TextView verGanador;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // ToDo add your GUI initialization code here      
        
         setContentView(R.layout.finales);
        
//        LinearLayout linearSegundo = (LinearLayout)findViewById(R.id.linearSegundo);
//        linearSegundo.setGravity(Gravity.CENTER);
//        linearSegundo.setBackgroundResource(R.drawable.ic_launcher);
//        
        
      vsF1 = (RadioButton)findViewById(R.id.vsF1);
      vsF2 = (RadioButton)findViewById(R.id.vsF2); 
      verGanador =(TextView) findViewById(R.id.verGanador);
      
      
      ArrayList <String> ganaSemi = new ArrayList<String>();
      ganaSemi = this.getIntent().getStringArrayListExtra("ganaSemi");
      
      vsF1.setText(ganaSemi.get(0));
       vsF2.setText(ganaSemi.get(1));
         radioGroup1 = (RadioGroup)findViewById(R.id.partidoFinal);
    }
    
    public void onRadioButtonClicked0(View view) {
        
         RadioButton TheTextIsHere = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
        verGanador.setText("GANADOR!! "+TheTextIsHere.getText().toString());
  
}
     public void onRadioButtonClicked1(View view) {
          RadioButton TheTextIsHere = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
        verGanador.setText("GANADOR!! "+TheTextIsHere.getText().toString());
}
    
}
