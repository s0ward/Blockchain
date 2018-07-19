package com.company;

import java.security.NoSuchAlgorithmException;

public class Ledger {

    private static final int LEDGER_SIZE = 100;
    private Transaction[] transactions = new Transaction[LEDGER_SIZE];
    private int counter = 0;

    public void addTransaction(Transaction trans) throws Exception {
        if (counter < LEDGER_SIZE) {
            transactions[counter] = trans;
            counter++;
        }
        else throw new Exception("Ledger is already full");
    }

    public String hash() throws NoSuchAlgorithmException {
        String hash = "";
        for (Transaction t : transactions) {
            hash = Hasher.hash(hash + t.hash());
        }
        return hash;
    }

    public String toString(){
        String result = "";
        for(Transaction trans: transactions){
            result += trans.toString()+"\n";
        }
        return result;
    }
}
