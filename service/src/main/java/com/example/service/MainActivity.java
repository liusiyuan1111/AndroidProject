package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart,btnStop;
        btnStart = findViewById(R.id.start);
        btnStop = findViewById(R.id.stop);
        final Intent intent = new Intent(MainActivity.this,MyService.class);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //启动服务
                startService(intent);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //停止服务的方法2
                stopService(intent);

            }
        });
    }
}
