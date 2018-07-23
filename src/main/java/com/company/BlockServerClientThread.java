package com.company;

import java.io.*;
import java.net.Socket;

public class BlockServerClientThread extends Thread {

    private int CLIENT_REQUEST_TIMEOUT = 15 * 60 * 1000;
    private Socket sock = null;
    private BufferedReader socketReader = null;
    private BufferedWriter socketWriter = null;
    private ObjectInputStream ois = null;


    BlockServerClientThread(Socket sock) throws IOException {
        this.sock = sock;
        sock.setSoTimeout(CLIENT_REQUEST_TIMEOUT);
        socketReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        socketWriter = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        ois = new ObjectInputStream(sock.getInputStream());
    }

    @Override
    public void run() {

//        System.out.println(new Date().toString() + " : " +
//            "Accepted client : " + sock.getInetAddress() +
//            ":" + sock.getPort());


        try {

            //Miner should send valid blocks over the wire

            while (!isInterrupted()) {

                Block block = null;
                try {

                    block = (Block) ois.readObject();
                    System.out.println(block);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}