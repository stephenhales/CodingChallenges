package test.java;

import main.java.Coins;
import main.java.Compare;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by stephenhales on 3/1/2017.
 */


public class CoinsTest {

    @Test
    public void one(){
        assertEquals(0, Coins.exchangeMoney(1));
    }

    @Test
    public void two(){
        assertEquals(1, Coins.exchangeMoney(2));
    }

    @Test
    public void four(){
        assertEquals(4, Coins.exchangeMoney(4));
    }

    @Test
    public void twelve(){
        assertEquals(13, Coins.exchangeMoney(12));
    }

    @Test
    public void twentyOne(){
        assertEquals(22, Coins.exchangeMoney(21));
    }

    @Test
    public void eleven(){
        assertEquals(10, Coins.exchangeMoney(11));
    }

    @Test
    public void compareEleven(){
        assertEquals(11, Compare.returnsTheGreatest(11));
    }

    @Test
    public void compareTwentyFour(){
        assertEquals(27, Compare.returnsTheGreatest(24));
    }

    @Test
    public void compareThirtySix(){
        assertEquals(41, Compare.returnsTheGreatest(36));
    }

    @Test
    public void twentyEight(){
        assertEquals(30, Compare.returnsTheGreatest(28));
    }

    @Test
    public void fortySix(){
        assertEquals(49, Compare.returnsTheGreatest(46));
    }

    @Test
    public void fortyNine(){
        assertEquals(57, Compare.returnsTheGreatest(49));
    }

    @Test
    public void compareCurious(){
        for(int i = 1; i<100; i++){
            Compare.returnsTheGreatest(i);
        }
    }
}
