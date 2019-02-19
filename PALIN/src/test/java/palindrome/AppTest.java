package palindrome;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AppTest{

    @Test
    public void oneIsPalin(){
        assertEquals(true, App.isPalin(1));
    }

    @Test
    public void elevenIsPalin(){
        assertEquals(true, App.isPalin(11));
    }

    @Test
    public void tenIsNotPalin(){
        assertEquals(false, App.isPalin(10));
    }

    @Test
    public void oneHundredOneIsPalin(){
        assertEquals(true, App.isPalin(101));
    }

    @Test
    public void largeNumberIsPalin(){
        assertEquals(true, App.isPalin(1010101));
    }

    @Test
    public void nextIs1(){
        assertEquals(101, App.findNextPalin(99));
    }

    @Test
    public void nextIs2(){
        assertEquals(818, App.findNextPalin(808));
    }

    @Test
    public void nextIs3(){
        assertEquals(2222, App.findNextPalin(2133));
    }
}
