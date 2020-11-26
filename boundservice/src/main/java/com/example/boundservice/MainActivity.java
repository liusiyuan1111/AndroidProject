package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
MyService.MyBinder myBinder; //创建一个myBinder对象
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("客户端","==serviceConnected==");

        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("客户端","==serviceDisconnected==");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bind,unbind,btn;
        bind = findViewById(R.id.bind);
        unbind = findViewById(R.id.unbind);
        btn = findViewById(R.id.btn);
        final Intent intent = new Intent(MainActivity.this,MyService.class);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent,connection, Service.BIND_AUTO_CREATE);
                //参数1：当前绑定服务的intent对象
                //参数2：当前服务的连接状态
                //参数3：绑定服务的一个标记，绑定并且启动
            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(connection);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
    }
}
