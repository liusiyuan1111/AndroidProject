package com.example.socketclient;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread implements Runnable{
    private Socket socket=null;
    private InputStream inputStream=null;
    private OutputStream outputStream = null;
    private BufferedReader bufferedReader = null;
    public  Handler handler = null;
    public  Handler recvHandler = null;

    public ClientThread(Handler handler) {
        this.handler = handler;

    }


    @Override
    public void run() {
        try {
            socket = new Socket(MainActivity.server_ip,MainActivity.server_port);
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            outputStream = socket.getOutputStream();
            new Thread(){
                public void run(){
                    String recv_msg = null;
                    while ((recv_msg = readFromServer()) != null){
                        Message msg = null;
                        msg.what = MainActivity.recv;
                        msg.obj = recv_msg;
                        handler.sendMessage(msg);
                    }
                }
            }.start();
            Looper.prepare();

            recvHandler = new Handler(){
                @Override
                public void handleMessage( Message msg) {
                    String send_msg = null;
                    if(msg.what == MainActivity.send){

                        try {
                            send_msg = socket.getLocalAddress().toString()+":"+msg.obj.toString()+"\r\n";
                            outputStream.write(send_msg.getBytes("utf-8"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            };
            Looper.loop();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String readFromServer() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
