package com.company.network.p2p;

import java.io.*;
import java.net.Socket;

public class NodeClientThread extends Thread {

    private int CLIENT_REQUEST_TIMEOUT = 15 * 60 * 1000;
    private Node node;
    private Socket sock = null;
    private BufferedReader socketReader = null;
    private BufferedWriter socketWriter = null;



    NodeClientThread(Node node, Socket sock) throws IOException {
        this.node = node;
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

