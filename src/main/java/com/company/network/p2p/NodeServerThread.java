package com.company.network.p2p;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NodeServerThread extends Thread {

    private static final int LISTENING_PORT = 9001;

    @Override
    public void run() {

//        System.out.println(new Date().toString() + " : " +
//            "Accepted client : " + sock.getInetAddress() +
//            ":" + sock.getPort());

        try {

            ServerSocket serverSocket = new ServerSocket(LISTENING_PORT);

            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                NodeClientThread nodeClientThread = new NodeClientThread(socket);
                nodeClientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
