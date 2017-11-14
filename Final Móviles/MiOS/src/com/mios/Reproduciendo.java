package com.mios;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class Reproduciendo extends Activity implements OnBufferingUpdateListener, OnCompletionListener
{
    ImageView wvReproduciendo;
    MediaPlayer mp;
    ProgressBar bProgreso;
    int currentPosition= 0;
    int id, contador;
    boolean pausado = false;
    

    /**
     * Called when the activity is first created.
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) 
    {
        super.onCreate(icicle);
        setContentView(R.layout.reproduciendo_wv);
        
        wvReproduciendo = (ImageView)this.findViewById(R.id.wvReproduciendo);
        bProgreso = (ProgressBar)this.findViewById(R.id.barraProgreso);
        
        String urlMusica = this.getIntent().getStringExtra("cancion");
        String ip = this.getResources().getString(R.string.ip);
        urlMusica = "http://" + ip + ":8080/" + urlMusica;
        
        id = this.getIntent().getIntExtra("id", -1);
        contador = id;

        Bitmap bitmap;
        try {
            ImageView ivImagenAlbum = (ImageView)this.findViewById(R.id.wvReproduciendo);
                
            //Se busca la imagen remota
            URL url1 = new URL("http://" + ip + ":8080/" + AppReproductor.listaCanciones.get(id).getAlbum());
            bitmap = BitmapFactory.decodeStream(url1.openStream());
            //Se coloca la imagen remota
            ivImagenAlbum.setImageBitmap(bitmap);
        } catch (IOException ex) {
            Logger.getLogger(Reproduciendo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Uri url = Uri.parse(urlMusica);
        mp = MediaPlayer.create(this, url);
        mp.setOnBufferingUpdateListener(this);
        mp.setOnCompletionListener(this);
        mp.start();
    }

    @Override
    protected void onDestroy() 
    {
        super.onDestroy();
        if (mp != null) 
        {
            mp.release();
            mp = null;
        }
    }
    
    public void evtClickPausePlay(View view)
    {
        ImageView iv = (ImageView)view;
        if(!pausado)
        {
            mp.pause();
            pausado = true;
            iv.setImageResource(R.drawable.play);
        }
        else
        {
            mp.start();
            pausado = false;
            iv.setImageResource(R.drawable.pause);
        }
    }
    
    public void evtClickPrevious(View view) {
        cancionAnterior();
    }
    
    public void evtClickNext(View view) {
        siguienteCancion();
    }

    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        bProgreso.setProgress(mp.getCurrentPosition()*100/mp.getDuration());
    }

    public void onCompletion(MediaPlayer mp) {
        siguienteCancion();
    }
    
    private void siguienteCancion() {
        contador++;
        if (contador < AppReproductor.listaCanciones.size()){
            mp.stop();
            String urlMusica = AppReproductor.listaCanciones.get(contador).getCancion();
            String ip = this.getResources().getString(R.string.ip);
            urlMusica = "http://" + ip + ":8080/" + urlMusica;
            
            Bitmap bitmap;
            try {
                ImageView ivImagenAlbum = (ImageView)this.findViewById(R.id.wvReproduciendo);

                //Se busca la imagen remota
                URL url1 = new URL("http://" + ip + ":8080/" + AppReproductor.listaCanciones.get(contador).getAlbum());
                bitmap = BitmapFactory.decodeStream(url1.openStream());
                //Se coloca la imagen remota
                ivImagenAlbum.setImageBitmap(bitmap);
            } catch (IOException ex) {
                Logger.getLogger(Reproduciendo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Uri url = Uri.parse(urlMusica);
            mp = MediaPlayer.create(this, url);
            mp.setOnBufferingUpdateListener(this);
            mp.setOnCompletionListener(this);
            mp.start();
        } else {
            contador--;
        }
    }
    
    private void cancionAnterior() {
        
        contador--;
        if (contador >= 0){
            mp.stop();
            String urlMusica = AppReproductor.listaCanciones.get(contador).getCancion();
            String ip = this.getResources().getString(R.string.ip);
            urlMusica = "http://" + ip + ":8080/" + urlMusica;
            
            Bitmap bitmap;
            try {
                ImageView ivImagenAlbum = (ImageView)this.findViewById(R.id.wvReproduciendo);

                //Se busca la imagen remota
                URL url1 = new URL("http://" + ip + ":8080/" + AppReproductor.listaCanciones.get(contador).getAlbum());
                bitmap = BitmapFactory.decodeStream(url1.openStream());
                //Se coloca la imagen remota
                ivImagenAlbum.setImageBitmap(bitmap);
            } catch (IOException ex) {
                Logger.getLogger(Reproduciendo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Uri url = Uri.parse(urlMusica);
            mp = MediaPlayer.create(this, url);
            mp.setOnBufferingUpdateListener(this);
            mp.setOnCompletionListener(this);
            mp.start();
        } else {
            contador++;
        }
    }
    
}
