package com.company;

import java.io.*;
import java.net.Socket;

public class Miner {

    private static Socket socket;
    private static BufferedReader socketReader;
    private static BufferedWriter socketWriter;
    private static ObjectOutputStream oos;
    private TransactionPool transPool;

    public static void main(String[] args) throws Exception {
        socket = new Socket("localhost", BlockServer.LISTENING_PORT);
        socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        oos = new ObjectOutputStream(socket.getOutputStream());
        mine();

    }

    private static Block getBlock() throws Exception {
        //Returns a new Block formed by taking transactions from the transPool
        //return null;
        Ledger ledger = new Ledger();
        ledger.addTransaction(new Transaction(1, "me", "you", 10));
        return new Block("prevHashEXAMPLE", "nonceEXAMPLE", new Ledger());
    }

    private static void sendBlock(Block block) throws IOException {
        //sends the block to either the BlockServer or the TransactionPool
        oos.writeObject(block);
        oos.flush();
    }

    private static void mine() throws Exception {
        while (true) {

            Block currentBlock = getBlock();
            Integer counter = 0;

            while (!currentBlock.isValid()) {
                currentBlock.setNonce(counter.toString());
                counter++;
                currentBlock.updateHash();
                System.out.println("Counter: " + counter + " Hash: " + currentBlock.getHeaderHash());
            }

            sendBlock(currentBlock);
        }
    }

}
