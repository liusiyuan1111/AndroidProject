package com.example.serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServerThread implements Runnable {
    Socket socket = null;
    BufferedReader bufferedReader = null;
    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            System.out.println("<<<<<<<<Thread<<<<<<<<<");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        String send = null;
        String recv = null;
        System.out.println("<<<<<<Begin<<<<<<<");
        while ((recv = readFromClient()) != null){
            for (Socket socket : MyClass.socketArrayList){
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    //send = recv;
                    send = "("+getCurrentTime()+")"+recv;
                    System.out.println(send);

                    outputStream.write((send+"\r\n").getBytes("utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(calendar.getTime());
        return time;
    }

    private String readFromClient() {

        try {
            String read = null;
            read = bufferedReader.readLine();
            return read;
        } catch (IOException e) {
            MyClass.socketArrayList.remove(socket);
            e.printStackTrace();
        }
        return null;
    }
}
