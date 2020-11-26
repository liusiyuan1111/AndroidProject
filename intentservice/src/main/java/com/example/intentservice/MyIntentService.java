package com.example.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    /**
     * @param name
     * @deprecated
     */
    public MyIntentService(String name) {
        super(name);
    }
    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("服务","服务已启动");
        long endTime = System.currentTimeMillis()+20*1000;
        while (System.currentTimeMillis()<endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void onDestroy() {
        Log.i("服务","服务已关闭");
        super.onDestroy();
    }
}
