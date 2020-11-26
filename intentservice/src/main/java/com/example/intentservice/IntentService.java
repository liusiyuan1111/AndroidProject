package com.example.intentservice;

import android.content.Intent;

import androidx.annotation.Nullable;

public class IntentService extends android.app.IntentService {
    /**
     * @param name
     * @deprecated
     */
    public IntentService(String name) {
        super(name);
    }
    public IntentService(){
        super("IntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        
    }
}
