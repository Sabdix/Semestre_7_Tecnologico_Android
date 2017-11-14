package com.practica7;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 *
 * @author sabdi
 */
public class Productos extends Activity {
    ListView listaProductos;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.productos);
        
        listaProductos = (ListView)findViewById(R.id.lvProductos);
        
        final String array[];
        String windows1[] = {"Office2010", "FireFox", "MenuInicio", "Compatibilidad"};
        String windows2[] = {"Office2016", "Cortana", "Edge", "Menu Inicio"};
        String windows3[] = {"Office2013", "Chrome", "Sin Menu Inicio", "TabletMode"};
        int categoria = this.getIntent().getIntExtra("categoria", -1);
        
        switch(categoria) {
            case 0:
                array = windows1;
                break;
            case 1:
                array = windows2;
                break;
            case 2:
                array = windows3;
                break;
            default:
                array = null;
                break;
        }
        
        listaProductos.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, array));
    }
    
}
