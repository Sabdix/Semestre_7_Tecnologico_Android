package com.practica3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        LinearLayout contenedor = new LinearLayout(this);
        contenedor.setOrientation(LinearLayout.VERTICAL);
        contenedor.setGravity(Gravity.CENTER);
        contenedor.setBackgroundColor(Color.BLUE);
        
        TextView tvCel = new TextView(this);
        tvCel.setText("Celular: ");
        tvCel.setTextColor(Color.parseColor("#00ffcc"));
        tvCel.setTypeface(Typeface.SERIF, Typeface.BOLD);
        contenedor.addView(tvCel);
        
        final EditText etNumCel = new EditText(this);
        etNumCel.setHint("Ingresa el número de celular");
        etNumCel.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        
        etNumCel.setInputType(InputType.TYPE_CLASS_PHONE);
        contenedor.addView(etNumCel);
        
        ToggleButton tbSiguiente = new ToggleButton(this);
        tbSiguiente.setText("Siguiente");
        tbSiguiente.setTextOn("Siguiente On");
        tbSiguiente.setTextOff("Siguiente Off");
        tbSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                invocaSiguiente(etNumCel.getText());
            }
        });
        contenedor.addView(tbSiguiente);
        
        setContentView(contenedor);
    }
    
    private void invocaSiguiente(Editable celular) {
        if(celular != null) {
            try {
                Intent intento = new Intent(this, Segundo.class);
                intento.putExtra("cel", celular.toString());
                startActivity(intento);
            } catch (Exception e) {
                Toast.makeText(this, "Error al invocar. \n" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
