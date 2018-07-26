package com.company.client.app.core;

import com.company.client.app.data.TransactionPool;
import org.springframework.stereotype.Service;

@Service
public class BlockchainService {
    private TransactionPool transactionPool = TransactionPool.getInstance();
}
