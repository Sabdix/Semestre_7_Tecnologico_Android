
package com.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.Adapters.AdaptadorPaginas;
import com.Fragments.FragmentoPagina1;
import com.Fragments.FragmentoPagina2;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Aplicaciones extends FragmentActivity {


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.aplicaciones);
        
        ArrayList<Fragment> paginas = new ArrayList<Fragment>();
        paginas.add(new FragmentoPagina1());
        paginas.add(new FragmentoPagina2());
        
        ViewPager vp = (ViewPager)findViewById(R.id.vpAplicaciones);
        vp.setAdapter(new AdaptadorPaginas(this.getSupportFragmentManager(), paginas));
        
    }
    
}
