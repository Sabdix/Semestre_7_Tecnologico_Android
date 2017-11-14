package com.example.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Smart extends Activity {

	public static boolean state1=true,state2=true,state3=true;
	Button button1,button2,button3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smart);
	
		
		CAR car = new CAR();
		
		button1 = (Button)findViewById(R.id.button1);
		
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		
		if(CAR.b1==false)
		{
			button1.setVisibility(button1.INVISIBLE);
		}
		if(CAR.b2==false)
		{
			button2.setVisibility(button2.INVISIBLE);
		}
		if(CAR.b3==false)
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
		CAR.n1="GALAXY NOTE 4";
		CAR.p1=18000;
			CAR.b1=false;
			Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
			button1.setVisibility(button1.INVISIBLE);
		
		
	}
	public void Button2(View v)
	{
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		CAR.n2="GALAXY EDGE";
		CAR.p2=22000;
		CAR.b2=false;
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		button2.setVisibility(button2.INVISIBLE);
	}
	public void Button3(View v)
	{
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		CAR.n3="GALAXY S7 EDGE";
		CAR.p3=19000;
		CAR.b3=false;
		Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
		button3.setVisibility(button3.INVISIBLE);
	
	}
	
}
