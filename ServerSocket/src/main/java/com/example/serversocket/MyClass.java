package com.example.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyClass {
    public static ArrayList<Socket> socketArrayList = new ArrayList<Socket>();
    final static int LISTEN_PORT = 12345;
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(LISTEN_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){

            try {
                System.out.println("<<<<<<<<Listening<<<<<<");
                Socket socket = serverSocket.accept();
                socketArrayList.add(socket);
                new Thread(new ServerThread(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
