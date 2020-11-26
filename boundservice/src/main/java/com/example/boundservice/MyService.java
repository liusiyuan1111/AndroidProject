package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    //通过bindService绑定服务，启动后回调的方法
    public IBinder onBind(Intent intent) {
        Log.i("服务","==onBind==");
        return  Binder;
    }
    private MyBinder Binder = new MyBinder(); //创建一个继承自binder的类
    class MyBinder extends Binder{

    }

    @Override
    //服务创建时回调的方法
    public void onCreate() {

                Log.i("服务","==onCreate==");

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("服务","==onStart==");
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    //通过unbindService解绑时回调的方法
    public boolean onUnbind(Intent intent) {
        Log.i("服务","==onUnbind==");
        return super.onUnbind(intent);
    }

    @Override
    //有新的client连接到当前的服务
    public void onRebind(Intent intent) {
        Log.i("服务","==onRebind");
        super.onRebind(intent);
    }


    @Override
    //服务销毁时回调的方法
    public void onDestroy() {
        Log.i("服务","==onDestroy");
        super.onDestroy();
    }
}
