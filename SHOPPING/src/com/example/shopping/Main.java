package com.example.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
	
	
	EditText user;
	EditText pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button click = (Button)findViewById(R.id.button1);
		 user =(EditText)findViewById(R.id.editText2);
		pass =(EditText)findViewById(R.id.editText1);
	}
	
	
	
	public void Click(View v)
	{
		String User=user.getText().toString();
		String Pass=pass.getText().toString();
		
		if(User.equals("ALO") && Pass.equals("12345") )
		{
			Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
			Intent Inte = new Intent(this, STORE.class);
			startActivity(Inte);
		}
		else
			Toast.makeText(this, "wrong user or pass", Toast.LENGTH_SHORT).show();
		
	}
}
