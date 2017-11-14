package com.Publi;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        FragmentTransaction ft1 = this.getFragmentManager().beginTransaction();
        Publicidad1 obj1 = new Publicidad1();
        ft1.add(R.id.fragmento1, obj1);
        ft1.commit();
        
        FragmentTransaction ft2 = this.getFragmentManager().beginTransaction();
        Publicidad2 obj2 = new Publicidad2();
        ft2.add(R.id.fragmento2, obj2);
        ft2.commit();
        
        FragmentTransaction ft3 = this.getFragmentManager().beginTransaction();
        Publicidad3 obj3 = new Publicidad3();
        ft3.add(R.id.fragmento3, obj3);
        ft3.commit();
        
        FragmentTransaction ft4 = this.getFragmentManager().beginTransaction();
        Publicidad4 obj4 = new Publicidad4();
        ft4.add(R.id.fragmento4, obj4);
        ft4.commit();
        
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
     }
}
