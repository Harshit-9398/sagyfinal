package com.example.abhi.sagyfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class web_view extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);

        WebView myWebView = findViewById(R.id.webview_about);
        myWebView.loadUrl("http://saanjhi.gov.in/aboutus.aspx");





    }

}
