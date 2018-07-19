package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {

    private static int blockCounter=0;
    private int blockNumber = 0;
    private BlockHeader header;
    private String headerHash;
    private Ledger ledger;
    private int blockSize;


    public Block(BlockHeader header, Ledger ledger) throws NoSuchAlgorithmException {
        blockCounter++;
        blockNumber = blockCounter;
        this.header = header;
        this.ledger = ledger;
        this.headerHash = header.hash();
        System.out.println("Block number: "+this.blockNumber+" is created");
    }

    public int getBlockNumber(){
        return this.blockNumber;
    }

    private String hash() throws NoSuchAlgorithmException {
        return Hasher.hash(this.toString());
    }

}
