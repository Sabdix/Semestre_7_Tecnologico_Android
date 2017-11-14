package com.mios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.adapters.AdaptadorListaCanciones;
import com.adapters.Reproductor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author Alexander
 */
public class AppReproductor extends Activity
{
    ListView listadoCanciones;
    static ArrayList<Reproductor> listaCanciones;

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.reproductor);
        
        listadoCanciones = (ListView)findViewById(R.id.listadoCanciones);
        
        cancionesWS();
    }
    
    private void cancionesWS()
    {
        try 
        {
            String ip = this.getResources().getString(R.string.ip);
            
            //Conexion con el WS
            URL url = new URL(
                "http://" + ip + ":8080/MiOS_WS/webresources/wsreproductor"
            );
            HttpURLConnection conexion = (HttpURLConnection)
                url.openConnection();
            conexion.connect();
            
            //Lectura de la respuesta del WS
            BufferedReader br = new BufferedReader(
                new InputStreamReader(conexion.getInputStream())
            );
            final String resultado = br.readLine();
            br.close();
            
            conexion.disconnect();
            
            JSONObject json = new JSONObject(resultado);
            listaCanciones = new ArrayList<Reproductor>();
            for (int i = 0; i < json.length(); i++)
            {
                Reproductor cancion = new Reproductor();
                cancion.setId(json.getJSONArray("cancion" + (i+1)).getInt(0));
                cancion.setCancion(json.getJSONArray("cancion" + (i+1)).getString(1));
                cancion.setAlbum(json.getJSONArray("cancion" + (i+1)).getString(2));
                cancion.setInterprete(json.getJSONArray("cancion" + (i+1)).getString(3));
                
                listaCanciones.add(cancion);
            }
            listadoCanciones.setAdapter(new AdaptadorListaCanciones(this, R.layout.renglon_lista_musica, listaCanciones));
            listadoCanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(view.getContext(), Reproduciendo.class);
                    intent.putExtra("id", position);
                    intent.putExtra("cancion", listaCanciones.get(position).getCancion());
                    startActivity(intent);
                }
            });
        }
        catch (Exception e)
        {
            System.err.println("Error al consumir el WS Reproductor.\n" + e.getMessage());
            Toast.makeText(this, "Error al consumir el WS Reproductor.\n" + e.getMessage(), 1).show();
        }
    } 
    
}
