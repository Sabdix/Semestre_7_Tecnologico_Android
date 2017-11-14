/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class InicioApps extends FragmentActivity 
{
    ViewPager viewpagerMain;
    ArrayList<Fragment> listaFragmentos;

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        this.setContentView(R.layout.inicioapps);
        
        viewpagerMain = (ViewPager)this.findViewById(R.id.viewpagerMain);
        
        listaFragmentos = new ArrayList<Fragment>();
        listaFragmentos.add(new PaginaApps1());
        listaFragmentos.add(new PaginaApps2());
        listaFragmentos.add(new PaginaApps3());
        
        viewpagerMain.setAdapter(new MiAdaptadorViewPager(
                this.getSupportFragmentManager(), listaFragmentos)
        );

    }
    
}
