/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appminimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.appminimi.R;
import com.appminimimi.manejadores.ManejadorBDContactos;

public class EditarContacto extends Activity {
    ManejadorBDContactos mbdContactos;
    EditText et_nombreContactosEdit, et_apellidoContactosEdit, et_telefonoContactosEdit,
            et_correoContactosEdit,et_telefono_2Edit;
    String idContacto, nombreContacto, apellidoContacto, telContacto, correoContacto, tel2Contacto;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setContentView(R.layout.editarcontacto);
        
        mbdContactos = new ManejadorBDContactos(this, "BDMiniMi", null, 1);
        
        et_nombreContactosEdit = (EditText)this.findViewById(R.id.et_nombreContactosEdit);
        et_apellidoContactosEdit = (EditText)this.findViewById(R.id.et_apellidoContactosEdit);
        et_telefonoContactosEdit = (EditText)this.findViewById(R.id.et_telefonoContactosEdit);
        et_correoContactosEdit = (EditText)this.findViewById(R.id.et_correoContactosEdit);
        et_telefono_2Edit = (EditText)this.findViewById(R.id.et_telefono_2Edit);
        
        Intent intento = getIntent();
        idContacto = intento.getStringExtra("id");
        nombreContacto = intento.getStringExtra("nombre");
        apellidoContacto = intento.getStringExtra("apellido");
        telContacto = intento.getStringExtra("tel");
        correoContacto = intento.getStringExtra("correo");
        tel2Contacto = intento.getStringExtra("tel2");
        
        et_nombreContactosEdit.setText(nombreContacto);
        et_apellidoContactosEdit.setText(apellidoContacto);
        et_telefonoContactosEdit.setText(telContacto);
        et_correoContactosEdit.setText(correoContacto);
        et_telefono_2Edit.setText(tel2Contacto);
        
    }
    
    public void eventoEditarContacto(View v) {
        mbdContactos.modificaContacto(
                idContacto,
                et_nombreContactosEdit.getText().toString(),
                et_apellidoContactosEdit.getText().toString(),
                et_telefonoContactosEdit.getText().toString(),
                et_correoContactosEdit.getText().toString(),
                et_telefono_2Edit.getText().toString());
    }

    public void eventoCancela(View v) {
        this.finish();
    }

}
