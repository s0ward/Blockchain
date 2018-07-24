package com.company.network.p2p;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class NodeServerClientThread extends Thread {

    private int CLIENT_REQUEST_TIMEOUT = 15 * 60 * 1000;
    private Node node;
    private BlockingQueue<String> messages;
    private Socket sock = null;
    private BufferedReader socketReader = null;
    private BufferedWriter socketWriter = null;

    NodeServerClientThread(Node node, BlockingQueue<String> messages, Socket sock) throws IOException {
        this.node = node;
        this.messages = messages;
        this.sock = sock;
        sock.setSoTimeout(CLIENT_REQUEST_TIMEOUT);
        socketReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        socketWriter = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    }

    @Override
    public void run() {

//        System.out.println(new Date().toString() + " : " +
//            "Accepted client : " + sock.getInetAddress() +
//            ":" + sock.getPort());


        try {

            //Nodes are able to communicate following a protocol
            //TO DO: Implement a reasonable protocol

            while (!isInterrupted()) {
                String message = socketReader.readLine();
                messages.add(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

