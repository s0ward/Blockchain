package com.company.client.app.data;

import com.company.BlockHeader;
import com.company.Ledger;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public class Block implements Serializable {

    private static final int DIFFICULTY = 6;
    private static int blockCounter = 0;
    private int blockNumber = 0;
    private BlockHeader header;
    private String blockHash;
    private Ledger ledger;
    //private int blockSize;


    public Block(String prevHash, String nonce, Ledger ledger) throws NoSuchAlgorithmException {
        blockCounter++;
        blockNumber = blockCounter;
        this.header = new BlockHeader(prevHash, nonce, ledger.hash());
        this.ledger = ledger;
        System.out.println("Block number: " + this.blockNumber + " is created");
    }

    public void setNonce(String nonce) {
        this.header.setNonce(nonce);
    }

    public String getHeaderHash() {
        return this.header.hash();
    }

    public boolean isValid() {

        char[] arr = headerHash.toCharArray();

        for (int i = 0; i < DIFFICULTY; i++) {
            if (arr[i] != '0') {
                return false;
            }
        }

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
