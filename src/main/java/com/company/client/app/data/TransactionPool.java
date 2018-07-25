package com.company.client.app.data;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class TransactionPool {

    private static TransactionPool instance;

    private TransactionPool() {}

    public static synchronized TransactionPool getInstance() {
        if (instance == null) {
            instance = new TransactionPool();
        }

        return instance;
    }
}
