package com.company;

import java.security.NoSuchAlgorithmException;

public class Transaction {

    private int ID;
    private String sender;
    private String receiver;
    private int amount;

    public Transaction(int ID, String sender, String receiver, int amount) {
        this.ID = ID;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String hash() throws NoSuchAlgorithmException {
        return Hasher.hash(this. toString());
    }
}
