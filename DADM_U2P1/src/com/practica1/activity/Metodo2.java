
package com.practica1.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.practica1.fragmentos.Fragmento2;

/**
 *
 * @author sabdi
 */
public class Metodo2 extends Activity {

    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.metodo2);
        
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.add(R.id.fragmento2, new Fragmento2());
        ft.commit();
        
    }
    
    public void evtOnClickSaludar(View view) {
        Toast.makeText(this, "Hallo Activity 2", 1).show();
    }
    
}
