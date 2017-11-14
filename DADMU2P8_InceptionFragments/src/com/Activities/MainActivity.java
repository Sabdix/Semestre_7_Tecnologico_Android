package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.Fragments.Fragmento1;
import com.Fragments.Fragmento1_1;

public class MainActivity extends Activity
{
    
    EditText etFragmento1_1;
    Button bt1, bt1_1;
    Fragmento1_1 f2;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Fragmento1_1 f2 = (Fragmento1_1)this.getFragmentManager().findFragmentById(R.id.fragmento1_1);
        Fragmento1 f1 = (Fragmento1)this.getFragmentManager().findFragmentById(R.id.fragmento1);
        
        etFragmento1_1 = (EditText)f2.getActivity().findViewById(R.id.etFragmento1_1);
        final EditText etFragmento1 = (EditText)f1.getActivity().findViewById(R.id.etFragmento1);
        bt1 = (Button)f1.getActivity().findViewById(R.id.btFragmento1);
        bt1_1 = (Button)f2.getActivity().findViewById(R.id.btFragmento1_1);
        
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etFragmento1_1.setText("Fragmento1 dice: "+etFragmento1.getText().toString());
            }
        });
        
        bt1_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText etActivity = (EditText)findViewById(R.id.etActivity);
                etActivity.setText("Fragmento1_1 dice: "+etFragmento1_1.getText().toString());
            }
        });
        
        
    }
    
    public void evtOnClickComunicarF1(View view) {
        EditText etActivity = (EditText)findViewById(R.id.etActivity);
        Fragmento1 f1 = (Fragmento1)this.getFragmentManager().findFragmentById(R.id.fragmento1);
        EditText etFragmento1 = (EditText)f1.getActivity().findViewById(R.id.etFragmento1);
        etFragmento1.setText("Activity dice:"+etActivity.getText().toString());
        
    }
}
