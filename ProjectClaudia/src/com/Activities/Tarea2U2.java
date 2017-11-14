package com.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;
import com.tarea2.models.Base;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tarea2U2 extends Activity
{
    
    static Base bd;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bd = new Base(this, "Mi base", null, 1);
    }
    
    public void evtIniciar(View v){
        Intent intento = new Intent(this, Segundo.class);
        try {
             startActivity(intento);
        } catch (Exception ex) {
            Toast.makeText(this, "Explota por"+ex, 1).show();
            Logger.getLogger(Segundo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void evtCliente(View v){
        Intent intento = new Intent(this, ActCliente.class);
       
        try {
             startActivity(intento);
        } catch (Exception ex) {
            Toast.makeText(this, "Explota por"+ex, 1).show();
            Logger.getLogger(Segundo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void evtVendedor(View v){
         Intent intento = new Intent(this, ActVendedor.class);
        startActivity(intento);
    }
    
    public void evtProducto(View v){
         Intent intento = new Intent(this, ActProducto.class);
        startActivity(intento);
    }
}
