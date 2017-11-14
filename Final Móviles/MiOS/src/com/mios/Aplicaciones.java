package com.mios;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adapters.AdaptadorPaginas;
import com.fragments.FragmentoPagina1;
import com.fragments.FragmentoPagina2;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class Aplicaciones extends FragmentActivity 
{
    
    
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.aplicaciones);
        
        ViewPager vp = (ViewPager)findViewById(R.id.vpAplicaciones);
        
        ArrayList<Fragment> paginas = new ArrayList<Fragment>();
        paginas.add(new FragmentoPagina1());
        paginas.add(new FragmentoPagina2());
        
        vp.setAdapter(
            new AdaptadorPaginas(this.getSupportFragmentManager(), paginas)
        );
    }
    
}
