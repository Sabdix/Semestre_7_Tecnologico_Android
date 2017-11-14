package com.appminimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*El activity que llama a este activity debe tener la estructura:

    Intent i = new Intent(this, SecondActivity.class);
    startActivityForResult(i, request_code);
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if ((requestCode == request_code) && (resultCode == RESULT_OK)){
            tvTexto.setText(data.getDataString());
        }
    }
*/

public class AppGuardarYAbrir extends Activity
{
    TextView tvDirOpenSave;
    ListView lvArchivosOpenSave;
    EditText etNombreOpenSave; 
    Button btOpenOrSave;
    String rutaActual;
    final ArrayList<ItemEncontrado> lista = new ArrayList<ItemEncontrado>();
    //Variables obtenidas y regresadas
    boolean modoGuardar = true;
    String nombreArchivo;
    byte[] archivo;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abrir_guardar);
        
        tvDirOpenSave=(TextView)this.findViewById(R.id.tvDirOpenSave);
        lvArchivosOpenSave=(ListView)this.findViewById(R.id.lvArchivosOpenSave);
        etNombreOpenSave=(EditText)this.findViewById(R.id.etNombreOpenSave);
        btOpenOrSave=(Button)this.findViewById(R.id.btOpenOrSave);
        
        //Se obtienen los datos del activity que me invoco
        modoGuardar = this.getIntent().getBooleanExtra("modoGuardar", true);
        if(!modoGuardar){
            btOpenOrSave.setText("Abrir");
        }
        archivo = this.getIntent().getByteArrayExtra("archivo");
        
        //Evento al dar click en un elemento de la lista
        lvArchivosOpenSave.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lista.get(position).isCarpeta())
                {
                    realizar_busqueda(new File(lista.get(position).getRuta()));
                    actualizaAdaptador();
                } else {
                    etNombreOpenSave.setText(lista.get(position).getNombre());
                }
            }
        });
    }
    
    private void realizar_busqueda(File carpeta)
    {
        lista.clear();
        rutaActual = carpeta.getAbsolutePath();
        rutaActual += rutaActual.length()>1?"/":"";
        tvDirOpenSave.setText(rutaActual);
        if(!carpeta.isHidden() && !carpeta.getName().toLowerCase().contains("secure")) {
            try {
                File archivos[] = carpeta.listFiles();
                for(File archivo : archivos) 
                {
                    //AgregarLista
                    agregarLista(archivo);
                }
            } catch(Exception e) {
                Toast.makeText(this, e.getMessage(), 1).show();
            }
        } else {
            Toast.makeText(this, "No se puede acceder a la carpeta", 1).show();
        }
    }
    
    public void eventoInterna(View view)
    {
        realizar_busqueda(Environment.getRootDirectory());
        actualizaAdaptador();
    }
    
    public void eventoExterna(View view)
    {
        realizar_busqueda(Environment.getExternalStorageDirectory());
        actualizaAdaptador();
    }
    
    public void eventoRegresar(View view)
    {
        if(rutaActual!=null && !rutaActual.isEmpty()) 
        {
            try {
                String ruta_anterior = rutaActual.split("/")[rutaActual.split("/").length-1];
                ruta_anterior = rutaActual.substring(0, rutaActual.lastIndexOf(ruta_anterior));
                File f = new File(ruta_anterior);
                realizar_busqueda(f);
                actualizaAdaptador();
            } catch(Exception e) {
                Toast.makeText(this, "No se pudo regresar. "+e.getMessage(), 1).show();
            }
        } else {
            Toast.makeText(this, "No existe una ruta anterior", 1).show();
        }
    }
    
    public void eventoGuardarOAbrirArchivo(View view)
    {
        nombreArchivo = etNombreOpenSave.getText().toString();
        if(nombreArchivo!=null && !nombreArchivo.isEmpty()) {
            nombreArchivo = rutaActual + nombreArchivo;
            if(modoGuardar)
            {
                //Guarda el archivo
                try {
                    File f = new File(nombreArchivo);
                    FileOutputStream fos = new FileOutputStream(f);
                    fos.write(archivo, 0, archivo.length);
                    fos.close();
                    Toast.makeText(this, "Archivo guardado correctamente", 1).show();
                } catch (FileNotFoundException ex) {
                    Toast.makeText(this, "Archivo incorrecto. "+ex.getMessage(), 1).show();
                    //Logger.getLogger(AppGuardarYAbrir.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Toast.makeText(this, "Error al guardar. "+ex.getMessage(), 1).show();
                    //Logger.getLogger(AppGuardarYAbrir.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setResult(RESULT_OK);
                this.finish();
            } else {
                //Abre el archivo
                try {
                    File f = new File(nombreArchivo);
                    FileInputStream fis = new FileInputStream(f);
                    archivo = new byte[(int)f.length()];
                    fis.read(archivo, 0, archivo.length);
                    fis.close();
                } catch (FileNotFoundException ex) {
                    Toast.makeText(this, "Archivo incorrecto para abrir. "+ex.getMessage(), 1).show();
                } catch (IOException ex) {
                    Toast.makeText(this, "Error al abrir. "+ex.getMessage(), 1).show();
                }
                //Deja los datos para regresar al anterior
                Intent datosDeRegreso = this.getIntent();
                datosDeRegreso.putExtra("archivo", archivo);
                this.setResult(RESULT_OK, datosDeRegreso);
                this.finish();
            }
        } else {
            Toast.makeText(this, "No se pudo realizar la operacion", 1).show();
        }
    }
    
    public void eventoCancelar(View view)
    {
        this.finish();
    }

    private void agregarLista(File archivo) 
    {
        ItemEncontrado item = new ItemEncontrado();
        item.setNombre(archivo.getName());
        item.setCarpeta(archivo.isDirectory());
        item.setRuta(archivo.getAbsolutePath());
        
        lista.add(item);
    }
    
    public void actualizaAdaptador()
    {
        lvArchivosOpenSave.setAdapter(new MiAdaptador(this, R.layout.renglon, lista) {
            
            @Override
            public void porCadaRenglon(View view, Object object, int index) {
                ImageView iv= (ImageView) view.findViewById(R.id.ivIconoExp);
                TextView tv=(TextView) view.findViewById(R.id.tvTextoExp);
                tv.setText(((ItemEncontrado)object).getNombre());
                if(((ItemEncontrado)object).isCarpeta()){
                    iv.setImageResource(R.drawable.carpeta);
                }else {
                    iv.setImageResource(R.drawable.archivo);
                }
            }
        });
    }
    
}
