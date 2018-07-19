package com.company;

import java.io.*;
import java.net.Socket;

public class Miner {

    private TransactionPool transPool;

    private static Socket socket;
    private static BufferedReader socketReader;
    private static BufferedWriter socketWriter;


    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", BlockServer.LISTENING_PORT);
        socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        mine();

    }

    private static Block getBlock(){
        //Returns a new Block formed by taking transactions from the transPool
        return null;
    }

    private static void sendBlock(Block block) throws IOException {
        //sends the block to either the BlockServer or the TransactionPool
        socketWriter.write(block.toString());
    }

    public static void mine() throws IOException {
        while(true) {

            Block currentBlock = getBlock();
            Integer counter = 0;

            while (!currentBlock.isValid()) {
                currentBlock.setNonce(counter.toString());
                counter++;
            }

            sendBlock(currentBlock);
        }
    }

}
