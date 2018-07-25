package com.company.client.app.data;

import javax.persistence.Entity;

@Entity
public class Transaction {

    private int id;
    private String sender; // TODO: Sender class
    private String receiver; // TODO: Receiver class
    private int amount; // TODO: BigDecimal class
    private int selfHash;

    private static int currentId = 0;

    public Transaction() {
        this.id = -1;
    }

    public Transaction(String sender, String receiver, int amount) {
        this.id = currentId++;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public int getAmount() {
        return amount;
    }

    public int getSelfHash() {
        return selfHash;
    }
}
