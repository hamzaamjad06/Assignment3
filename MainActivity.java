package com.example.hamza.assignment_mad_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.salman.assignment_mad_3.R;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {
    Switch wifi_switch;
    Switch airplane_switch;
    WifiManager wifiManager;
    EventBus eventBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        airplane_switch = findViewById(R.id.airplane_switch);
        wifi_switch = findViewById(R.id.WifiSwitch);
        Boolean state = airplane_switch.isChecked();
        CustomEvent customEvent = new CustomEvent();
        customEvent.setaBoolean(state);
        EventBus.getDefault().post(customEvent);
        wifiManager = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);

        wifi_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked && !wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                } else if (!isChecked && wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });
    }
}