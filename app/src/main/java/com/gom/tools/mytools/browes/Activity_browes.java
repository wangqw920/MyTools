package com.gom.tools.mytools.browes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.gom.tools.mytools.R;

public class Activity_browes extends AppCompatActivity {
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browes);
         wv= (WebView) findViewById(R.id.webview_browees);
        WebSettings websettings=wv.getSettings();
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setLoadsImagesAutomatically(false);
        websettings.setJavaScriptEnabled(true);
    }

    public void onclick_openUrl(View view){

        TextView tv= (TextView) findViewById(R.id.text_url) ;
        wv.loadUrl(tv.getText().toString());
    }

}
