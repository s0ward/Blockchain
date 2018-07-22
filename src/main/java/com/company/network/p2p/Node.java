package com.company.network.p2p;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

public class Node {

    private static final int LISTENING_PORT = 9001;
    private static final int MAX_NEIGHBORS = 3;
    private String inetaddr;
    private ArrayList<String> neighbors = new ArrayList<>(MAX_NEIGHBORS);

    public Node() throws Exception {
        this.inetaddr = getIp();
    }

    public static void main(String[] args) throws IOException {

            NodeServerThread nodeServerThread = new NodeServerThread();
            nodeServerThread.start();

    }

    private static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendMessage(String host, String message){
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
