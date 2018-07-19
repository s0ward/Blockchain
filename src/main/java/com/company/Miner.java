package com.company;

public class Miner {

    private static final int DIFFICULTY = 2;
    

    private boolean isValid(String hash){
        char[] arr = hash.toCharArray();

        for(int i=0; i<DIFFICULTY; i++){
            if(arr[i] != '0') return false;
        }

        return true;
    }
}
