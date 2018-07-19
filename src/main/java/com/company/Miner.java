package com.company;

public class Miner {

    private TransactionPool transPool;
    private Block currentBlock;

    private void getBlock(){
        //currentBlock = A new Block formed by taking transactions from the transPool
    }

    private void sendBlock(){
        //sends the block to either the BlockServer or the TransactionPool
    }
    public void mine(){


        while(true) {

            getBlock();
            Integer counter = 0;

            while (!currentBlock.isValid()) {
                currentBlock.setNonce(counter.toString());
                counter++;
            }
            sendBlock();
        }
    }

}
