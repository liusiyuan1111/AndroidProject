package com.example.sendreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("状态：","接收到了广播");
        Toast.makeText(context,"成功接收到广播",Toast.LENGTH_LONG).show();
        abortBroadcast();
    }
}
