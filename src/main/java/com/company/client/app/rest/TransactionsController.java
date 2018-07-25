package com.company.client.app.rest;

import com.company.Transaction;
import com.company.client.app.core.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionsController {

    @Autowired
    private BlockchainService blockchainService;


    @PostMapping
    public ResponseEntity<Transaction> postTransaction(@RequestBody Transaction transaction) {

    }
}
