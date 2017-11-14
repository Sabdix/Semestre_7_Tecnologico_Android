package com.mainprincipal;


import ModeloBd.ModeloBD;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.Window;
import com.mainprincipal.R;
import com.Adapters.JsonParser;
import com.Adapters.Video;
import com.Adapters.VideoAdapter;
import com.Fragments.Fragmento1;
import com.Fragments.Fragmento2;
import com.Fragments.Fragmento3;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends FragmentActivity 
{
    public static int contadorVideos;
    private String [] temporal;
    public static boolean notific = false;
    public static Activity activity;
    private FragmentTabHost tabHost;
    public static ModeloBD mibd;
    public static ArrayList<Video> videoArrayList;
    //private ListView listVideo;
    public static VideoAdapter videoAdapter;
    public static String auth_token;
    public static Video vObject;
    public static JsonParser parserVideo;
    public static ProgressDialog progress;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        activity = this;
//        //listVideo=(ListView)findViewById(R.id.videolist);
//        parserVideo=new JsonParser();
//        getAuthToken();        
//        videoArrayList=new ArrayList<Video>();
//        listVideo.setOnItemClickListener(this);
//        listVideo.setAdapter(videoAdapter);
        
        mibd = new ModeloBD(this, "BD", null, 1);
        temporal = mibd.getCount().split(",");
        notific = Boolean.parseBoolean(temporal[0]);
        contadorVideos = Integer.parseInt(temporal[1].replace(" ", ""));
        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Videos"), Fragmento1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Tutorials"), Fragmento2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Options"), Fragmento3.class, null);
        
        
        
        
        
    }

//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        vObject = videoArrayList.get(position); 
//        String video=vObject.getVideoId();
//        Intent inFullScreenDemo=new Intent(MainActivity.this,FullscreenDemoActivity.class);
//        inFullScreenDemo.putExtra("video",video);
//        inFullScreenDemo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(inFullScreenDemo);    
//    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
    
    ////This method is used to get the auth_token from your gmail sync account////
//    public void getAuthToken(){
//    AccountManager.get(getApplicationContext()).getAuthTokenByFeatures("com.google", "oauth2:https://gdata.youtube.com", null, this,
//                null, null, new AccountManagerCallback<Bundle>() {
//        @Override
//            public void run(AccountManagerFuture<Bundle> future) {
//                try {
//                    Bundle bundle = future.getResult();
//                    @SuppressWarnings("unused")
//                    String acc_name = bundle.getString(AccountManager.KEY_ACCOUNT_NAME);
//                    auth_token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
//                    Log.e("auth_token",auth_token);
//                } catch (Exception e) {                    
//                    e.printStackTrace();                        
//                }
//            }
//        }, null);    
//       new Async().execute("");  
//    }
    
    public static ArrayList<Video>parsingJson(String videoUrl){
    try {    
            JSONObject json=parserVideo.getJsonFromYoutube(videoUrl+auth_token);
            JSONArray jArray=new JSONArray(json.getString("items"));
            for(int i=0;i<jArray.length();i++){
                JSONObject thumbnail=jArray.getJSONObject(i);
                JSONObject snippets=thumbnail.getJSONObject("snippet");
                JSONObject defaulturl=snippets.getJSONObject("thumbnails");
                JSONObject url=defaulturl.getJSONObject("high");
                JSONObject resourceId=snippets.getJSONObject("resourceId");
                String videoId=resourceId.getString("videoId");
                String imageurl=url.getString("url");
                String title=snippets.getString("title");
                vObject=new Video(title, imageurl, videoId);
                videoArrayList.add(i,vObject);                
                //Log.e("videoArrayList",""+videoArrayList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }    
        return videoArrayList;
    }
    
    public void invalidateAccount(){
        AccountManager accountManager = AccountManager.get(MainActivity.this);
        accountManager.invalidateAuthToken("com.google",auth_token);
    }
    
    ///This class is used to do some background task.
    //Here in this blog, we are using it for parsing the JSON data 
    //that we are getting from youtube.  
//    public class Async extends AsyncTask<String,String,String>{
//        ArrayList<Video> videolist;
//        @Override
//        protected void onPreExecute() {
//            // TODO Auto-generated method stub
//            super.onPreExecute();
//            progress=new ProgressDialog(MainActivity.this);
//            progress.setMessage("Loading data...");
//            progress.show();
//        }
//        @Override
//        protected String doInBackground(String... params) {
//            // TODO Auto-generated method stub
//            try{
//                videolist=parsingJson(parserVideo.url); //through this method we are parsing the data 
//            }catch (Exception e) {
//                // TODO: handle exception
//                finish(); //If some exception occur we are killing the application
//
//            }
//            return null;
//        }
//        @Override
//        protected void onPostExecute(String result) {
//            // TODO Auto-generated method stub
//            super.onPostExecute(result);
//            try{
//                //videoAdapter class is used to customized the ListView
//                videoAdapter=new VideoAdapter(MainActivity.this,videolist,MainActivity.this.getContentResolver(),MainActivity.this.getResources());        
//                listVideo.setAdapter(videoAdapter);
//                listVideo.setFastScrollEnabled(true);
//                progress.dismiss();  // Here we are closing the progress dialog after completing the background task.
//            }catch (Exception e) {
//                // TODO: handle exception
//            }
//        }
//    }
 
}
