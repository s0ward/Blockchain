package com.company;

import java.security.NoSuchAlgorithmException;

public class Ledger {

    private static final int LEDGER_SIZE = 100;
    private Transaction[] transactions = new Transaction[LEDGER_SIZE];
    private int counter = 0;

    public void addTransaction(Transaction trans) {
        if (counter < LEDGER_SIZE) {
            transactions[counter] = trans;
            counter++;
        }
    }

    public String hash() throws NoSuchAlgorithmException {
        String hash = "";
        for (Transaction t : transactions) {
            hash = Hasher.hash(hash + t.hash());
        }
        return hash;
    }
}
