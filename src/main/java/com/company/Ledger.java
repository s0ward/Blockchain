package com.company;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Ledger implements Serializable {

    private static final int LEDGER_SIZE = 100;
    //    private Transaction[] transactions = new Transaction[LEDGER_SIZE];
    private List<Transaction> transactions = new ArrayList<>();
    private int counter = 0;

    public void addTransaction(Transaction trans) throws Exception {
//        if (counter < LEDGER_SIZE) {
//            transactions[counter] = trans;
//            counter++;
//        }
//        else throw new Exception("Ledger is already full");
        this.transactions.add(trans);
    }

    public String hash() throws NoSuchAlgorithmException {
        String hash = "";
        for (Transaction t : transactions) {
            hash = Hasher.hash(hash + t.hash());
        }
        return hash;
    }

    public String toString() {
        String result = "";
        for (Transaction trans : transactions) {
            result += trans.toString() + "\n";
        }
        return result;
    }
}
