package com.company.network.p2p;

import com.company.Block;
import com.company.Ledger;
import com.company.Transaction;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Tester {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        NodeDatabase nodeDatabase = new NodeDatabase("Blockchain.txt");
        Ledger ledger = new Ledger();

        Transaction transaction1 = new Transaction(1, "Alice", "Bob",10);
        Transaction transaction2 = new Transaction(2, "Cathy", "Danny",20);
        Transaction transaction3 = new Transaction(3, "Ellen", "Felix", 30);

        ledger.addTransaction(transaction1);
        ledger.addTransaction(transaction2);
        ledger.addTransaction(transaction3);

        String prevHash = "c0535e4be2b79ffd93291305436bf889314e4a3faec05ecffcbb7df31ad9e51a";

        Block block = new Block(prevHash, "1", ledger);

        nodeDatabase.appendBlock(block);
        //nodeDatabase.readBlock(1);

    }
}
