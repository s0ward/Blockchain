package com.company.client.app.data;

import com.company.client.app.util.Hasher;

import java.io.Serializable;
import java.util.Date;

public class BlockHeader implements Serializable {

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

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    private String getHash() {
        return Hasher.hash(this.toString());
    }
}
