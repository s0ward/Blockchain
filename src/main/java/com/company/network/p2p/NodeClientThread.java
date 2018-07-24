package com.company.network.p2p;

import com.company.Transaction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class NodeClientThread extends Thread{

    private Node node;

    public NodeClientThread(Node node) {
        this.node = node;
    }

    @Override
    public void run() {
        System.out.println("ClientThread is running...");
        while(true){

            while(!node.messagesIsEmpty()){
                System.out.println("Yo, a new message!");
                processMessage(node.getMessage());
            }
        }
    }


    private void processMessage(String message) {
        String[] splitMessage = message.split("\\s+");
        switch (splitMessage[0]) {

            case "TRANSACTION":
                //Save it to your transaction pool
                broadcastMessage(message);
                break;

            case "IP":
                node.addPeer(splitMessage[1]);
                broadcastMessage(message);
                break;

            default:
                break;
        }
    }

    public void sendMessage(String host, String message) {

        Socket socket = null;

        try {
            socket = new Socket(host, node.getListeningPort());
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            socketWriter.write(message);
            socketWriter.flush();

            socketWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void broadcastMessage(String message) {

        for (String peer : node.getPeers()) {
            sendMessage(peer, message);
        }

    }

    public void sendPeers(String host){
        for(String peer: node.getPeers()){
            sendIP(host, peer);
        }
    }

    public void broadcastPeers(){
        for(String peer: node.getPeers()){
            broadcastIP(peer);
        }
    }

    public void sendOwnIp(String host){
        sendIP(host, node.getInetAddr());
    }

    public void broadcastOwnIp(){
        broadcastIP(node.getInetAddr());
    }

    public void broadcastTransaction(Transaction transaction){
        broadcastMessage("TRANSACTION: "+transaction.toString());
    }

    public void sendIP(String host, String ip){
        sendMessage(host, "IP: "+ ip);
    }

    public void broadcastIP(String ip){
        broadcastMessage("IP: "+ip);
    }

}
