package com.appminimi;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class CambiarFondo extends Activity implements OnClickListener {

	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cambiarfondo);
		setupVariables();
		// TODO Auto-generated method stub
	}

	private void setupVariables() {

		iv1 = (ImageView) findViewById(R.id.imageViewbg1);
		iv2 = (ImageView) findViewById(R.id.imageViewbg2);
		iv3 = (ImageView) findViewById(R.id.imageViewbg3);
		iv4 = (ImageView) findViewById(R.id.imageViewbg4);

		iv5 = (ImageView) findViewById(R.id.imageViewbg5);
		iv6 = (ImageView) findViewById(R.id.imageViewbg6);
		iv7 = (ImageView) findViewById(R.id.imageViewbg7);
		iv8 = (ImageView) findViewById(R.id.imageViewbg8);

		iv9 = (ImageView) findViewById(R.id.imageViewbg9);
		iv10 = (ImageView) findViewById(R.id.imageViewbg10);
		iv11 = (ImageView) findViewById(R.id.imageViewbg11);

		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		iv4.setOnClickListener(this);

		iv5.setOnClickListener(this);
		iv6.setOnClickListener(this);
		iv7.setOnClickListener(this);
		iv8.setOnClickListener(this);

		iv9.setOnClickListener(this);
		iv10.setOnClickListener(this);
		iv11.setOnClickListener(this);

	}
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.imageViewbg1:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back1);
			//setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg2:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back2);
			//setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg3:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back3);
			//setTextColors(222,14,30);
			finish();

			break;

		case R.id.imageViewbg4:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back4_small);//
			//setTextColors(0, 0, 0);
			finish();

			break;

		case R.id.imageViewbg5:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back5_small);//
			//setTextColors(12, 45, 52);
			finish();

			break;

		case R.id.imageViewbg6:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back6_small);//
			//setTextColors(0, 0, 0);
			finish();

			break;
		case R.id.imageViewbg7:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back7_small);//
			//setTextColors(145, 0, 0);
			finish();

			break;
		case R.id.imageViewbg8:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back8_small);//
			//setTextColors(0, 0, 150);
			finish();

			break;
		case R.id.imageViewbg9:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back9_small);//
			//setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg10:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back10_small);//
			//setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg11:

			AppMiniMi.layout.setBackgroundResource(R.drawable.back11_small);//
			//setTextColors(255, 255, 255);
			finish();

			break;

		default:
			break;
		}

	}

}
