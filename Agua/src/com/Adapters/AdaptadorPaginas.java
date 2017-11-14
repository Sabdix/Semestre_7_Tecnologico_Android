/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class AdaptadorPaginas extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentos;

    public AdaptadorPaginas(FragmentManager fm, ArrayList<Fragment> fragmentos) {
        super(fm);
        this.fragmentos = fragmentos;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentos.get(i);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        if (position == 0) {
            return "Adeudos";
        } else {
            return "Pagos";
        }
    }
}
