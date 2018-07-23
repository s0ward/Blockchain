package com.company;

import com.company.network.p2p.Node;

public class App {

    public static void main(String[] args) throws Exception {

//
//                Transaction trans1 = new Transaction(1,"me","you", 123);
//                Transaction trans2 = new Transaction(2,"me","you", 123);
//
//
//                Ledger ledg = new Ledger();
//                ledg.addTransaction(trans1);
//                ledg.addTransaction(trans2);
//
//                System.out.println(ledg.hash());

//        Block block1 = new Block();
//        Block block2 = new Block();
//        Block block3 = new Block();
        Node node = new Node();
        System.out.println(node.getInetAddr());


    }
}
