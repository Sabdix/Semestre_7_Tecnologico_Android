package com.Activities;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Window;
import com.Fragments.Fragmento1;
import com.Fragments.Fragmento2;
import com.Fragments.Fragmento3;




public class MainActivity extends FragmentActivity
{
    private FragmentTabHost tabHost;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Videos"), Fragmento1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Tutoriales"), Fragmento2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Opciones"), Fragmento3.class, null);
        
        
    }
}
