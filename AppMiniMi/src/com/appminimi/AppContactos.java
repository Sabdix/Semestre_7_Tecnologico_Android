/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appminimi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.appminimi.R;
import com.appminimimi.manejadores.ManejadorBDContactos;
import java.util.ArrayList;

public class AppContactos extends Activity {

    ManejadorBDContactos mbdContactos;
    ListView lvListaContactos;
    ArrayList<String> contactos;
    EditText etBuscarContacto;
    String idContacto, nombreContacto, apellidoContacto, telContacto, correoContacto, tel2Contacto;
    Context con;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setContentView(R.layout.appcontactos);
        
        con = this;
        
        etBuscarContacto = (EditText)this.findViewById(R.id.etBuscarContacto);
        
        mbdContactos = new ManejadorBDContactos(this, "BDMiniMi", null, 1);
        contactos = mbdContactos.buscarTodos();
        
        
        Toast.makeText(this,"Contactos encontrados: "+mbdContactos.buscarTodos().size(), 1).show();
        
        lvListaContactos = (ListView)this.findViewById(R.id.lvListaContactos);
        
        registerForContextMenu(lvListaContactos);
        lvListaContactos.setLongClickable(false);
        
        actualizarAdaptador();
        
        lvListaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                idContacto = contactos.get(position).split("%")[0];
                nombreContacto = contactos.get(position).split("%")[1];
                apellidoContacto = contactos.get(position).split("%")[2];
                telContacto = contactos.get(position).split("%")[3];
                correoContacto = contactos.get(position).split("%")[4];
                tel2Contacto = contactos.get(position).split("%")[5];
                lvListaContactos.showContextMenu();
            }
        });
        
        etBuscarContacto.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length() > 0){
                    String x = "";
                    x = s.toString().trim();
                    eventoBuscaPorPatron(x);
                }
                
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.contextmenucontactos, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miEditar:
                Intent intento = new Intent(this, EditarContacto.class);
                intento.putExtra("id", idContacto);
                intento.putExtra("nombre", nombreContacto);
                intento.putExtra("apellido", apellidoContacto);
                intento.putExtra("tel", telContacto);
                intento.putExtra("correo", correoContacto);
                intento.putExtra("tel2", tel2Contacto);
                this.startActivity(intento);
                break;
            case R.id.miEliminar:
                mbdContactos.borrarContacto(idContacto);
                contactos = mbdContactos.buscarTodos();
                actualizarAdaptador();
                break;
            case R.id.miLlamar:
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telContacto.trim()));
                this.startActivity(callIntent);
                break;
        }
        return super.onContextItemSelected(item);
    }
    
    public void eventoBuscaPorPatron(String x){
        contactos = mbdContactos.buscarPorPatron(x);
        actualizarAdaptador();       
    }
    
    public void actualizarAdaptador() {
        lvListaContactos.setAdapter(new MiAdaptador(this, R.layout.renglon, contactos) {
            @Override
            public void porCadaRenglon(View view, Object object, int index) {
                TextView tv = (TextView) view.findViewById(R.id.tvTextoExp);
                ImageView iv = (ImageView) view.findViewById(R.id.ivIconoExp);

                tv.setText(object.toString().split("%")[1]);
                tv.append("\n" + object.toString().split("%")[2]);

                iv.setImageResource(R.drawable.ic_launcher);
            }
        });
    }
    
    public void eventoAgregaContacto(View v){
        Intent intento = new Intent(this, AgregarContacto.class);
        this.startActivity(intento);
    }
    
}
