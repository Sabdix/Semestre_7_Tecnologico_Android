package com.example.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tablets extends Activity {

	
	Button button1,button2,button3;
	public static boolean state1=true,state2=true,state3=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tablets);
		
		CAR car = new CAR();
		
		button1 = (Button)findViewById(R.id.button1);
		
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		
		if(CAR.b10==false)
		{
			button1.setVisibility(button1.INVISIBLE);
		}
		if(CAR.b20==false)
		{
			button2.setVisibility(button2.INVISIBLE);
		}
		if(CAR.b30==false)
		{
			button3.setVisibility(button3.INVISIBLE);
		}
	}
	
	
	public void Shopping(View v)
	{
		Intent Inte = new Intent(this, SHOPPING.class);
		startActivity(Inte);
		
	}
	
	public void Button1(View v)
	{
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		CAR.n10="GALAXY TAB";
		CAR.p10=13000;
			CAR.b10=false;
			Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
			button1.setVisibility(button1.INVISIBLE);
		
		
	}
	public void Button2(View v)
	{
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		CAR.n20="HUAWEI TAB";
		CAR.p20=6000;
		CAR.b20=false;
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		button2.setVisibility(button2.INVISIBLE);
	}
	public void Button3(View v)
	{
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		CAR.n30="IPAD PRO";
		CAR.p30=22000;
		CAR.b30=false;
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		button3.setVisibility(button3.INVISIBLE);
	
	}
	
}
