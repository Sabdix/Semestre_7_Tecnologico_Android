package com.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.Fragmentos.Fragmento;
import com.Model.ModeloBD;
import com.Model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends Activity
{
    ModeloBD mibd = new ModeloBD(this,"MiPrimerBD", null, 1);
    EditText etBuscar;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etBuscar = (EditText)findViewById(R.id.etBuscar);
        Button btAgregar = (Button)findViewById(R.id.btAgregar);
        
        btAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(v.getContext());
                dialogo.setTitle("Nuevo Usuario");
                
                final EditText et = new EditText(v.getContext());
                et.setHint("Nick");
                dialogo.setView(et);
                
                dialogo.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        guardarNuevoUsuario(et.getText().toString());
                        dialog.dismiss();
                    }
                });
                
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                
                dialogo.show();
            }
        });
        
        etBuscar.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count){}

            public void afterTextChanged(Editable s) {
                String texto = s.toString();
                if(texto.length() > 0) {
                    try {
                        buscarUsuarios(texto);
                    } catch (Exception ex) {
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Fragmento.setElements(mibd);
                    } catch (Exception ex) {
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        try {
            Toast.makeText(this, "Se encontraron "+ mibd.listarUsuarios().size()+" registros", 1).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Error al listar usuarios\n"+ex.getMessage(), 1).show();
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Fragmento.setElements(mibd);
        } catch (Exception ex) {
           Toast.makeText(this, "Error al listar usuarios\n"+ex.getMessage(), 1).show();
        }

    }
    
    private void guardarNuevoUsuario(String nick) {
        
         try {
            Usuario usuario = new Usuario();
            usuario.setNick(nick);
            mibd.guardarusuario(usuario);
            Toast.makeText(this, "Registro Guardado ", 1).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error "+e.getMessage(), 1).show();
        }
         
        try {
            Fragmento.setElements(mibd);
        } catch (Exception ex) {
            Toast.makeText(this, "Error al listar usuarios\n"+ex.getMessage(), 1).show();
        }
         
    }
    
    private void buscarUsuarios(String texto) throws Exception {
        Fragmento.otroSetElements(mibd, texto);
    }
}
