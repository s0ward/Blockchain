package com.company.network.p2p;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class NodeServerThread extends Thread {

    private static final int LISTENING_PORT = 9001;
    private Node node;
    private BlockingQueue<String> messages;

    public NodeServerThread(Node node, BlockingQueue<String> messages) {
        this.node = node;
        this.messages = messages;
    }

    @Override
    public void run() {

//        System.out.println(new Date().toString() + " : " +
//            "Accepted client : " + sock.getInetAddress() +
//            ":" + sock.getPort());

        try {

            ServerSocket serverSocket = new ServerSocket(LISTENING_PORT);

            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                NodeServerClientThread nodeServerClientThread = new NodeServerClientThread(node, messages, socket);
                nodeServerClientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
