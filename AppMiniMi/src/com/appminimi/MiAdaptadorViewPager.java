/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MiAdaptadorViewPager extends FragmentPagerAdapter 
{
    ArrayList<Fragment> listaFragmentos;

    public MiAdaptadorViewPager(FragmentManager fm, ArrayList<Fragment> listaFragmentos) 
    {
        super(fm);
        this.listaFragmentos = listaFragmentos;
    }

    @Override
    public Fragment getItem(int i) 
    {
        return listaFragmentos.get(i);
    }

    @Override
    public int getCount() 
    {
        return listaFragmentos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) 
    {
        String titulo = "";
        switch(position)
        {
            case 0:
                titulo = "Herramientas";
                break;
            case 1:
                titulo = "Multimedia";
                break;
            case 2:
                titulo = "Juegos";
                break;
        }
        return titulo;
        //return listaFragmentos.get(position).getClass().getSimpleName();
    }
       
}
