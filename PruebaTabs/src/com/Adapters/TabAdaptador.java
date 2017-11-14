/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.Fragments.Fragmento1;

/**
 *
 * @author sabdi
 */
public class TabAdaptador extends FragmentPagerAdapter{

    public TabAdaptador(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i < 6) {
            switch(i) {
            case 0:
                return Fragmento1.newInstance("Texto de la pestaña nº 1.");
            case 1:
                return Fragmento1.newInstance("Texto de la pestaña nº 2.");
            case 2:
                return Fragmento1.newInstance("Texto de la pestaña nº 3.");
            case 3:
                return Fragmento1.newInstance("Texto de la pestaña nº 4.");
            case 4:
                return Fragmento1.newInstance("Texto de la pestaña nº 5.");
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
    
}
