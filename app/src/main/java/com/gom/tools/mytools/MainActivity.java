package com.gom.tools.mytools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gom.tools.mytools.browes.Activity_browes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick_openBrowes (View view){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,Activity_browes.class);
        startActivity(intent);
    }
}
