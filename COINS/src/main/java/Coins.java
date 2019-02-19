package main.java;

import static java.lang.Math.round;

/**
 * Created by stephenhales on 3/1/2017.
 */

public class Coins {
    public static int exchangeMoney(int amount){
        int two;
        int three;
        int four;

        two = splitByTwo(amount);
        if(two > 11){ two = exchangeMoney(two);}
        three = splitByThree(amount);
        if(three > 11) {three = exchangeMoney(three);}
        four = splitByFour(amount);
        if(four > 11){four = exchangeMoney(four);}
        int newAmount = two+three+four;
        return newAmount;
    }

    public static int splitByTwo(int amount){
        return round(amount/2);
    }

    public static int splitByThree(int amount){
        return round(amount/3);
    }

    public static int splitByFour(int amount){
        return round(amount/4);
    }
}
