/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AppReproductor extends Activity 
{
    ListView lvArchivosEncontrados;
    ImageButton btnStop, btnPause;
    TextView tvNombre;
    ImageView ivPortada;
    MediaPlayer mp = new MediaPlayer();
    private String[] mAudioPath;
    private MediaPlayer mMediaPlayer;
    private String[] mMusicList;
    int soundLength;
       

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.appreproductor);

    mMediaPlayer = new MediaPlayer();

    ListView mListView = (ListView) findViewById(R.id.lvArchivosEncontrados);
    btnStop = (ImageButton)this.findViewById(R.id.btnStop);
    btnPause = (ImageButton)this.findViewById(R.id.btnPause);    
    tvNombre = (TextView)this.findViewById(R.id.tvNombre);
    ivPortada = (ImageView)this.findViewById(R.id.ivPortada);
    
    ActionBar bar = getActionBar();
    bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DF2328")));
    //bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.iconobar));

    mMusicList = getAudioList();

    ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
    R.layout.simple_list_item_1, mMusicList);
    mListView.setAdapter(mAdapter);

    mListView.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
    long arg3) {
    try {
        playSong(mAudioPath[arg2]);
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
   });
    
   btnStop.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) 
        {
            if (mMediaPlayer.isPlaying()) 
            {
                mMediaPlayer.stop();
                ivPortada.setImageResource(R.drawable.discodos);
                tvNombre.setText("MP3PLAYER MSYC");
            }
            
        }
    });
   
   btnPause.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) 
        {
             if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.pause();
                btnPause.setImageResource(R.drawable.playrojo);
            } else {
                mMediaPlayer.start();
                 btnPause.setImageResource(R.drawable.pauserojo);
            }
        }
    });
}

private String[] getAudioList() {
    final Cursor mCursor = getContentResolver().query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            new String[] { MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA }, null, null,
            "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");

    int count = mCursor.getCount();

    String[] songs = new String[count];
    mAudioPath = new String[count];
    int i = 0;
    if (mCursor.moveToFirst()) {
        do {
            songs[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
            mAudioPath[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
            i++;
        } while (mCursor.moveToNext());
    }   
    
    mCursor.close();

    return songs;
}

 private void playSong(String path) throws IllegalArgumentException,
    IllegalStateException, IOException {
    btnPause.setImageResource(android.R.color.transparent);
    btnPause.setImageResource(R.drawable.pauserojo);

    Log.d("ringtone", "playSong ::" + path);
    
    mMediaPlayer.reset();
    mMediaPlayer.setDataSource(path); 
    mMediaPlayer.prepare();
    mMediaPlayer.start();
    
    
    MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
    metaRetriever.setDataSource(path);
    
    byte [] data = metaRetriever.getEmbeddedPicture();
              
        if(data != null)
        {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            ivPortada.setImageBitmap(bitmap); //associated cover art in bitmap
            ivPortada.setAdjustViewBounds(true);
            ivPortada.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
        }
        else
        {
            ivPortada.setImageResource(R.drawable.discodos); //any default cover resourse folder
            ivPortada.setAdjustViewBounds(true);
        }

     String out = "";
     String duration =  
     metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
     
    if("null".equals(metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)))
    {
        tvNombre.setText("Canción MP3 ");
        
    }else
    {
        tvNombre.setText(metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE) + " ");        
    }
     
     
    
     Log.v("time", duration);
     long dur = Long.parseLong(duration);
     String seconds = String.valueOf((dur % 60000) / 1000);

     Log.v("seconds", seconds);
     String minutes = String.valueOf(dur / 60000);
     out = minutes + ":" + seconds;
     if (seconds.length() == 1) {
         tvNombre.append(" 0" + minutes + ":0" + seconds);
     }else {
         tvNombre.append("0" + minutes + ":" + seconds);
     }
     Log.v("minutes", minutes);
     
     metaRetriever.release(); 
}
 
}
