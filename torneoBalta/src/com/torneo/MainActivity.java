package com.torneo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    ArrayList ganadores = new ArrayList(); 
    RadioGroup radioGroup1;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        radioGroup1 = (RadioGroup)findViewById(R.id.partido1);
         radioGroup2 = (RadioGroup)findViewById(R.id.partido2);
        radioGroup3 = (RadioGroup)findViewById(R.id.partido3);
        radioGroup4 = (RadioGroup)findViewById(R.id.partido4);
        
        
    }
    
    public void evtOnClickSiguiente(View v) {
        Intent intent = new Intent(this,Semifinal.class);
        RadioButton TheTextIsHere = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
        ganadores.add(TheTextIsHere.getText().toString());
        
        
        RadioButton TheTextIsHere2 = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());
        ganadores.add(TheTextIsHere2.getText().toString());
        
        RadioButton TheTextIsHere3 = (RadioButton) findViewById(radioGroup3.getCheckedRadioButtonId());
        ganadores.add(TheTextIsHere3.getText().toString());
        
        RadioButton TheTextIsHere4 = (RadioButton) findViewById(radioGroup4.getCheckedRadioButtonId());
        ganadores.add(TheTextIsHere4.getText().toString());
        
        intent.putExtra("ganaCuartos", ganadores);
        startActivity(intent);
        
        
        
    }
}
