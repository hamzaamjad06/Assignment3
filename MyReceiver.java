package com.example.hamza.assignment_mad_3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by hamza on 12/7/2017.
 */

public class MyReceiver extends BroadcastReceiver {

    Boolean b;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "HELLO", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().register(this);
    }
    @Subscribe
    public void onEvent(CustomEvent event) {
        b = event.getaBoolean();
    }
}

