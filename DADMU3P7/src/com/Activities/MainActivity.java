package com.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;

public class MainActivity extends Activity
{
    TextView tvFecha, tvHora, tvLink, tvInvitado;
    EditText etPin;
    String  usuario = "sabdi";
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvHora = (TextView)findViewById(R.id.tvHora);
        tvLink = (TextView)findViewById(R.id.tvLink);
        tvInvitado = (TextView)findViewById(R.id.tvInvitado);
        
        etPin = (EditText)findViewById(R.id.etPin);
        
        //Fecha y Hora
        Calendar c = Calendar.getInstance();
        tvFecha.setText(c.get(Calendar.DATE) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));
        tvHora.setText(c.getTime().toString().split(" ")[3]);
    }
    
    public void eventoNumeros(View view) {
        Button bt = (Button)view;
        etPin.append(bt.getText());
    }
    
    public void eventoOk(View view) {
        if(!etPin.getText().toString().isEmpty()) {
            Peticion peticion = new Peticion();
            peticion.execute(etPin.getText().toString());
        } else {
            Toast.makeText(this, "Ingrese un pin", 1).show();
        }
    }
    
    public void eventoBorrar(View view) {
        etPin.setText("");
    }
    
    public void eventoAvatar1(View view) {
        usuario = "sabdi";
        tvLink.setTextColor(Color.BLUE);
        tvInvitado.setTextColor(Color.WHITE);
    }
    
    public void eventoAvatar2(View view) {
        usuario = "alondra";
        tvLink.setTextColor(Color.WHITE);
        tvInvitado.setTextColor(Color.BLUE);
    }
    
    /*
    Hilo para consumir el Web Service
    */
    
    class Peticion extends AsyncTask<Object, Object, Object> {

        @Override
        protected Object doInBackground(Object... params) {
            //Consumir WebService
            try {
                String path = "/login/"+ usuario + "/" + params[0];
                String ip = MainActivity.this.getResources().getString(R.string.ip);
                URL url = new URL("http://"+ip+":8080/p6/webresources/ws_usuarios" + path);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String respuesta = br.readLine();
                br.close();
                conexion.disconnect();
                return respuesta;
                
                
            } catch (Exception e) {
                e.printStackTrace();
                return "Error. "+ e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result); //To change body of generated methods, choose Tools | Templates.
            
            if (!result.toString().contains("Error")) {
                if (Boolean.parseBoolean(result.toString())) {
                    Intent intento = new Intent(MainActivity.this, Inicio.class);
                    startActivity(intento);
                    MainActivity.this.finish();
                } else {
                    Toast.makeText(MainActivity.this, "Niet", 1).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Error al consumir \n"+result, 1).show();
            }
        }
        
    }
}
