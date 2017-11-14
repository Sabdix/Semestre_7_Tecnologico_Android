package com.mios;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
import java.util.Calendar;

public class MiOS extends Activity
{
    TextView tvHora, tvLink, tvInvitado, tvFecha;
    EditText etPin;
    
    String usuario = "alex";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tvHora = (TextView)findViewById(R.id.tvHora);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvLink = (TextView)findViewById(R.id.tvLink);
        tvInvitado = (TextView)findViewById(R.id.tvInvitado);
        
        etPin = (EditText)findViewById(R.id.etPin);
        
        //Fecha y hora
        Calendar c = Calendar.getInstance();
        tvFecha.setText(
            c.get(Calendar.DATE) + "/" +
            c.get(Calendar.MONTH) + "/" +
            c.get(Calendar.YEAR)
        );
        tvHora.setText(
            c.getTime().toString().split(" ")[3]
        );
    }
    
    public void eventoNumeros(View view)
    {
        Button bt = (Button)view;
        etPin.append(bt.getText());
    }
    
    public void eventoOk(View view)
    {
        if( ! etPin.getText().toString().isEmpty())
        {
            consumeWS();
        }
        else
        {
            Toast.makeText(this, "Login incorrecto", 1).show();
        }
    }
    
    public void eventoBorrar(View view)
    {
        etPin.setText("");
    }
    
    public void eventoAvatar1(View view)
    {
        tvInvitado.setTextColor(Color.WHITE);
        tvLink.setTextColor(Color.BLUE);
        usuario = "alex";
    }
    
    public void eventoAvatar2(View view)
    {
        tvInvitado.setTextColor(Color.BLUE);
        tvLink.setTextColor(Color.WHITE);
        usuario = "invitado";
    }
    
    private void consumeWS()
    {
        try
        {
            String wsLogin = "/login/" + usuario + "/" + etPin.getText();
            String ip = this.getResources().getString(R.string.ip);
            
            //Conexion con el WS
            URL url = new URL(
                "http://"+ip+":8080/MiOS_WS/webresources/wsusuario"
                + wsLogin
            );
            HttpURLConnection conexion = (HttpURLConnection)
                url.openConnection();
            conexion.connect();
            
            //Lectura de la respuesta del WS
            BufferedReader br = new BufferedReader(
                new InputStreamReader(conexion.getInputStream())
            );
            String resultado = br.readLine();
            br.close();
            
            conexion.disconnect();
            
            if(Boolean.parseBoolean(resultado))
            {
                Intent intent = new Intent(this, Inicio.class);
                startActivity(intent);
                this.finish();
            }
            else
            {
                Toast.makeText(this, "Login incorrecto!", 1).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error.\n" + e.getMessage(), 1).show();
        }
    }
    
}
