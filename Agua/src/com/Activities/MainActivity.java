package com.Activities;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.Adapters.AdaptadorPaginas;
import com.Fragmentos.FragmentoAdeudos;
import com.Fragmentos.FragmentoPagos;
import com.ModeloBD.Adeudo;
import com.ModeloBD.ModeloBD;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity
{
    protected static ModeloBD bd;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bd = new ModeloBD(this, "Pagos", null, 1);
        refrescarAdeudos();
    }
    
    public void evtPago(View view) {
        Intent intento = new Intent(this, Pagos.class);
        startActivity(intento);
        this.finish();
    }
    
    public void evtGenerarConsumo(View view) {
        
        int consumo = (int)(Math.random()*144);
        
        try {
            bd.generarAdeudo(consumo, (int)(consumo * 2.24));
        } catch (Exception ex) {
            Toast.makeText(view.getContext(), "Error en Generar Consumo" + ex.getMessage(), 1);
        }
        refrescarAdeudos();
    }
    public void refrescarAdeudos() {
        ArrayList<String> adeudos = new ArrayList<String>();
        try {
            ArrayList<Adeudo> array = bd.listarAdeudos();
            for (int i=0; i<array.size(); i++) {
                adeudos.add(array.get(i).toString());
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error en listar Adeudos" + e.getMessage(), 1).show();
        }
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, adeudos);
        adaptador.notifyDataSetChanged();
        FragmentoAdeudos.setAdeudos(adaptador);
    }
    
}
