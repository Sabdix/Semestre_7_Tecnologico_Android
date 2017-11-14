package com.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends Activity
{
    String ip;
    int puerto;
    EditText etMsg;
    LinearLayout llPrincipal;
    Hilo hilo;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        llPrincipal = (LinearLayout)findViewById(R.id.linearWasap);
        etMsg = (EditText)findViewById(R.id.etMsg);
        hilo = new Hilo();
        hilo.execute("");
        
        muestraDialogo();
        
    }
    
    public void eventoEnviar(View view) {
        String msg = etMsg.getText().toString();
        etMsg.setText("");
        HiloEmisor hEmisor = new HiloEmisor();
        hEmisor.execute(msg);
    }
    
    private void muestraMensajes(String msg, boolean esEmisor) {
        TextView tv = new TextView(this);
        tv.setText(msg);
        if(esEmisor) {
            tv.setBackgroundResource(R.drawable.rounded_edges_1);
            tv.setTextColor(Color.GREEN);
            tv.setGravity(Gravity.LEFT);
        } else {
            tv.setBackgroundResource(R.drawable.rounded_edges_2);
            tv.setTextColor(Color.BLUE);
            tv.setGravity(Gravity.RIGHT);
        }
        llPrincipal.addView(tv);
    }
    
    private void muestraDialogo() {
        final Dialog dialogo = new Dialog(this);
        dialogo.setTitle("Parametros de Conexion");
        dialogo.setContentView(R.layout.dialogo);
        
        final EditText etIP = (EditText)dialogo.findViewById(R.id.etIP);
        final EditText etPuerto = (EditText)dialogo.findViewById(R.id.etPuerto);
        Button btConectar = (Button)dialogo.findViewById(R.id.btConectar);
        
        btConectar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ip = etIP.getText().toString();
                puerto = Integer.parseInt(etPuerto.getText().toString());
                dialogo.dismiss();
            }
        });
        
        dialogo.show();
        dialogo.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                if (ip != null) {
                    if(ip.isEmpty()) {
                        MainActivity.this.finish();
                    }
                } else {
                    MainActivity.this.finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (hilo != null) {
            hilo.cancel(true);
        }
    }
    
    
    
    //Hilo Servidor
    class Hilo extends AsyncTask<Object, Object, Object> {

        @Override
        protected Object doInBackground(Object... params) {
            for (;;) {
                receptor();
            }
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
            
            if(values[0].equals("error")) {
                Toast.makeText(MainActivity.this, "Error en el receptor.\n"+values[1], 1).show();
            } else {
                muestraMensajes(values[1].toString(), false);
            }
        }
        
        private void receptor() {
            ServerSocket servidor = null;
            Socket canal = null;
            try {
                servidor = new ServerSocket(7779);
                canal = servidor.accept();
                
                ObjectInputStream ois = new ObjectInputStream(canal.getInputStream());
                this.publishProgress("", ois.readObject().toString());
                ois.close();
                canal.close();
                servidor.close();
            } catch (Exception e) {
                this.publishProgress("error", e.getMessage());
            }
        }
    }
    
    //Hilo Emisor
    class HiloEmisor extends AsyncTask<Object, Object, Object> {

        @Override
        protected Object doInBackground(Object... params) {
            Socket cliente =null;
            try {
                cliente = new Socket(ip, puerto);
                if(cliente.isConnected()){
                    ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
                    oos.writeObject(params[0]);
                    this.publishProgress("", params[0]);
                    oos.close();
                }
                cliente.close();
            } catch (Exception e) {
                this.publishProgress("error", e.getMessage());
            }
            return "";
            
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
            
            if(values[0].equals("error")) {
                Toast.makeText(MainActivity.this, "Error en el Emisor.\n"+values[1], 1).show();
            } else {
                muestraMensajes(values[1].toString(), true);
            }
        }
        
    }
}
