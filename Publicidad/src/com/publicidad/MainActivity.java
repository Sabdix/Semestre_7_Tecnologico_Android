package com.publicidad;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.publicidad.fragmentos.Publicidad1;
import com.publicidad.fragmentos.Publicidad2;
import com.publicidad.fragmentos.Publicidad3;
import com.publicidad.fragmentos.Publicidad4;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void evtIntercambiar(View view) {
        
        Publicidad1 p1 = new Publicidad1();
        Publicidad2 p2 = new Publicidad2();
        Publicidad3 p3 = new Publicidad3();
        Publicidad4 p4 = new Publicidad4();
        
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
       
        ft.replace(R.id.fragmento1, p4);
        ft.replace(R.id.fragmento2, p3);
        ft.replace(R.id.fragmento3, p2);
        ft.replace(R.id.fragmento4, p1);
       
        ft.commit();
       
       /* 
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(p1);
        ft.remove(p2);
        ft.remove(p3);
        ft.remove(p4);
        ft.add(R.id.fragmento1, p2);
        ft.add(R.id.fragmento2, p3);
        ft.add(R.id.fragmento3, p4);
        ft.add(R.id.fragmento4, p1);
        ft.commit();
        */
        
        ((Button)view).setEnabled(false);
        
    }
}
