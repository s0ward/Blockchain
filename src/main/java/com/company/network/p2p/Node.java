package com.company.network.p2p;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Node {

    private static final int LISTENING_PORT = 9001;
    private static final int MAX_NEIGHBORS = 3;
    private NodeDatabase nodeDatabase;
    private BlockingQueue<String> messages;
    private String inetaddr;
    private Vector<String> peers = new Vector<>(MAX_NEIGHBORS);
    private int count = 0;

    public Node(){

        this.nodeDatabase = new NodeDatabase("Blockchain.txt");
        this.messages = new LinkedBlockingQueue<String>();
        this.inetaddr = getIp();
        this.startClient();
        this.startServer();

    }

    public void pushMessage(String message){
        messages.add(message);
    }

    public String getMessage(){
        return messages.remove();
    }

    public String getInetAddr() {
        return this.inetaddr;
    }

    public int getListeningPort(){
        return LISTENING_PORT;
    }

    public Vector<String> getPeers() {
        return this.peers;
    }

    public void addPeer(String peer) {

        if(peers.contains(peer)) return;

        if(peers.size() < MAX_NEIGHBORS){
            peers.add(peer);
        }
        else{
            peers.set(count, peer);
            count = (count+1)%MAX_NEIGHBORS;
        }

    }

    public void removePeer(String peer) {
        peers.remove(peer);
    }

    private String getIp() {

        URL ipChecker = null;
        try {
            ipChecker = new URL("http://checkip.amazonaws.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in = null;
        String ip = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                ipChecker.openStream()));
            ip = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ip;
    }

    private void startServer() {

        NodeServerThread nodeServerThread = new NodeServerThread(this, messages);
        nodeServerThread.start();

    }

    private void startClient() {
        NodeClientThread nodeClientThread = new NodeClientThread(this, messages);
        nodeClientThread.start();
    }

}
