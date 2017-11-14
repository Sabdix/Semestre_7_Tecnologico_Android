package com.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void Software(View v) {
        Intent intento = new Intent(this, Software.class);
        startActivity(intento);
    }
    
    public void Juegos(View v) {
        Intent intento = new Intent(this, Juegos.class);
        startActivity(intento);
    }
    
    public void Hardware(View v) {
        Intent intento = new Intent(this, Hardware.class);
        startActivity(intento);
    }
    
    public void Total(View v) {
        Intent intento = new Intent(this, Total.class);
        startActivity(intento);
    }
}
