package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {

    private static int blockCounter=0;
    private int blockNumber = 0;
    private String headerHash;
    private Ledger ledger;
    private int blockSize;



    public Block(){
        blockCounter++;
        blockNumber = blockCounter;
        System.out.println("Block number: "+this.blockNumber+" is created");
    }


//    private String hash() throws NoSuchAlgorithmException {
//        return Hasher.hash(new Integer(blockNumber)+prevHash+timestamp.toString()+
//                nonce+ledger.hash()+new Integer(blockSize));
//    }

}
