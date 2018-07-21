package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockServer {
    public static int LISTENING_PORT = 9000;


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(LISTENING_PORT);
        //System.out.println("Server started. Listening on port "+LISTENING_PORT+"...");


        while (true) {
            Socket socket = serverSocket.accept();
            MinerClientThread minerClientThread = new MinerClientThread(socket);
            minerClientThread.start();
        }
    }
}
