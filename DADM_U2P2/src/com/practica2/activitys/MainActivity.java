package com.practica2.activitys;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        Fregmento obj = new Fregmento();
        ft.add(R.id.fragmento, obj);
        ft.commit();
    }
    
    public void evtOnClickSaludar(View view) {
        Toast.makeText(this, "Bon Jorno", 1).show();
    }
}
