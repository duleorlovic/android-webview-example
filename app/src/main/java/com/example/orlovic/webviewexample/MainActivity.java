package com.example.orlovic.webviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // follow examples on:
        // https://developer.android.com/guide/webapps/webview#java
        //
        myWebView = (WebView) findViewById(R.id.webview);
//        setContentView(myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUserAgentString("cablecrm-app");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");


//        myWebView.loadUrl("https://cablecrm.herokuapp.com/");
        myWebView.loadUrl("http://192.168.5.4:3001/");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
