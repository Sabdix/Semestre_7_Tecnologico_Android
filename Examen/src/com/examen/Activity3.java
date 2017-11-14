
package com.examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Activity3 extends Activity {
    ArrayList<String> promedios = new ArrayList<String>();
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity3);
        
        ListView lvPromedios = (ListView)findViewById(R.id.lvPromedios);
        promedios.add("Edad promedio de personas que laboran "+this.getIntent().getStringExtra("LaboraEdad"));
        promedios.add("Edad promedio de personas que no laboran "+this.getIntent().getStringExtra("noLaboraEdad"));
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, promedios);
        adaptador.notifyDataSetChanged();
        lvPromedios.setAdapter(adaptador);
        
        
        
    }
    
}
