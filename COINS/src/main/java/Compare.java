package main.java;

/**
 * Created by stephenhales on 3/1/2017.
 */
public class Compare {
    public static int returnsTheGreatest(int amount){
        System.out.print(amount);
        if( amount < Coins.exchangeMoney(amount)){
            amount = Coins.exchangeMoney(amount);
            System.out.println(" Echange: " + amount);
        }
        else{
            System.out.println(" Direct: " + amount);
        }
        return amount;
    }
}
