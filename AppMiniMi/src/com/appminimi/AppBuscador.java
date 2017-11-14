/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AppBuscador extends Activity 
{
    EditText etBuscar;
    ListView lvArchivosEncontrados;
    ArrayList<ItemEncontrado> encontrados;
    private String patron;

    /**
     * Called when the activity is first created.
     * @paramicicle
     */
    @Override
    public void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        this.setContentView(R.layout.appbuscador);
        
        etBuscar = (EditText)this.findViewById(R.id.etBuscar);
        lvArchivosEncontrados = (ListView)this.findViewById(R.id.lvArchivosEncontrados);
        
    }
    
    public void eventoBuscar(View view)
    {
        encontrados = new ArrayList<ItemEncontrado>();
        patron = etBuscar.getText().toString();
        encontrados.clear();
        if(patron != null) {
            if(!patron.isEmpty())
            {
                patron = patron.trim().toLowerCase();
                try {
                    encontrarArchivos(android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
                    //encontrarArchivos("/");
                    actualizarAdaptador();
                } catch(Exception e)
                {
                    Toast.makeText(this, "Error. "+e.getMessage(), 1).show();
                }
            }
        }
    }
    
    private void encontrarArchivos(String rutaBusqueda) 
    {
        File carpeta = new File(rutaBusqueda);
        File [] archivos = carpeta.listFiles();
        for(File archivo : archivos)
        {
            if(!archivo.getName().contains("secure") && !archivo.isHidden())
            {
                //Toast.makeText(this, "Archivo: "+archivo.getName(),0).show();
                if(archivo.getName().trim().toLowerCase().contains(patron)) 
                {
                    if(archivo.isDirectory())
                    {
                        asignaItem(archivo);
                        encontrarArchivos(archivo.getAbsolutePath());
                    } else {
                        asignaItem(archivo);
                    }
                } else if(archivo.isDirectory()) {
                    encontrarArchivos(archivo.getAbsolutePath());
                }
            }
        }
    }
    
    private void asignaItem(File f)
    {
        ItemEncontrado item = new ItemEncontrado();
        item.setNombre(f.getName());
        item.setRuta(f.getAbsolutePath());
        item.setTamanio(f.getUsableSpace());
        item.setCarpeta(f.isDirectory());
        encontrados.add(item);
    }

    private void actualizarAdaptador() 
    {
        Toast.makeText(this, "Se encontraron "+encontrados.size()+" coincidencias.",1).show();
        lvArchivosEncontrados.setAdapter(new MiAdaptador(this, R.layout.renglon, encontrados) {
            
            @Override
            public void porCadaRenglon(View view, Object object, int index) {
                TextView tv = (TextView)view.findViewById(R.id.tvTextoExp);
                ImageView iv = (ImageView)view.findViewById(R.id.ivIconoExp);
                
                tv.setText("Nombre: "+((ItemEncontrado)object).getNombre());
                tv.append("\nRuta: "+((ItemEncontrado)object).getRuta());
                
                if(encontrados.get(index).isCarpeta())
                {
                    iv.setImageResource(R.drawable.carpeta);
                } else {
                    iv.setImageResource(R.drawable.archivo);
                }
            }
        });
    }
    
}
