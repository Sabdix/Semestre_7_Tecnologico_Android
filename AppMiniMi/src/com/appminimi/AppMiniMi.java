package com.appminimi;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AppMiniMi extends Activity
{
    /** Called when the activity is first created. */
    public static LinearLayout layout;
    String valor;
    ImageButton bt1, bt2, bt3, bt4,bt5;
     boolean estado  = true ;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        layout = (LinearLayout) findViewById(R.id.parentLayout);
        bt1 = (ImageButton)this.findViewById(R.id.bt1);
        bt2 = (ImageButton)this.findViewById(R.id.bt2);
        bt3 = (ImageButton)this.findViewById(R.id.bt3);
        bt4 = (ImageButton)this.findViewById(R.id.bt4);
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        
        bt1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intento;
                intento = new Intent(v.getContext(), AppContactos.class);
                v.getContext().startActivity(intento);
            }
        });
    }
    
    StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getBlockCount();
    long megAvailable = bytesAvailable / 1048576;


    StatFs statin = new StatFs(Environment.getDataDirectory().getPath());
    long bytesAvailablein = (long)stat.getBlockSize() * (long)stat.getBlockCount();
    long megAvailablein = bytesAvailablein / 1048576;

    
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context ctxt, Intent intent) {
              int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
              valor = "Porcentaje de Batería: "+ level + "%";
            }

          };
    
    public void eventoInicio(View view)
    {
        Intent intento = new Intent(this, InicioApps.class);
        this.startActivity(intento);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);

                    MenuInflater menuSetBg = getMenuInflater();
                    menuSetBg.inflate(R.menu.menu_fondo, menu);

                    return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                    // TODO Auto-generated method stub
                    super.onOptionsItemSelected(item);

                    switch (item.getItemId()) {
                    case R.id.mISelectBackground:

                            Intent intent = new Intent(this,
                                            CambiarFondo.class);
                            startActivity(intent);

                            break;

                    case R.id.mIRam:

                        MemoryInfo mi = new MemoryInfo();
                        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        activityManager.getMemoryInfo(mi);
                        long availableMegs = mi.availMem / 1048576L;
                        
                        Toast.makeText(this, "Memoria RAM USADA: " + availableMegs + "MB", 1).show();

                            break;
                    case R.id.mIAlmacena:
                            Toast.makeText(this, "Memoria Interna Disponible: " + megAvailable + "MB \nMemoria Externa Disponible: " + megAvailablein +"MB" , 1).show();
                            

                            break;
                    case R.id.mIBateria:
                         Toast.makeText(this, valor , 1).show();
                            

                            break;
                    case R.id.mITema:
                       
                        if(estado){
                            bt1.setImageResource(R.drawable.contactos2);
                            bt2.setImageResource(R.drawable.mensajes2);
                            bt3.setImageResource(R.drawable.llamadas2);
                            bt4.setImageResource(R.drawable.home2);
                            estado = false;
                        }else{
                            bt1.setImageResource(R.drawable.contactos1);
                            bt2.setImageResource(R.drawable.mensajes1);
                            bt3.setImageResource(R.drawable.llamadas1);
                            bt4.setImageResource(R.drawable.home1);
                            estado = true;
                        }
                            
                            break;
                    }

                    return true;

            }
            
            

    }
