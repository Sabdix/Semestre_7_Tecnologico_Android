package com.example.shopping;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SHOPPING extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping);
		TextView total = (TextView)findViewById(R.id.textView5);
		TextView productos = (TextView)findViewById(R.id.textView6);
		TextView totalT = (TextView)findViewById(R.id.textView9);
		CAR car = new CAR();
		
		
		float Total = car.p1 + car.p2+car.p3+car.p10 + car.p20+car.p30;
		float STotal=0;
		total.setText("$ "+Total);
		if(Total>10000)
		{
			Toast.makeText(this, "Discount -5 %", Toast.LENGTH_SHORT).show();
			STotal=Total - ((float) (Total*.05));
			totalT.setText(""+STotal);
		}
		else{
			totalT.setText(" "+Total);
		}
		
		
		String Productos[] = new String[6];
		for(int i =0;i<=5;i++)
		{
			Productos[i]=" ";
		}
		if(car.b1==false)
		{
			Productos[0]="GALAXY NOTE 4 18,000";
			
		}
		if(car.b2==false)
		{
			Productos[1]="GALAXY EDGE 22,000";
		}
		if(car.b3==false)
		{Productos[2]="GALAXY S7 EDGE  19,000";
		}
		if(car.b10==false)
		{
			Productos[3]="GALAXY TAB 13,000";
		}
		if(car.b20==false)
		{
			Productos[4]="HUAWEI TAB 6,000";
		}
		if(car.b30==false)
		{
			Productos[5]="IPAD PRO 22,000";
		}
		productos.setText(""+Productos[0]+"\n "+Productos[1]+" \n"+Productos[2]+"\n "+Productos[3]+"\n"+Productos[4]+"\n "+Productos[5]);
		
		
	}
}
