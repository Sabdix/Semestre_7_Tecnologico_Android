
package com.mios;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 *
 * @author sabdi
 */
public class CuentaClick extends Activity {

    TextView tvCuenta;
    int contador = 0;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.botonrojo);
        tvCuenta = (TextView)findViewById(R.id.tvClick);
        
    }
    
    public void eventoClick2(View view) {
        contador++;
        tvCuenta.setText(contador+"");
    }
}
