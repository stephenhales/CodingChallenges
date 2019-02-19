package com.marbles;

public class App
{
    public static int calculateNItemsKColors(int n, int k){
        if(k == 1 || k == n) {
            return 1;
        }
        else{
            return n-1;
        }
    }
}
