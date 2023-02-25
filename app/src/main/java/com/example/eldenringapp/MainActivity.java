package com.example.eldenringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise the layout
        webView = findViewById(R.id.webvidew);

        // enable the javascript to load the url
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // add the url of gif
        webView.loadUrl("https://media0.giphy.com/media/qCH9KuZ80OTaaqNLpK/giphy.gif?cid=ecf05e473u2jjuddo9rpvcv5ej0pyj81sbtw536zcmqrgpcy&rid=giphy.gif&ct=g");


    }
}