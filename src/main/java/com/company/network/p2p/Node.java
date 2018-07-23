package com.company.network.p2p;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

public class Node {

    private static final int LISTENING_PORT = 9001;
    private static final int MAX_NEIGHBORS = 3;
    private String inetaddr;
    private ArrayList<String> neighbors = new ArrayList<>(MAX_NEIGHBORS);

    public Node() {
        this.inetaddr = getIp();
    }

    public static void main(String[] args) {

        NodeServerThread nodeServerThread = new NodeServerThread();
        nodeServerThread.start();

    }

    private static String getIp() {
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

    private void sendMessage(String host, String message) {
        Socket socket = null;
        try {
            socket = new Socket(host, LISTENING_PORT);
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            socketWriter.write(message);
            socketWriter.flush();

            socketWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageToAll(String message) {
        for (String neighbor : neighbors) {
            sendMessage(neighbor, message);
        }
    }

    public String getInetAddr() {
        return inetaddr;
    }

}
