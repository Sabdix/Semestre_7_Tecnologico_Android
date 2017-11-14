package com.practica5;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
{
    EditText etFecha;
    ImageView imageZodiaco;
    TextView tvSigno;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zodiaco);
        
        etFecha = (EditText)findViewById(R.id.etFecha);
        imageZodiaco = (ImageView)findViewById(R.id.imageZodiaco);
        tvSigno = (TextView)findViewById(R.id.tvSigno);
        
        etFecha.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            public void afterTextChanged(Editable s) {
                String fecha = s.toString();
                if (fecha.contains("/") && fecha.length() > 4) {
                    if (fecha.split("/")[1] != null) {
                        if (!fecha.split("/")[1].isEmpty() && fecha.split("/")[1].length() > 1) {
                            int mes = Integer.parseInt(fecha.split("/")[1]);
                            switch(mes) {
                                case 1:
                                    imageZodiaco.setImageResource(R.drawable.aries);
                                    tvSigno.setText("Aries");
                                    break;
                                case 2:
                                    imageZodiaco.setImageResource(R.drawable.acuario);
                                    tvSigno.setText("acuario");
                                    break;
                                case 3:
                                    imageZodiaco.setImageResource(R.drawable.cancer);
                                    tvSigno.setText("Cancer");
                                    break;
                                case 4:
                                    imageZodiaco.setImageResource(R.drawable.capricornio);
                                    tvSigno.setText("Capricornio");
                                    break;
                                case 5:
                                    imageZodiaco.setImageResource(R.drawable.escorpion);
                                    tvSigno.setText("Escorpion");
                                    break;
                                case 6:
                                    imageZodiaco.setImageResource(R.drawable.geminis);
                                    tvSigno.setText("Geminis");
                                    break;
                                case 7:
                                    imageZodiaco.setImageResource(R.drawable.leo);
                                    tvSigno.setText("Leo");
                                    break;
                                case 8:
                                    imageZodiaco.setImageResource(R.drawable.libra);
                                    tvSigno.setText("Libra");
                                    break;
                                case 9:
                                    imageZodiaco.setImageResource(R.drawable.piscis);
                                    tvSigno.setText("Piscis");
                                    break;
                                case 10:
                                    imageZodiaco.setImageResource(R.drawable.sagitario);
                                    tvSigno.setText("Sagitario");
                                    break;
                                case 11:
                                    imageZodiaco.setImageResource(R.drawable.tauro);
                                    tvSigno.setText("Tauro");
                                    break;
                                case 12:
                                    imageZodiaco.setImageResource(R.drawable.virgo);
                                    tvSigno.setText("Virgo");
                                    break;
                                default:
                                    tvSigno.setText("Enserio crees en esto di?");
                                    break;
                            }
                        }
                    }
                }
            }
        });
    }
}
