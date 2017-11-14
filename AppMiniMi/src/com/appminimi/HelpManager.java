

package com.appminimi;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class HelpManager extends Activity implements OnClickListener {
	private static final String[] EMAIL = {"jamheredia.jm@gmail.com"};
	private static final String WEB = "http://www.webs.com";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.help_layout);
		
		String text = "<:\n\n";
		
		TextView label = (TextView)findViewById(R.id.help_top_label);
		label.setText(text);
		
		Button email = (Button)findViewById(R.id.help_email_bt);
		Button web = (Button)findViewById(R.id.help_website_bt);
		email.setOnClickListener(this);
		web.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		Intent i = new Intent();
		
		switch(id) {
			case R.id.help_email_bt:
				i.setAction(android.content.Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL, EMAIL);
				try {
					startActivity(Intent.createChooser(i, "Usando correo..."));
					
				} catch(ActivityNotFoundException e) {
					Toast.makeText(this, "Fallo correo", Toast.LENGTH_SHORT).show();
				}
			break;
			
			case R.id.help_website_bt:
				i.setAction(android.content.Intent.ACTION_VIEW);
				i.setData(Uri.parse(WEB));
				try {
					startActivity(i);
					
				} catch(ActivityNotFoundException e) {
					Toast.makeText(this, "Fallo en abrir", Toast.LENGTH_SHORT).show();
				}
				break;
		}
	}

}
