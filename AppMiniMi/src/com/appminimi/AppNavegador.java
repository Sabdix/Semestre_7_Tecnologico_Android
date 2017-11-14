package com.appminimi;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;




public class AppNavegador extends Activity implements OnClickListener {
    
	// constants
	final static String		LOG_TAG			= "Pokemon";
		
	final static int		idTopLayout 	= Menu.FIRST + 100,
							idBack 			= Menu.FIRST + 101,
							idBotLayout		= Menu.FIRST + 102,
							idAddr			= Menu.FIRST + 103,
							idButBack		= Menu.FIRST + 104,
							idButFwd		= Menu.FIRST + 105,
							idButReload		= Menu.FIRST + 106,
							idButStop		= Menu.FIRST + 107,
							idButGo			= Menu.FIRST + 108;
	
	// interface controls
	String					m_szPage	= "http://www.pokemon.com";
	int 					m_nHTMLSize	= 0;
	WebView					m_web;
	
	EditText				m_etAddr;
	
	TextView				m_tv;
	
	Button					m_bButBack, m_bButFwd, m_bButReload, m_bButStop, m_bButGo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //Hide titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //Create our top content holder
        RelativeLayout global_panel = new RelativeLayout (this);
		global_panel.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		global_panel.setGravity(Gravity.FILL);
		global_panel.setBackgroundDrawable(getResources().getDrawable( R.drawable.fondonv));
		// +++++++++++++ TOP COMPONENT: the header
		RelativeLayout ibMenu = new RelativeLayout(this);
     	ibMenu.setId(idTopLayout);
		ibMenu.setBackgroundDrawable(getResources().getDrawable(R.drawable.line));
     	int ibMenuPadding = (int) 6;
     	ibMenu.setPadding(ibMenuPadding,ibMenuPadding,ibMenuPadding,ibMenuPadding);
     	RelativeLayout.LayoutParams topParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
     	topParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
     	global_panel.addView(ibMenu,topParams);
     	//
     	int nTextH =  12;
		// go button
		m_bButGo = new Button(this);
		m_bButGo.setId(idButGo);
		m_bButGo.setOnClickListener((OnClickListener) this);
		m_bButGo.setText("Ir");
		m_bButGo.setTextSize(nTextH);
		m_bButGo.setTypeface(Typeface.create("arial", Typeface.BOLD));
		RelativeLayout.LayoutParams lpb5 = 
			new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lpb5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lpb5.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ibMenu.addView(m_bButGo, lpb5);
		// address field
		m_etAddr = new EditText(this);
		m_etAddr.setId(idAddr);
		m_etAddr.setText(m_szPage);
		nTextH =  12;
		m_etAddr.setTextSize(nTextH);
		m_etAddr.setTypeface(Typeface.create("arial", Typeface.NORMAL));
		RelativeLayout.LayoutParams lpbEdit = 
			new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		lpbEdit.addRule(RelativeLayout.RIGHT_OF, idButGo);
		lpbEdit.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ibMenu.addView(m_etAddr, lpbEdit);

		// +++++++++++++ BOTTOM COMPONENT: the footer
		RelativeLayout ibMenuBot = new RelativeLayout(this);
		ibMenuBot.setId(idBotLayout);
		ibMenuBot.setBackgroundDrawable(getResources().getDrawable(R.drawable.line));
		ibMenuBot.setPadding(ibMenuPadding,ibMenuPadding,ibMenuPadding,ibMenuPadding);
		RelativeLayout.LayoutParams botParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		botParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		global_panel.addView(ibMenuBot,botParams);
		m_bButBack = new Button(this);
     	m_bButBack.setId(idButBack);
     	m_bButBack.setOnClickListener((OnClickListener) this);
     	m_bButBack.setText("Atrás");
		m_bButBack.setTextSize(nTextH);
		m_bButBack.setTypeface(Typeface.create("arial", Typeface.BOLD));
		RelativeLayout.LayoutParams lpb1 = 
			new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lpb1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lpb1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ibMenuBot.addView(m_bButBack, lpb1);
		// fwd button
		m_bButFwd = new Button(this);
		m_bButFwd.setId(idButFwd);
		m_bButFwd.setOnClickListener((OnClickListener) this);
		m_bButFwd.setText("Adelante");
		m_bButFwd.setTextSize(nTextH);
		m_bButFwd.setTypeface(Typeface.create("arial", Typeface.BOLD));
		RelativeLayout.LayoutParams lpb2 = 
			new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lpb2.addRule(RelativeLayout.RIGHT_OF, idButBack);
		lpb2.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ibMenuBot.addView(m_bButFwd, lpb2);
		// reload button
		m_bButReload = new Button(this);
		m_bButReload.setId(idButReload);
		m_bButReload.setOnClickListener((OnClickListener) this);
		m_bButReload.setText("Recargar");
		m_bButReload.setTextSize(nTextH);
		m_bButReload.setTypeface(Typeface.create("arial", Typeface.BOLD));
		RelativeLayout.LayoutParams lpb3 = 
			new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lpb3.addRule(RelativeLayout.RIGHT_OF, idButFwd);
		lpb3.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ibMenuBot.addView(m_bButReload, lpb3);
		// stop button
		m_bButStop = new Button(this);
		m_bButStop.setId(idButStop);
		m_bButStop.setOnClickListener((OnClickListener) this);
		m_bButStop.setText("Detener");
		m_bButStop.setTextSize(nTextH);
		m_bButStop.setTypeface(Typeface.create("arial", Typeface.BOLD));
		RelativeLayout.LayoutParams lpb4 = 
			new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lpb4.addRule(RelativeLayout.RIGHT_OF, idButReload);
		lpb4.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ibMenuBot.addView(m_bButStop, lpb4);
		// status
		m_tv = new TextView(this);
		m_tv.setText("Estado");
		m_tv.setTextColor(Color.rgb(255,255,255));
		m_tv.setTextSize(nTextH);
		m_tv.setTypeface(Typeface.create("arial", Typeface.BOLD));
		RelativeLayout.LayoutParams lpcTV = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lpcTV.addRule(RelativeLayout.RIGHT_OF, idButStop);
		lpcTV.addRule(RelativeLayout.CENTER_VERTICAL);
		ibMenuBot.addView(m_tv, lpcTV); 
     	
		// +++++++++++++ MIDDLE COMPONENT: only a webview control
		m_web = new WebView(this);
		m_web.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		RelativeLayout.LayoutParams midParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		midParams.addRule(RelativeLayout.ABOVE,ibMenuBot.getId());
		midParams.addRule(RelativeLayout.BELOW,ibMenu.getId());
		global_panel.addView(m_web,midParams );
		// Configure our webview object
		m_web.getSettings().setJavaScriptEnabled(true);
		m_web.setWebViewClient(new MyWebViewClient());
		// set starting page
		if (m_szPage != null) m_web.loadUrl(m_szPage);
		// set java script used to get the HTML code
		m_web.addJavascriptInterface(new JavaScriptInterface(), "HTMLOUT");
		
		// Interface READY
		setContentView(global_panel);
    }
    
    // Used with Webview, to get the HTML code
    class JavaScriptInterface{
		public void showHTML(String html) {
			m_nHTMLSize = 0;
			if (html !=null) {
				//int i = html.lastIndexOf(""); //search for something in the text
				m_nHTMLSize = html.length();
				Log.d(LOG_TAG, "Conteido HTML: "+html+"\nTamaño:"+m_nHTMLSize+" bytes");
				
			}
		}
	}
	
	private class MyWebViewClient extends WebViewClient {
		
		@Override  
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			Log.d(LOG_TAG, "onPageStarted");
			m_tv.setText("Cargando Pagina...");
			//stop button is enabled only when pages are loading
			m_bButStop.setEnabled(true); 
		}
		@Override  
		public void onPageFinished(WebView view, String url) {
			Log.d(LOG_TAG, "onPageFinished");
			m_tv.setText("Lista");
			//stop button is disabled when pages are already loaded
			m_bButStop.setEnabled(false);
			// This call inject JavaScript into the page which just finished loading.   
			m_web.loadUrl("javascript:window.HTMLOUT.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
			// adjust prev/next buttons, only if history is available
			m_bButBack.setEnabled(m_web.canGoBack()); 
			m_bButFwd.setEnabled(m_web.canGoForward());
			
			
		}

	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	   
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		
		// If cancel is pressed, close our app
		if (id == idBack) finish();
		
		if (id == idButGo) {
			m_szPage = m_etAddr.getText().toString();
			Log.d(LOG_TAG, "Ir a página:"+m_szPage);
			if (m_szPage != null) m_web.loadUrl(m_szPage);
		}
		
		if (id == idButBack) {
			Log.d(LOG_TAG, "Atrás");
			m_web.goBack();
		}
		if (id == idButFwd) {
			Log.d(LOG_TAG, "Adelante");
			m_web.goForward();
		}
		
		if (id == idButReload) {
			Log.d(LOG_TAG, "Recargar");
			m_web.reload();
		}
		
		if (id == idButStop) {
			Log.d(LOG_TAG, "Detener");
			m_web.stopLoading();
		}
		
	}
}
