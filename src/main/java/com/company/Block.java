package com.company;

import java.security.NoSuchAlgorithmException;

public class Block {
    private static final int DIFFICULTY = 2;
    private static int blockCounter=0;
    private int blockNumber = 0;
    private BlockHeader header;
    private String headerHash;
    private Ledger ledger;
    //private int blockSize;


    public Block(String prevHash, String nonce, Ledger ledger) throws NoSuchAlgorithmException {
        blockCounter++;
        blockNumber = blockCounter;
        this.header = new BlockHeader(prevHash,nonce,ledger.hash());
        this.ledger = ledger;
        this.headerHash = header.hash();
        System.out.println("Block number: "+this.blockNumber+" is created");
    }

    public void setNonce(String nonce){
        this.header.setNonce(nonce);
    }

    public boolean isValid(){

        char[] arr = headerHash.toCharArray();

        for(int i=0; i<DIFFICULTY; i++) if(arr[i] != '0') return false;

        return true;
    }

    @Override
    public String toString() {
        return "Block{" +
            "blockNumber=" + blockNumber +
            ", header=" + header +
            ", headerHash='" + headerHash + '\'' +
            ", ledger=" + ledger +
            '}';
    }
}
