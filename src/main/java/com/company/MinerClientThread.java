package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class MinerClientThread extends Thread {

    private int CLIENT_REQUEST_TIMEOUT = 15*60*1000;
    private Socket sock = null;
    private BufferedReader socketReader = null;
    private BufferedWriter socketWriter = null;


    MinerClientThread(Socket sock) throws IOException {
        this.sock = sock;
        sock.setSoTimeout(CLIENT_REQUEST_TIMEOUT);
        socketReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        socketWriter = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    }

    public void run(){

        System.out.println(new Date().toString() + " : " +
            "Accepted client : " + sock.getInetAddress() +
            ":" + sock.getPort());


        try {

            //Miner should send valid blocks over the wire
            socketWriter.write("Hello, Miner! What do you have for me?\n");
            socketWriter.flush();
            String answer = socketReader.readLine();



            while (!isInterrupted()) {
                String message = socketReader.readLine();
                if (message == null) break; // Client closed the socket

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}