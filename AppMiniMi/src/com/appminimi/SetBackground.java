package com.appminimi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SetBackground extends Activity implements OnClickListener {

	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_background);
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

	void setTextColors(int red, int green, int blue) {
		// Text colors
		Blackjack.tvBet.setTextColor(Color.rgb(red, green, blue));
		Blackjack.tvBet.setTextColor(Color.rgb(red, green, blue));
		Blackjack.tvDealerScore.setTextColor(Color
				.rgb(red, green, blue));
		Blackjack.tvHighestScore.setTextColor(Color.rgb(red, green,
				blue));
		Blackjack.tvMoney.setTextColor(Color.rgb(red, green, blue));
		Blackjack.tvYourScore.setTextColor(Color.rgb(red, green, blue));

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.imageViewbg1:

			Blackjack.layout.setBackgroundResource(R.drawable.back1);
			setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg2:

			Blackjack.layout.setBackgroundResource(R.drawable.back2);
			setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg3:

			Blackjack.layout.setBackgroundResource(R.drawable.back3);
			setTextColors(222,14,30);
			finish();

			break;

		case R.id.imageViewbg4:

			Blackjack.layout.setBackgroundResource(R.drawable.back4_small);
			setTextColors(0, 0, 0);
			finish();

			break;

		case R.id.imageViewbg5:

			Blackjack.layout.setBackgroundResource(R.drawable.back5_small);
			setTextColors(12, 45, 52);
			finish();

			break;

		case R.id.imageViewbg6:

			Blackjack.layout.setBackgroundResource(R.drawable.back6_small);
			setTextColors(0, 0, 0);
			finish();

			break;
		case R.id.imageViewbg7:

			Blackjack.layout.setBackgroundResource(R.drawable.back7_small);
			setTextColors(145, 0, 0);
			finish();

			break;
		case R.id.imageViewbg8:

			Blackjack.layout.setBackgroundResource(R.drawable.back8_small);
			setTextColors(0, 0, 150);
			finish();

			break;
		case R.id.imageViewbg9:

			Blackjack.layout.setBackgroundResource(R.drawable.back9_small);
			setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg10:

			Blackjack.layout.setBackgroundResource(R.drawable.back10_small);
			setTextColors(255, 255, 255);
			finish();

			break;
		case R.id.imageViewbg11:

			Blackjack.layout.setBackgroundResource(R.drawable.back11_small);
			setTextColors(255, 255, 255);
			finish();

			break;

		default:
			break;
		}

	}

}
