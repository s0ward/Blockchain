package com.company.client.app.data;

import java.util.ArrayList;
import java.util.List;

public class TransactionPool {

    private static TransactionPool instance;
    private List<Transaction> transactions = new ArrayList<>();

    private TransactionPool() {}

    public static synchronized TransactionPool getInstance() {
        if (instance == null) {
            instance = new TransactionPool();
        }

        return instance;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
