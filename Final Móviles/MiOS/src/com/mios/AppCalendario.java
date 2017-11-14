package com.mios;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONObject;


/**
 *
 * @author Alexander
 */
public class AppCalendario extends Activity 
{
    TableLayout tableCalendario;
    Spinner spinnerMes;
    EditText etAnios;
    Calendar calendario;
    String [] eventos;
    String id;
    String comando = "insert";

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        setContentView(R.layout.calendario);
        
        tableCalendario = (TableLayout)findViewById(R.id.tableCalendario);
        spinnerMes = (Spinner)this.findViewById(R.id.spinnerMes);
        etAnios = (EditText)this.findViewById(R.id.etAnios);
        
        spinnerMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                generaDiasDelMes();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        calendario = Calendar.getInstance();
        generaDiasDelMes();
    }

    private void generaDiasDelMes() 
    {
        limpiaTabla();
        
        eventos = consultaEventos();
        ArrayList<String> eventosCalendarizados = new ArrayList<String>();
        if(eventos != null)
        {
            for(String evento : eventos)
            {
                eventosCalendarizados.add(evento);
            }
        }
        
        calendario.set(
            Integer.parseInt(etAnios.getText().toString()),
            spinnerMes.getSelectedItemPosition(),
            1
        );
        
        int inicio;
        
        switch(calendario.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.SUNDAY:
                inicio = 0;
                break;
            case Calendar.MONDAY:
                inicio = 1;
                break;
            case Calendar.TUESDAY:
                inicio = 2;
                break;
            case Calendar.WEDNESDAY:
                inicio = 3;
                break;
            case Calendar.THURSDAY:
                inicio = 4;
                break;
            case Calendar.FRIDAY:
                inicio = 5;
                break;
            case Calendar.SATURDAY:
                inicio = 6;
                break;  
            default:
                inicio = 0;
                break;
        }
        
        //Relleno la fila con valores vacios hasta encontrar el dia de inicio
        TableRow fila = new TableRow(this);
        for(int i=0; i < inicio; i++)
        {
            Button bt = new Button(this);
            bt.setText(" ");
            bt.setBackgroundColor(Color.WHITE);
            fila.addView(bt);
        }
        //Coloco los demás dias
        int dia = 1;
        for(int semana=0; semana<6; semana++)
        {
            for(int col = inicio; col < 7; col++)
            {
                if(dia <= calendario.getActualMaximum(Calendar.DAY_OF_MONTH))
                {
                    Button bt = new Button(this);
                    bt.setText(""+dia);
                    if(eventosCalendarizados.contains(""+dia))
                        bt.setBackgroundColor(Color.BLUE);
                    else
                        bt.setBackgroundColor(Color.WHITE);
                    bt.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            generaEvento(v);
                        }
                    });
                    fila.addView(bt);
                    dia++;
                } else {
                    break;
                }
            }
            tableCalendario.addView(fila);
            fila = new TableRow(this);
            inicio = 0;
        }
    }

    private void limpiaTabla() 
    {
        tableCalendario.removeAllViews();
        TableRow fila = new TableRow(this);
        fila.setBackgroundColor(Color.BLACK);
        for (int i = 0; i < 7; i++) 
        {
            TextView tv = new TextView(this);
            tv.setText(
                i==0?"D":(i==1?"L":(i==2?"M":(i==3?"I":(i==4?"J":(i==5?"V":"S") ) ) ) )
            );
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
            fila.addView(tv);
        }
        tableCalendario.addView(fila);
    }
    
    private void generaEvento(View view)
    {
        //Boton al que se le dio click
        Button bt = (Button)view;
        
        final String dia = bt.getText() != null ? bt.getText().toString() : "?";
        final String mes = spinnerMes.getSelectedItem() != null ? spinnerMes.getSelectedItem().toString() : "?";
        String anio = etAnios.getText() != null ? etAnios.getText().toString() : "?";
        
        final Dialog dialogo = new Dialog(this);
        dialogo.setTitle("Tu evento");
        dialogo.setContentView(R.layout.dialogo_evento);
        
        TextView tvFecha = (TextView)dialogo.findViewById(R.id.tvDialogoFechaEvento);
        final EditText etTitulo = (EditText)dialogo.findViewById(R.id.etDialogoTituloEvento);
        final EditText etDesc = (EditText)dialogo.findViewById(R.id.etDialogoDescripcionEvento);
        Button btGuardar = (Button)dialogo.findViewById(R.id.btDialogoGuardarEvento);
        Button btCancelar = (Button)dialogo.findViewById(R.id.btDialogoCancelarEvento);
        
        tvFecha.setText(dia + "/" + mes + "/" + anio);
        String [] existeEvento = null;
        if (consultaEvento(dia, spinnerMes.getSelectedItemPosition() + 1 ) != null) {
            existeEvento = consultaEvento(dia, spinnerMes.getSelectedItemPosition() + 1 );
        }
        
        if(existeEvento != null)
        {
            etTitulo.setText(existeEvento[3].replace("_", " "));
            comando = "update";
            etDesc.setText(existeEvento[4].replace("_", " "));
        }
        
        btGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try 
                {
                    
                    String ip = v.getResources().getString(R.string.ip);
                    //Conexion con el WS
                    String ur = "http://" + ip + ":8080/MiOS_WS/webresources/ws_calendario/guardarEvento/"+comando+"/"+ id + "/" +
                            dia + "/" + (spinnerMes.getSelectedItemId()+1) + "/" +
                                etTitulo.getText().toString().replace(" ", "_") + "/" + etDesc.getText().toString().replace(" ", "_") + "/"
                            + "porahi/quiensabe";
                    URL url = new URL(ur);
                    HttpURLConnection conexion = (HttpURLConnection)
                        url.openConnection();
                    conexion.connect();

                    //Lectura de la respuesta del WS
                    BufferedReader br = new BufferedReader(
                        new InputStreamReader(conexion.getInputStream())
                    );
                    String resultado = br.readLine();
                    br.close();

                    conexion.disconnect();

                    Toast.makeText(v.getContext(), resultado, 1).show();
                    generaDiasDelMes();
                }
                catch (Exception e)
                {
                    System.err.println("Error al consumir el WS Notas guardado.\n" + e.getMessage());
                    Toast.makeText(v.getContext(), "Error al consumir el WS Notas guardado.\n" + e.getMessage(), 1).show();
                }
                
                Toast.makeText(v.getContext(), "Evento guardado!", 1).show();
                dialogo.dismiss();
            }
        });
        
        btCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });
        
        dialogo.show();
    }

    private String[] consultaEventos() 
    {
        int mes = spinnerMes.getSelectedItemPosition() + 1;
        try 
        {
            String wsCalendario = "/eventos/" + mes;
            String ip = this.getResources().getString(R.string.ip);
            
            //Conexion con el WS
            URL url = new URL(
                "http://"+ip+":8080/MiOS_WS/webresources/ws_calendario"
                + wsCalendario
            );
            HttpURLConnection conexion = (HttpURLConnection)
                url.openConnection();
            conexion.connect();
            
            //Lectura de la respuesta del WS
            BufferedReader br = new BufferedReader(
                new InputStreamReader(conexion.getInputStream())
            );
            String resultado = br.readLine();
            br.close();
            
            conexion.disconnect();
            
            JSONObject json = new JSONObject(resultado);
            String [] dias = new String[json.length()];
            for(int i = 0; i < json.length(); i++)
            {
                dias[i] = "" + json.getInt("evento" + (i+1));
            }
            return dias;
        }
        catch (Exception e) 
        {
            Toast.makeText(this, "No hay eventos en este mes", 1).show();
            System.err.println(e.getMessage());
            return null;
        }
    }

    private String[] consultaEvento(String dia, int mes) 
    {
        try 
        {
            String wsCalendario ="/evento/" + mes + "/" + dia;
            String ip = this.getResources().getString(R.string.ip);
            
            //Conexion con el WS
            URL url = new URL(
                "http://"+ip+":8080/MiOS_WS/webresources/ws_calendario"
                + wsCalendario
            );
            HttpURLConnection conexion = (HttpURLConnection)
            url.openConnection();
            conexion.connect();
            
            //Lectura de la respuesta del WS
            BufferedReader br = new BufferedReader(
                new InputStreamReader(conexion.getInputStream())
            );
            String resultado = br.readLine();
            br.close();
            
            conexion.disconnect();
            
            JSONObject json = new JSONObject(resultado);
            String [] eventos = new String[json.length()];
            if (eventos.length > 0) {
                id = "" + json.getInt("id");
                eventos[0] = id;
                eventos[1] = "" + json.getInt("mes");
                eventos[2] = "" + json.getInt("dia");
                eventos[3] = "" + json.getString("nombre_evento");
                if (json.getString("desc_evento") != null) {
                    eventos[4] = "" + json.getString("desc_evento");
                } else {
                    eventos[4] = "";
                }
                eventos[5] = "" + json.getString("hora");
                eventos[6] = "" + json.getString("ubicacion");
                return eventos;
            } else {
                return null;
            }
     
        }
        catch (Exception e) 
        {
            
            return null;
        }
    }
    
}
