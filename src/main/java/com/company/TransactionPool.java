package com.company;

import java.util.ArrayList;

public class TransactionPool {

    private static ArrayList<Transaction> transactions;

    public Ledger getLedger() {
        return new Ledger();
    }

}
