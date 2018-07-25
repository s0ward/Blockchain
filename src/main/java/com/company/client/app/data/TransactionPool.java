package com.company.client.app.data;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class TransactionPool {

    private List<Transaction> transactions;

    public TransactionPool() {}

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
