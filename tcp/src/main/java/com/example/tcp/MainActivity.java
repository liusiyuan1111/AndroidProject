package com.example.tcp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static int recv = 0x1234;
    final static int send = 0x2345;
    final static String server_ip = "127.0.0.1";
    final static int server_port = 12345;
    private TextView show;
    private EditText edit;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        show = findViewById(R.id.show);
        edit = findViewById(R.id.edit);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    Thread.sleep(3000);
//                    Log.i("<<<<<<","等待3秒");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                new Thread(){
                    public void run(){
                        try {
                            while (true){
                                sleep(3000);
                                Log.i("<<<<<<","等待3秒");
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }.start();

            }
        });
    }
}

//主线程阻塞
//
//开启新线程



