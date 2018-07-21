package com.company.network.p2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ArrayList;

public class Node {

    private final static int LISTENING_PORT = 9001;
    private final static int MAX_NEIGHBORS = 3;
    private String inetaddr;
    private ArrayList<String> neighbors = new ArrayList<>(MAX_NEIGHBORS);
    private ServerSocket serverSocket;

    public Node() throws Exception {
        this.inetaddr = getIp();
        serverSocket = new ServerSocket(LISTENING_PORT);
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

    public String getInetaddr() {
        return inetaddr;
    }
}
