package com.example.socketclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText edit_input;
    TextView tv;
    Button btn_send;
    final static int recv = 0x123;
    final static int send = 0x234;
    final static String server_ip = "127.0.0.1";
    final static int server_port = 12345;
    private Handler handler;
    private ClientThread clientThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv);
        edit_input = findViewById(R.id.edit_input);
        btn_send = findViewById(R.id.btn_send);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == recv){
                    String recv_msg = msg.obj.toString();
                    tv.append("\n"+recv_msg);
                }

            }
        };
        clientThread = new ClientThread(handler);
        new Thread(clientThread).start();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = send;
                msg.obj = edit_input.getText().toString();
                clientThread.recvHandler.sendMessage(msg);
                edit_input.setText("");
            }
        });
    }
}
