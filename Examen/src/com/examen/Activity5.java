
package com.examen;

import android.app.Activity;

import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Activity5 extends Activity {
    ArrayList<String> promedios = new ArrayList<String>();
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity5);
        ListView lvPromedios = (ListView)findViewById(R.id.lvPromediosSueldo);
        promedios.add("Sueldo promedio Profesionistas "+this.getIntent().getStringExtra("sueldoP"));
        promedios.add("Sueldo promedio no Profesionistas "+this.getIntent().getStringExtra("sueldo"));
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, promedios);
        adaptador.notifyDataSetChanged();
        lvPromedios.setAdapter(adaptador);
    }
}
