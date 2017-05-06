package com.gom.tools.mytools.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gom.tools.mytools.R;

public class Activity_Battery extends AppCompatActivity {
    private Button bt_showInfo;
    private TextView text_Vc;
    private TextView text_Fa;
    private TextView text_Fa_avg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__battery);
        findView();
    }

    private void findView(){
        bt_showInfo=(Button) findViewById(R.id.bt_showInfo);
        text_Vc=(TextView) findViewById(R.id.text_vc);
        text_Fa=(TextView) findViewById(R.id.text_fA);
        text_Fa_avg=(TextView) findViewById(R.id.text_Fa_avg);
    }

    public void onclick_showBt(View view){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mBroadcastReceiver, filter);
            BatteryManager batteryManager=(BatteryManager)getSystemService(BATTERY_SERVICE);

             int cOUNTER = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
        int tECHNOLOGY = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW);
        int tECHNOLOGY_avg = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE);
        //int voltage = b
        text_Vc.setText(Integer.toString(cOUNTER));
        text_Fa.setText(Integer.toString(tECHNOLOGY));
        text_Fa_avg.setText(Integer.toString(tECHNOLOGY_avg));
        //text_Power.setText();


    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);

//            int perty_AVG = BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE;
//            int perty_now = BatteryManager.BATTERY_PROPERTY_CURRENT_NOW;
                text_Vc.setText(Integer.toString(voltage));
//            text_Fa.setText(Integer.toString(perty_AVG)+" and "+Integer.toString(perty_now));
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        // 解除注册监听
        //unregisterReceiver(mBroadcastReceiver);
    }
}
