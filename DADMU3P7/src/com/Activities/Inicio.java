
package com.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 *
 * @author sabdi
 */
public class Inicio extends Activity {

    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.inicio);
    }
    
    public void eventoAplicaciones(View view) {
        Intent intento = new Intent(this, Aplicaciones.class);
        startActivity(intento);
    }
    
}
