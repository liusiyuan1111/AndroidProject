package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity的生命周期","onCreat()方法调用");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity的生命周期","onStart()方法调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity的生命周期","onResume()方法调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity的生命周期","onPause()方法调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity的生命周期","onStop()方法调用");
    }

  

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity的生命周期","onDestroy()方法调用");
    }
}
