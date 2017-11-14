
package com.mios;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

/**
 *
 * @author sabdi
 */
public class Navegador extends Activity {

    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    EditText txtUrl = null;

    public final String HOME = "http://www.google.com/";

    private class MiWebViewClient extends WebViewClient {

        private void iniciaCarga(WebView v) {
            if(progressBar==null){
                progressBar = new ProgressDialog(v.getContext());
            }
            if (progressBar != null && !progressBar.isShowing()) {
                progressBar.setTitle("Espere...");
                progressBar.setMessage("Cargando página...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressBar.setCancelable(false);
                pbShow();
                progressBarStatus = 0;
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                    progressBarHandler.post(new Runnable() {
                    public void run() {
                        try {
                             progressBar
                              .setProgress(progressBarStatus++);
                        } catch (Exception e) {
                        }
                      }
                     });
                    }
                });
            }
        }

        private void pbCancel() {
            try {
                progressBar.cancel();
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage());
            }
        }

        private void pbShow() {
            try {
                progressBar.show();
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage());
            }
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            iniciaCarga(view);
            if (txtUrl != null) {
                txtUrl.setText(url);
            }
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pbCancel();
        }
    }

    private class MiChromeWebViewClient extends WebChromeClient {

    }

    WebView wv_pagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navegador);
        wv_pagina = (WebView) findViewById(R.id.wbNavegador);
        txtUrl = (EditText) findViewById(R.id.etUrl);
        wv_pagina.clearHistory();
        wv_pagina.clearCache(true);
        wv_pagina.setWebViewClient(new MiWebViewClient());
        wv_pagina.setWebChromeClient(new MiChromeWebViewClient());
        wv_pagina.getSettings().setJavaScriptEnabled(true);
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                wv_pagina.loadUrl(HOME);
            }
        });

    }
    
    public void eventoAdelante(View view) {
         if (wv_pagina.canGoForward()) {
            wv_pagina.goForward();
        }
    }
    
    public void eventoAtras(View view) {
        if (wv_pagina.canGoBack()) {
            wv_pagina.goBack();
        }
    }
    
    public void eventoEntrar(View view) {
        if (txtUrl.getText().toString().contains("http://") | txtUrl.getText().toString().contains("https://")) {
            wv_pagina.loadUrl(txtUrl.getText().toString());
        } else {
            wv_pagina.loadUrl("http://"+txtUrl.getText().toString());
        }
    }
}
