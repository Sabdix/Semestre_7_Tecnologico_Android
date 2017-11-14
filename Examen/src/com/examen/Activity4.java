
package com.examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Activity4 extends Activity {
    ArrayList<String> sumas = new ArrayList<String>();
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity4);
        
        ListView lvSuma = (ListView)findViewById(R.id.lvSuma);
        sumas.add("Numero de Profesionistas que laboran "+this.getIntent().getStringExtra("Laboran"));
        sumas.add("Numero de Profesionanistas que no laboran "+this.getIntent().getStringExtra("noLaboran"));
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sumas);
        adaptador.notifyDataSetChanged();
        lvSuma.setAdapter(adaptador);
        
        
    }
    
}
