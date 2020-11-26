package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {  //构造函数
    }

    @Override
    public IBinder onBind(Intent intent) {  //绑定服务
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() { //创建服务
        Log.i("服务状态：","服务已创建");
        super.onCreate();
    }
    volatile boolean isStop = false;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {  //启动服务
        //创建新线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("服务状态：","服务已启动");
                int i = 0;
                while (!isStop){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++i;
                    Log.i("服务执行中：",String.valueOf(i));
                }
                //停止服务方法1
                //stopSelf();

            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {   //销毁服务
        isStop = true;
        Log.i("服务状态：","服务已销毁");
        super.onDestroy();
    }
}
