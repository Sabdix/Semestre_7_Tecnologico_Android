package com.practica7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.clases_java.Categoria;
import com.clases_java.MiAdaptador;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    ListView listaCategorias;
    ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        listaCategorias = (ListView)findViewById(R.id.lvCategorias);
        
        Categoria obj = new Categoria();
        obj.setNombre("Windows 1");
        obj.setImagen(R.drawable.imagen1);
        obj.setSeleccionar(false);
        categorias.add(obj);
        
        obj = new Categoria();
        obj.setNombre("Windows 2");
        obj.setImagen(R.drawable.imagen2);
        obj.setSeleccionar(false);
        categorias.add(obj);
        
        obj = new Categoria();
        obj.setNombre("Windows 3");
        obj.setImagen(R.drawable.imagen3);
        obj.setSeleccionar(false);
        categorias.add(obj);
        
        listaCategorias.setAdapter(new MiAdaptador(this, R.layout.renglon, categorias) {
            @Override
            public void renglonLista(View view, final int pos) {
                ImageView img = (ImageView)view.findViewById(R.id.ivCategoria);
                TextView tv = (TextView)view.findViewById(R.id.tv2);
                RadioButton radio = (RadioButton)view.findViewById(R.id.rb1);
                
                img.setImageResource(categorias.get(pos).getImagen());
                tv.setText(categorias.get(pos).getNombre());
                radio.setChecked(categorias.get(pos).isSeleccionar());
                
                radio.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        muestraProductos(pos);
                    }
                });
            }
        });
    }
    
    private void muestraProductos(int pos) {
        final Context contexto = this;
        Intent i = new Intent(contexto, Productos.class);
        i.putExtra("categoria", pos);
        startActivity(i);
    }
}
