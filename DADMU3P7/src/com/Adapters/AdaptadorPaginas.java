
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
            return "Pagina 1 de Aplicaciones";
        } else {
            return "Página 2 de Aplicaciones";
        }
    }
    
    
    
}
