package com.mios;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author Alexander
 */
public class Inicio extends Activity 
{

    TextView tvBateria;
    LinearLayout llPrincipal;
    int imagen;
    
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            int level = intent.getIntExtra("level", 0);
            tvBateria.setText("     "+String.valueOf(level) + "%");
        }
    };
    @Override
    public void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        setContentView(R.layout.inicio);
        
        tvBateria = (TextView)findViewById(R.id.tvBattery);
        this.registerReceiver(this.mBatInfoReceiver, 
        new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        
        llPrincipal = (LinearLayout)findViewById(R.id.llPrincipal);
        llPrincipal.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                final Dialog dialogo = new Dialog(v.getContext());
                dialogo.setTitle("Cambiar de Fondo");
                dialogo.setContentView(R.layout.dialogo_fondo);
                ImageView f1 = (ImageView)dialogo.findViewById(R.id.bloqueo);
                ImageView f2 = (ImageView)dialogo.findViewById(R.id.fondo_space);
                ImageView f3 = (ImageView)dialogo.findViewById(R.id.fondo_space2);
                ImageView f4 = (ImageView)dialogo.findViewById(R.id.fondo_space3);
                imagen = R.drawable.fondo_space2;
                
                Button btAceptar = (Button)dialogo.findViewById(R.id.btFondoAceptar);
                
                btAceptar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();
                    }
                });
                
                f1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        llPrincipal.setBackgroundResource(R.drawable.bloqueo);
                        imagen = R.drawable.bloqueo;
                    }
                });
                
                f2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        llPrincipal.setBackgroundResource(R.drawable.fondo_space);
                        imagen = R.drawable.fondo_space;
                    }
                });
                
                f3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        llPrincipal.setBackgroundResource(R.drawable.fondo_space2);
                        imagen = R.drawable.fondo_space2;
                    }
                });
                
                f4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        llPrincipal.setBackgroundResource(R.drawable.fondo_space_3);
                        imagen = R.drawable.fondo_space_3;
                    }
                });
                
                dialogo.show();
                return true;
            }
        });
        
        
    }
    
    public void eventoAplicaciones(View view)
    {
        Intent intent = new Intent(this, Aplicaciones.class);
        intent.putExtra("imagen", imagen);
        startActivity(intent);
    }
    
    public void eventoCarrito(View view) {
        Intent intent = new Intent(this, MainActivity1.class);
        startActivity(intent);
    }
    
    public void eventoClick(View view) {
        Intent intent = new Intent(this, CuentaClick.class);
        startActivity(intent);
    }
    
    public void eventoNavegador(View view) {
        Intent intent = new Intent(this, Navegador.class);
        startActivity(intent);
    }
}
