package com.twtclose;

import java.util.Arrays;

/**
 * Created by stephenhales on 3/8/2017.
 */
public class Twitter {
    public Integer[] states = new Integer[] {0,0,0};

    public void click(int position){
        position--;
        if(states[position] == 0 ){
            states[position] = 1;
        }
        else{
            states[position] = 0;
        }
    }
    public void closeAll(){
        Integer[] closeAll = new Integer[] {0,0,0};
        states = closeAll;
    }

    public int count(){
        int total = 0;
        for(int item: states) {
            total += item;
        }
        return total;
    }


    public void display(){
        int count = count();
        System.out.println(Arrays.toString(states) + "    Count: " + count );
    }
}
