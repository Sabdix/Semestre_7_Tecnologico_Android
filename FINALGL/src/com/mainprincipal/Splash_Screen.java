
package com.mainprincipal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;
import com.mainprincipal.R;

/**
 *
 * @author sabdi
 */
public class Splash_Screen extends Activity {
    
    private ProgressBar spinner;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);
        
        
        
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intento = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(intento);
                Splash_Screen.this.finish();
            }
            
        },4000);
                
    }
    
}
