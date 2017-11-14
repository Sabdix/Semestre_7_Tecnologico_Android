
package com.appminimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.appminimimi.manejadores.ManejadorBDContactos;

/**
 *
 * @author JoséMendoza
 */
public class AgregarContactos extends Activity 
{
    
    ManejadorBDContactos mdbContactos;
    EditText et_nombreContactos, et_apellidoContactos, et_telefonoContactos, et_correoContactos, et_telefono_2;
 
    @Override
    public void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        this.setContentView(R.layout.agregarcontacto);
        
        mdbContactos = new ManejadorBDContactos(this, "BDMiniMi", null, 1);
        
        et_nombreContactos = (EditText)this.findViewById(R.id.et_nombreContactos);
        et_apellidoContactos = (EditText)this.findViewById(R.id.et_apellidoContactos);
        et_telefonoContactos = (EditText)this.findViewById(R.id.et_telefonoContactos);
        et_correoContactos = (EditText)this.findViewById(R.id.et_correoContactos);
        et_telefono_2 = (EditText)this.findViewById(R.id.et_telefono_2);
     }
    
    public void eventoCancela(View v)
    {
        this.finish();
        
    }
    
    public void eventoAgregaContacto(View v)
    {
        try
        {
            mdbContactos.agregarContacto(
                    et_nombreContactos.getText().toString(), 
                    et_apellidoContactos.getText().toString(), 
                    et_telefonoContactos.getText().toString(), 
                    et_correoContactos.getText().toString(), 
                    et_telefono_2.getText().toString());
            
            Toast.makeText(this, "Se agrego un contacto.", 1).show();
            Intent intento = new Intent(this, AppContactos.class);
            startActivity(intento);
            
        }catch(Exception e)
        {
            Toast.makeText(this, "Error al guardar: " + e.getMessage(), 1).show();
            
        }  
    }
    
}
