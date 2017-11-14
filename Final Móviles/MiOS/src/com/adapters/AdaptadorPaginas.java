package com.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class AdaptadorPaginas extends FragmentPagerAdapter
{
    ArrayList<Fragment> fragmentos;

    public AdaptadorPaginas(FragmentManager fm, ArrayList<Fragment> fragmentos)
    {
        super(fm);
        this.fragmentos = fragmentos;
    }

    @Override
    public Fragment getItem(int i) 
    {
        return fragmentos.get(i);
    }

    @Override
    public int getCount() 
    {
        return fragmentos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) 
    {
        super.getPageTitle(position);
        
        if(position == 0)
        {
            return "Página 1 de aplicaciones";
        }
        else
        {
            return "Página 2 de aplicaciones";
        }
    }
    
}
