package com.appminimi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.appminimi.R;
import com.appminimimi.manejadores.ManejadorBDEventos;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class AppCalendario extends Activity 
{
    Context con;
    ArrayList<String> eventos;
    ListView lvListaEventos;
    TableLayout tlCalendario;
    Calendar calendario;
    Spinner spiMes, spiAnio;
    String [] meses = {
        "", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
        "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
    };
    String [] anios = new String[11];
    ManejadorBDEventos mbdEventos;

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        this.setContentView(R.layout.appcalendario);
        
        tlCalendario = (TableLayout)this.findViewById(R.id.tlCalendario);
        spiMes = (Spinner)this.findViewById(R.id.spiMes);
        spiAnio = (Spinner)this.findViewById(R.id.spiAnio);
        
        lvListaEventos = (ListView)this.findViewById(R.id.lvListaEventos);
        con = this;
        
        mbdEventos = new ManejadorBDEventos(this, "BDCalendarioEventos", null, 1);
        eventos = mbdEventos.buscarTodosEventos();
        actualizarAdaptador();
        
        //Preparacion de los spinners
        for(int i = 0; i < 11; i++)    anios[i] = "" + (2015 + i);
        
        ArrayAdapter<String> adaptadorMeses = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, meses
        );
        adaptadorMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiMes.setAdapter(adaptadorMeses);
        spiMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0)
                    seleccionarMes(position);
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
        
        ArrayAdapter<String> adaptadorAnios = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, anios
        );
        adaptadorAnios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiAnio.setAdapter(adaptadorAnios);
        
        //Calendario con el mes actual
        calendario = Calendar.getInstance();
        calendario.set(Calendar.DATE, 1);
        llenaMes(buscarDiaInicioMes());
    }
    
    private void seleccionarMes(int position) 
    {
        calendario.clear(Calendar.MONTH);
        calendario.set(Calendar.MONTH, position - 1);
        calendario.clear(Calendar.YEAR);
        calendario.set(Calendar.YEAR, spiAnio.getSelectedItemPosition() + 2015);
        tlCalendario.removeViews(1, tlCalendario.getChildCount() - 1);
        calendario.set(Calendar.DATE, 1);
        llenaMes(buscarDiaInicioMes());
    }

    private int buscarDiaInicioMes() 
    {
        int inicio = 0;
        //Busca el dia de la semana del primer dia del mes
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
        return inicio;
    }
    
    private void llenaMes(int inicioMes) 
    {
        //Renglon por semana
        TableRow trSemana = asignarValoresRow();
        Button btDia;
        //Llena calendario con los dias antes del primero
        for (int i = 0; i < inicioMes; i++) 
        {
            btDia = asignarValoresButton("0");
            trSemana.addView(btDia);
        }
        
        //Llenado de la tabla para generar el calendario
        int dia = 1;
        int diaFinal = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
        while(dia <= diaFinal) 
        {
            for(int i = inicioMes; i < 7; i++) 
            {
                if(dia <= diaFinal)     btDia = asignarValoresButton("" + dia);
                else                    btDia = asignarValoresButton("0");
                trSemana.addView(btDia);
                dia++;
            }
            inicioMes = 0;
            tlCalendario.addView(trSemana);
            trSemana = asignarValoresRow();
        }
    }
    
    private TableRow asignarValoresRow()
    {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(
            new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT, 20
            )
        );
        tr.setGravity(Gravity.CENTER);
        return tr;
    }
    
    private Button asignarValoresButton(String texto)
    {
        final Button bt = new Button(this);
        bt.setBackgroundColor(Color.RED);
        if(texto.equals("0"))
        {
            bt.setTextColor(Color.RED);
            bt.setText(texto);
        } 
        else 
        {
            bt.setText(texto);
            bt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    agregarNuevoEvento(v, bt.getText().toString());
                }
            });
        }
        return bt;
    }
    
    public void agregarNuevoEvento(View v, final String dia){
        final Button bt = (Button)v;
        final Dialog dialogo = new Dialog(this);
        dialogo.setTitle("Eventos del mes");
        dialogo.setContentView(R.layout.dialogo_eventos);
        
        final EditText etNombreEventoCalendario = (EditText)dialogo.findViewById(R.id.etNombreEventoCalendario);
        final EditText etHoraEventoCalendario = (EditText)dialogo.findViewById(R.id.etHoraEventoCalendario);
        final EditText etLugarEventoCalendario = (EditText)dialogo.findViewById(R.id.etLugarEventoCalendario);
        Button btGuardarEventoCalendario = (Button)dialogo.findViewById(R.id.btGuardarEventoCalendario);
        Button btCancelarEventoCalendario = (Button)dialogo.findViewById(R.id.btCancelarEventoCalendario);
        
        btGuardarEventoCalendario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    String fecha = "";
                    fecha = fecha.concat(dia + 
                            "-" + spiMes.getSelectedItem().toString() + 
                            "-" + spiAnio.getSelectedItem().toString());
                    bt.setBackgroundColor(Color.parseColor("#FBD41E"));
                    mbdEventos.agregarEvento(
                            fecha, 
                            etNombreEventoCalendario.getText().toString(), 
                            etHoraEventoCalendario.getText().toString(), 
                            etLugarEventoCalendario.getText().toString());
                    Toast.makeText(view.getContext(),"Evento agregado exitosamente", 0).show();
                    dialogo.dismiss();
                }catch(Exception e){
                    Toast.makeText(view.getContext(), "Error: " + e.getMessage(), 1).show();
                }
                
            }
        });
        
        btCancelarEventoCalendario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialogo.dismiss();
            }
        });
        
        dialogo.show();
    }
    
    public void eventoListaEventos(View v){
        eventos = mbdEventos.buscarTodosEventos();
        actualizarAdaptador();
    }
    
        public void actualizarAdaptador() {
        lvListaEventos.setAdapter(new MiAdaptador(this, R.layout.renglon, eventos) {
            @Override
            public void porCadaRenglon(View view, Object object, int index) {
                TextView tv = (TextView) view.findViewById(R.id.tvTextoExp);
                ImageView iv = (ImageView) view.findViewById(R.id.ivIconoExp);

                tv.setText(object.toString().split("%")[1]);
                tv.append("\n" + object.toString().split("%")[2]);
                tv.append("\n" + object.toString().split("%")[3]);
                tv.append("\n" + object.toString().split("%")[4]);

                iv.setImageResource(R.drawable.listaeventos);
            }

        });
    }
    
}
