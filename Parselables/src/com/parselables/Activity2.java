
package com.parselables;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 *
 * @author sabdi
 */
public class Activity2 extends Activity {
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);  
        setContentView(R.layout.activity2);

        Nona nona = getIntent().getParcelableExtra("obj");

        Toast.makeText(this, nona.Edad + ", " + nona.description, 1).show();
        
        
    }
    
}
