package com.example.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class STORE extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store);
		
		ImageView Button = (ImageView)findViewById(R.id.imageView1);
	}
	
	
	
	
	public void Cell(View v)
	{
		Intent Inte = new Intent(this, Smart.class);
		startActivity(Inte);
		
	}
	
	public void Tabs(View v)
	{
		Intent Inte = new Intent(this, Tablets.class);
		startActivity(Inte);
		
	}
	
	public void Shopping(View v)
	{
		Intent Inte = new Intent(this, SHOPPING.class);
		startActivity(Inte);
		
	}
	
}
