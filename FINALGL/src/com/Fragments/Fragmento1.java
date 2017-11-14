
package com.Fragments;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.mainprincipal.FullscreenDemoActivity;
import com.mainprincipal.MainActivity;
import static com.mainprincipal.MainActivity.parserVideo;
import static com.mainprincipal.MainActivity.videoAdapter;
import static com.mainprincipal.MainActivity.videoArrayList;
import com.mainprincipal.R;
import com.Adapters.AdapterCategory;
import com.Adapters.Category;
import com.Adapters.JsonParser;
import com.Adapters.Video;
import com.Adapters.VideoAdapter;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public class Fragmento1 extends Fragment implements AdapterView.OnItemClickListener{

    
    public static ListView listVideo;
    NotificationManager nm;
    Notification notification;
    CharSequence tickerText;
    int icon;
    long when;
    View view;
    public static ArrayList<Category> categorias = new ArrayList<Category>();

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bundle) {
        view = li.inflate(R.layout.tab1, vg, false);
        
        listVideo=(ListView)view.findViewById(R.id.lvVideos);
        MainActivity.parserVideo=new JsonParser();
        getAuthToken(); 
        MainActivity.videoArrayList=new ArrayList<Video>();
        
        nm = (NotificationManager)this.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        icon = R.drawable.logo_launcher;
        tickerText = "Notification Bar";
        when = System.currentTimeMillis();
        
        listVideo.setOnItemClickListener(this);
        listVideo.setAdapter(MainActivity.videoAdapter);
        
        
        return view ;
        
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MainActivity.vObject = videoArrayList.get(position); 
        String video=MainActivity.vObject.getVideoId();
        Intent inFullScreenDemo=new Intent(view.getContext(),FullscreenDemoActivity.class);
        inFullScreenDemo.putExtra("video",video);
        //inFullScreenDemo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inFullScreenDemo);    
    }

    public void getAuthToken(){
    AccountManager.get(view.getContext()).getAuthTokenByFeatures("com.google", "oauth2:https://gdata.youtube.com", null, this.getActivity(),
                null, null, new AccountManagerCallback<Bundle>() {
        @Override
            public void run(AccountManagerFuture<Bundle> future) {
                try {
                    Bundle bundle = future.getResult();
                    @SuppressWarnings("unused")
                    String acc_name = bundle.getString(AccountManager.KEY_ACCOUNT_NAME);
                    MainActivity.auth_token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                    Log.e("auth_token",MainActivity.auth_token);
                } catch (Exception e) {                    
                    e.printStackTrace();                        
                }
            }
        }, null);    
       new Fragmento1.Async().execute("");  
    }
    
    public class Async extends AsyncTask<String,String,String>{
        ArrayList<Video> videolist;
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            MainActivity.progress=new ProgressDialog(view.getContext());
            MainActivity.progress.setMessage("Loading data...");
            MainActivity.progress.show();
        }
        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try{
                videolist=MainActivity.parsingJson(MainActivity.parserVideo.url); //through this method we are parsing the data 
            }catch (Exception e) {
                // TODO: handle exception
                //finish(); //If some exception occur we are killing the application

            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            try{
                //videoAdapter class is used to customized the ListView
                MainActivity.videoAdapter=new VideoAdapter(view.getContext(),videolist,view.getContext().getContentResolver(),view.getContext().getResources());        
                listVideo.setAdapter(videoAdapter);
                listVideo.setFastScrollEnabled(true);
                MainActivity.progress.dismiss();  // Here we are closing the progress dialog after completing the background task.
                
                if (MainActivity.notific) {
                    if (videolist.size() > MainActivity.contadorVideos) {
                        
                        MainActivity.mibd.setCount(MainActivity.notific + ", " + videolist.size());
                        MainActivity.contadorVideos = videolist.size();
                        //Notification
                        notification = new Notification(icon, tickerText, when);

                        Context context = view.getContext();
                        CharSequence contentTitle = "Nuevo Video";
                        CharSequence contentText = "Hay Nuevos Videos!!!!";

                        //Agregando sonido
                        notification.defaults |= Notification.DEFAULT_SOUND;
                        //Agregando vibración
                        notification.defaults |= Notification.DEFAULT_VIBRATE;

                        Intent notificationIntent = new Intent(view.getContext(), MainActivity.class);
                        PendingIntent contentIntent = PendingIntent.getActivity(view.getContext(), 0, notificationIntent, 0);
                        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

                        nm.notify(0, notification);
                    } else {
                         MainActivity.mibd.setCount(MainActivity.notific + ", " + videolist.size());
                        MainActivity.contadorVideos = videolist.size();
                    }
                }
                
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
      
}
