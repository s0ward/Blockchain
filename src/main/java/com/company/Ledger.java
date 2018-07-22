package com.company;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Ledger implements Serializable {

    private static final int LEDGER_SIZE = 100;

    private List<Transaction> transactions = new ArrayList<>();
    private int counter = 0;

    public void addTransaction(Transaction trans) {
        if (transactions.size() < LEDGER_SIZE) {
            this.transactions.add(trans);
        }
    }

    public String hash() throws NoSuchAlgorithmException {
        String hash = "";
        for (Transaction t : transactions) {
            hash = Hasher.hash(hash + t.hash());
        }
        return hash;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Transaction trans : transactions) {
            result.append(trans.toString()).append("\n");
        }
        return result.toString();
    }
}
