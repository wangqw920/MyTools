package com.gom.tools.mytools.browes;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.gom.tools.mytools.R;

public class Activity_browes extends AppCompatActivity {
    private WebView wv;
    private TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_browes);
        tv= (TextView) findViewById(R.id.text_url);
        wv= (WebView) findViewById(R.id.webview_browees);
        WebSettings websettings=wv.getSettings();
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setLoadsImagesAutomatically(false);
        websettings.setJavaScriptEnabled(true);
        websettings.setDomStorageEnabled(true);
        //websettings.setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            websettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        //disable use system browes
        wv.setWebViewClient(new WebViewClient()
                            {
                                @Override
                                public void onPageFinished(WebView view, String url) {
                                   tv.setText(wv.getUrl());
                                }
                            }
        );

    }

    public void onclick_openUrl(View view){
    //  move to top
        tv= (TextView) findViewById(R.id.text_url) ;
        String string_url = tv.getText().toString();
        if(string_url.isEmpty()){
            wv.loadUrl("https://www.baidu.com");
        }else {
            wv.loadUrl(string_url);
        }

    }

    public void onclick_goForward(View view){
        wv.goForward();
    }

    @Override
    public void onBackPressed(){
        wv.goBack();
    }



}
