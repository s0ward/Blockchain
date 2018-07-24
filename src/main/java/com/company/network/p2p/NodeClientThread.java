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
                processMessage(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMessage(String message) {
        String[] splitMessage = message.split("\\s+");
        switch (splitMessage[0]) {

            case "TRANSACTION":
                //Save it to your transaction pool
                //node.broadcastTransaction(new Transaction(Integer.parseInt(splitMessage[1]), splitMessage[2], splitMessage[3], Integer.parseInt(splitMessage[4])));
                node.broadcastMessage(message);
                break;

            case "IP":
                node.addPeer(splitMessage[1]);
                node.broadcastMessage(message);
                break;

            default:
                break;
        }
    }

}

