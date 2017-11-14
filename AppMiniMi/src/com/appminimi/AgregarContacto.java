/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appminimi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.appminimi.R;
import com.appminimimi.manejadores.ManejadorBDContactos;

public class AgregarContacto extends Activity{
 
    ManejadorBDContactos mbdContactos;
    EditText et_nombreContactos, et_apellidoContactos, et_telefonoContactos,et_correoContactos,et_telefono_2;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setContentView(R.layout.agregarcontacto);
        
        mbdContactos = new ManejadorBDContactos(this, "BDMiniMi", null, 1);
        
        et_nombreContactos = (EditText)this.findViewById(R.id.et_nombreContactos);
        et_apellidoContactos = (EditText)this.findViewById(R.id.et_apellidoContactos);
        et_telefonoContactos = (EditText)this.findViewById(R.id.et_telefonoContactos);
        et_correoContactos = (EditText)this.findViewById(R.id.et_correoContactos);
        et_telefono_2 = (EditText)this.findViewById(R.id.et_telefono_2);
        
    }
    
    public void eventoCancela(View v){
        this.finish();
    }
    
    public void eventoAgregaContacto(View v){
        mbdContactos.agregarContacto(et_nombreContactos.getText().toString(),et_apellidoContactos.getText().toString(),
                et_telefonoContactos.getText().toString(), et_correoContactos.getText().toString(),
                et_telefono_2.getText().toString());
    }
    
}
