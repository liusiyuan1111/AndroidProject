package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context,"获取网络状态改变",Toast.LENGTH_SHORT).show();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE); //获取系统服务
        //获取网络状态的信息
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()){
            Toast.makeText(context,"连接",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context,"断开",Toast.LENGTH_LONG).show();
        }

    }
}
