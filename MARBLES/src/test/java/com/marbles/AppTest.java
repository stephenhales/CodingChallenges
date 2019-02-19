package com.marbles;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test for simple App.
 */

public class AppTest{
    @Test
    public void oneAndOneColorShouldReturnOne(){
        assertEquals(1, App.calculateNItemsKColors(1,1));
    }

    @Test
    public void twoAndOneColorShouldReturnOne(){
        assertEquals(1, App.calculateNItemsKColors(2,1));
    }

    @Test
    public void twoAndTwoColorShouldReturnOne(){
        assertEquals(1, App.calculateNItemsKColors(2,2));
    }

    @Test
    public void threeAndTwoColorShouldReturnTwo(){
        assertEquals(2, App.calculateNItemsKColors(3,2));
    }
    @Test
    public void FiveAndThreeColorShouldReturnThree(){
        assertEquals(6, App.calculateNItemsKColors(5,3));
    }
}
