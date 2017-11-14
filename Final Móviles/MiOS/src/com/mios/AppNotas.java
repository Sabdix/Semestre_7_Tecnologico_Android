package com.mios;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Alexander
 */
public class AppNotas extends Activity {

    LinearLayout linearNotas;
    int id;
    String comando = "insert";

    /**
     * Called when the activity is first created.
     *
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.notas);

        linearNotas = (LinearLayout) findViewById(R.id.linearNotas);

        muestraNotasWS();
    }

    public void evtOnClickNuevaNota(View view) {
        editarNota(null, null);
        comando = "insert";
    }

    private void muestraNotasWS() {
        try {
            String ip = this.getResources().getString(R.string.ip);

            //Conexion con el WS
            URL url = new URL(
                    "http://" + ip + ":8080/MiOS_WS/webresources/wsnotas"
            );
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.connect();

            //Lectura de la respuesta del WS
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream())
            );
            String resultado = br.readLine();
            br.close();

            conexion.disconnect();

            JSONObject json = new JSONObject(resultado);
            for (int i = 0; i < json.length(); i++) {
                visualizaNotas(json.getJSONArray("nota" + (i + 1)));
            }
        } catch (Exception e) {
            System.err.println("Error al consumir el WS Notas.\n" + e.getMessage());
            Toast.makeText(this, "Error al consumir el WS Notas.\n" + e.getMessage(), 1).show();
        }
    }

    private void visualizaNotas(final JSONArray jsonArray) {
        LinearLayout linear = new LinearLayout(this);
        linear.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 100));
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setBackgroundResource(R.drawable.nota);
        linear.setGravity(Gravity.CENTER);
        linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editarNota(jsonArray.optString(1).replace("_", " "), jsonArray.optString(2).replace("_", " "));
                id = jsonArray.optInt(0);
                comando = "update";
            }
        });

        TextView tv = new TextView(this);
        tv.setText(jsonArray.optString(1).replace("_", " "));
        tv.setLayoutParams(new ViewGroup.LayoutParams(250, 75));
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.DKGRAY);
        linear.addView(tv);

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.eliminar);
        iv.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                eliminaNotaWS(jsonArray.optInt(0));
            }
        });
        linear.addView(iv);

        linearNotas.addView(linear);
    }

    private void editarNota(String titulo, String contenido) {
        final Dialog dialogo = new Dialog(this);
        dialogo.setTitle("Tu nota");
        dialogo.setContentView(R.layout.dialogo_evento);

        TextView tvFecha = (TextView) dialogo.findViewById(R.id.tvDialogoFechaEvento);
        final EditText etTitulo = (EditText) dialogo.findViewById(R.id.etDialogoTituloEvento);
        final EditText etDesc = (EditText) dialogo.findViewById(R.id.etDialogoDescripcionEvento);
        Button btGuardar = (Button) dialogo.findViewById(R.id.btDialogoGuardarEvento);
        Button btCancelar = (Button) dialogo.findViewById(R.id.btDialogoCancelarEvento);

        tvFecha.setText("" + Calendar.getInstance().getTime());
        etTitulo.setText(titulo);
        etDesc.setText(contenido);

        btCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });

        btGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    String ip = v.getResources().getString(R.string.ip);

                    //Conexion con el WS
                    String ur = "http://" + ip + ":8080/MiOS_WS/webresources/wsnotas/guardarNota/"+ comando + "/" + id + "/"
                            + etTitulo.getText().toString().replace(" ", "_") + "/" + etDesc.getText().toString().replace(" ", "_");
                    URL url = new URL(ur);
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    conexion.connect();

                    //Lectura de la respuesta del WS
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(conexion.getInputStream())
                    );
                    String resultado = br.readLine();
                    br.close();

                    conexion.disconnect();

                    Toast.makeText(v.getContext(), resultado, 1).show();

                    //Se limpian las notas del layout
                    if (resultado.contains("correctamente")) {
                        while (linearNotas.getChildCount() > 1) {
                            linearNotas.removeViewAt(1);
                        }
                    }
                    muestraNotasWS();
                } catch (Exception e) {
                    System.err.println("Error al consumir el WS Notas guardado.\n" + e.getMessage());
                    Toast.makeText(v.getContext(), "Error al consumir el WS Notas guardado.\n" + e.getMessage(), 1).show();
                }
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }

    private void eliminaNotaWS(int id) {
        try {
            String ip = this.getResources().getString(R.string.ip);

            //Conexion con el WS
            URL url = new URL(
                    "http://" + ip + ":8080/MiOS_WS/webresources/wsnotas/eliminaNota/" + id
            );
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.connect();

            //Lectura de la respuesta del WS
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream())
            );
            String resultado = br.readLine();
            br.close();

            conexion.disconnect();

            Toast.makeText(this, resultado, 1).show();

            //Se limpian las notas del layout
            if (resultado.contains("correctamente")) {
                while (linearNotas.getChildCount() > 1) {
                    linearNotas.removeViewAt(1);
                }
            }
            muestraNotasWS();
        } catch (Exception e) {
            System.err.println("Error al consumir el WS Notas eliminación.\n" + e.getMessage());
            Toast.makeText(this, "Error al consumir el WS Notas eliminación.\n" + e.getMessage(), 1).show();
        }
    }

}
