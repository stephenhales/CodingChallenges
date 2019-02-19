package main.java;

import java.util.Collections;
import java.util.List;

/**
 * Created by stephenhales on 2/27/2017.
 */
public class Marcha {
    public static boolean findXinSubset(int x, List<Integer> subset){
        Collections.sort(subset);
        boolean canPay = false;
        System.out.print("find:" + x + " subset:");
        canPay = recursiveFindX(x, subset.size()-1, canPay,subset);
        System.out.println("");
        return canPay;
    }
    public static boolean recursiveFindX(int x, int i, boolean canPay, List<Integer> subset){
        if(x == 0){
            return true;
        }
        if (x >= subset.get(i)) {
            System.out.print(subset.get(i) + " ");
            x-=subset.get(i);
            canPay = recursiveFindX(x,i--, canPay, subset);
        }
        else{
            i--;
            if(i >= 0) {
                canPay = recursiveFindX(x, i, canPay, subset);
            }
        }

        return canPay;
    }
}
