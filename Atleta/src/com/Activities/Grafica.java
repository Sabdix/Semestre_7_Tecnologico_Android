
package com.Activities;

import android.app.Activity;
import android.os.Bundle;
import com.Clases.Estadistica;
import com.Clases.GraficaLinear;
import com.Clases.Punto;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.achartengine.GraphicalView;

/**
 *
 * @author sabdi
 */
public class Grafica extends Activity {
    
    private static GraphicalView view;
    private GraficaLinear line;
    private static Thread thread;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.grafica);
        
        thread = new Thread() {
            public void run() {
                for (int i=0; i < 5; i++) {
                
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    Punto p = new Punto(i+1,Estadistica.sumaColumnas(i));//Nuevo dato
                    line.agregarPunto(p); //Agregarlo a nuestro grafico
                    view.repaint();
                }
            }
        };
        thread.start();
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        line = new GraficaLinear(this.getIntent().getStringExtra("nombre"));
        view = line.getView(this);
        setContentView(view);
    }
    
}
