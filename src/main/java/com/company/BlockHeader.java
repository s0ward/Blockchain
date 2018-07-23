package com.company;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockHeader implements Serializable {

    private String prevHash;
    private String timestamp;
    private String nonce;
    private String ledgerHash;

    public BlockHeader(String prevHash, String nonce, String ledgerHash) {
        this.prevHash = prevHash;
        this.nonce = nonce;
        this.ledgerHash = ledgerHash;
        this.timestamp = new SimpleDateFormat("HH:mm:ss/dd.MM.yyyy").format(new Date());
    }

    public BlockHeader(String prevHash, String nonce, String ledgerHash, String timestamp) {
        this.prevHash = prevHash;
        this.nonce = nonce;
        this.ledgerHash = ledgerHash;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return prevHash + " " + timestamp + " " + nonce + " " + ledgerHash;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String hash() throws NoSuchAlgorithmException {
        return Hasher.hash(this.toString());
    }
}
