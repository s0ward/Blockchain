package com.company.client.app.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ledger implements Serializable, Hashable {

    private static final int LEDGER_SIZE = 100;

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction trans) {
        if (transactions.size() < LEDGER_SIZE) {
            this.transactions.add(trans);
        }
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Transaction t : transactions) {
            result.append(t.toString()).append("\n");
        }

        return result.toString();
    }
}