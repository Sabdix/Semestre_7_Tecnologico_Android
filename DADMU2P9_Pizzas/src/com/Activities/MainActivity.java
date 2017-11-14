package com.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.Fragments.Fragmento1;
import com.Fragments.Fragmento2;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Colocar en orientación vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
    }
    
    public void eventoEvaluation(View view) {
        Intent intento = new Intent(this, Resultado.class);
        Fragmento1 f1 = (Fragmento1)this.getFragmentManager().findFragmentById(R.id.fragmento1);
        Fragmento2 f2 = (Fragmento2)this.getFragmentManager().findFragmentById(R.id.fragmento2);
        TextView tvPeticion = (TextView)f1.getActivity().findViewById(R.id.tvFragmento1);
        String []peticion = tvPeticion.getText().toString().split(" ");
        // El 7 guarda el valor generado automáticamente
        intento.putExtra("numerador", Fragmento2.numerador);
        intento.putExtra("seleccion", Integer.parseInt(peticion[7]));
        startActivity(intento);
        finish();
    }
}
