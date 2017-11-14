package com.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.Adapters.TabAdaptador;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
    private ViewPager vPager;
    private TabAdaptador tAdapter;
    private ActionBar aBar;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        vPager = (ViewPager)findViewById(R.id.pager);
        tAdapter = new TabAdaptador(getSupportFragmentManager());
        aBar = getActionBar();
         
        vPager.setAdapter(tAdapter);
        aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        // Habilitar swipe entre tabs.
        vPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                aBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Establecer el fragment que se debe mostrar.
        vPager.setCurrentItem(tab.getPosition());
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
