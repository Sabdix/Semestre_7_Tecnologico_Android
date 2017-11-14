package com.practica3.activitiys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.practica3.fragmentos.Fragmento1;

public class MainActivity extends Activity
{
    EditText etActivity;

    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etActivity = (EditText)findViewById(R.id.etActivity);
        
    }
    
    public void eventoPasar_Activity(View view) {
        Fragmento1 f1 = (Fragmento1) this.getFragmentManager().findFragmentById(R.id.fragmento1);
        EditText etF1 = (EditText) f1.getActivity().findViewById(R.id.etFragmento1);
        etF1.setText("Activity dijo: "+etActivity.getText());
        etActivity.setText(null);
    }
}
