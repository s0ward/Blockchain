package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class BlockHeader {

    private String prevHash;
    private Date timestamp;
    private String nonce;
    private String ledgerHash;

    public BlockHeader(String prevHash, String nonce, String ledgerHash) {
        this.prevHash = prevHash;
        this.nonce = nonce;
        this.ledgerHash = ledgerHash;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {

        return "BlockHeader{" +
            "prevHash='" + prevHash + '\'' +
            ", timestamp=" + timestamp +
            ", nonce='" + nonce + '\'' +
            ", ledgerHash='" + ledgerHash + '\'' +
            '}';
    }

    public String hash() throws NoSuchAlgorithmException {
        return Hasher.hash(this.toString());
    }
}
