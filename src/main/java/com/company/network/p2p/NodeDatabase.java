package com.company.network.p2p;

import com.company.Block;
import com.company.BlockHeader;
import com.company.Ledger;

import java.io.*;
import java.util.Date;

public class NodeDatabase {
    private String source;


    public NodeDatabase(String source) {
        this.source = source;
    }

//    public void appendBlock(Block block){
//
//        try {
//            FileOutputStream fileOut =
//                new FileOutputStream(source);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(block);
//            out.close();
//            fileOut.close();
//            System.out.printf("Serialized data is saved in "+source);
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
//    }

    public void appendBlock(Block block) throws IOException {

            String str = block.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Blockchain.txt", true));
            writer.append("\n");
            writer.append(str);
            writer.close();

    }

    public void readBlock(int blockID) throws IOException {

        int blockNumber = blockID;
        BlockHeader header = null;
        String prevHash = null;
        String nonce = null;
        String ledgerHash = null;it 
        Date timestamp = null;
        String headerHash = null;
        Ledger ledger = null;


        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader("Blockchain.txt"));


        String line = null;
        while ((line = reader.readLine()) != null){
            String[] lineSplit = line.split("\\s+");
            for(String s: lineSplit)
            {
                if(Integer.parseInt(lineSplit[0]) == blockID){

                    header = new BlockHeader(lineSplit[1],lineSplit[2],lineSplit[3],"hey");
                }
            }
        }

    }

//    public Block getLastBlock(){
//    }

}
