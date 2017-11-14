package com.adapters;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mios.R;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class AdaptadorListaCanciones extends BaseAdapter
{
    ArrayList<Reproductor> canciones;
    Context contexto;
    int resGUI;

    public AdaptadorListaCanciones(Context contexto, int resGUI, ArrayList<Reproductor> canciones) 
    {
        this.canciones = canciones;
        this.contexto = contexto;
        this.resGUI = resGUI;
    }

    public int getCount()
    {
        return canciones.size();
    }

    public Object getItem(int position) 
    {
        return canciones.get(position);
    }

    public long getItemId(int position)
    {
        return -1;
    }

    public View getView(int position, View view, ViewGroup parent) 
    {
        if(view == null)
        {
            LayoutInflater inflador = (LayoutInflater)contexto.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            view = inflador.inflate(resGUI, null);
        }
        configuraRenglon(view, position);
        return view;
    }
    
    private void configuraRenglon(View view, int position) 
    {
        Reproductor cancion = canciones.get(position);
        try
        {
            //Verifica si existe la imagen del album
            if( !cancion.getAlbum().isEmpty() )
            {
                ImageView ivImagenAlbum = (ImageView)view.findViewById(R.id.ivRenglonImagenAlbum);
                
                //Se busca la imagen remota
                String ip = contexto.getResources().getString(R.string.ip);
                URL url = new URL("http://" + ip + ":8080/" + cancion.getAlbum());
                Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());

                //Se coloca la imagen remota
                ivImagenAlbum.setImageBitmap(bitmap);
                
                //Se agrega el nombre del album
                TextView tvAlbum = (TextView)view.findViewById(R.id.tvRenglonAlbum);
                tvAlbum.setText(cancion.getAlbum().substring(0, cancion.getAlbum().lastIndexOf(".")));
            }
            //Se agrega el nombre de la cancion
            TextView tvCancion = (TextView)view.findViewById(R.id.tvRenglonMusica);
            tvCancion.setText(cancion.getCancion() + "\n" + cancion.getInterprete());
        }
        catch (Exception e)
        {
            System.err.println("Error al enlistar musica.\n" + e.getMessage());
        }
    }
    
}
