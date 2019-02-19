package com.twtclose;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

/**
 * Unit test for simple App.
 */

public class AppTest{

    @Test
    public void clickOne() {
        Integer[] shouldReturn = new Integer[] {1,0,0};
        Twitter page = new Twitter();
        page.click(1);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void clickTwo() {
        Integer[] shouldReturn = new Integer[] {0,1,0};
        Twitter page = new Twitter();
        page.click(2);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void clickThree() {
        Integer[] shouldReturn = new Integer[] {0,0,1};
        Twitter page = new Twitter();
        page.click(3);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void doubleClickOne() {
        Integer[] shouldReturn = new Integer[] {0,0,0};
        Twitter page = new Twitter();
        page.click(1);
        page.click(1);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void doubleClickTwo() {
        Integer[] shouldReturn = new Integer[] {0,0,0};
        Twitter page = new Twitter();
        page.click(2);
        page.click(2);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void doubleClickThree() {
        Integer[] shouldReturn = new Integer[] {0,0,0};
        Twitter page = new Twitter();
        page.click(3);
        page.click(3);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void runCodeChefScenario() {
        Integer[] shouldReturn = new Integer[] {1,0,0};
        Twitter page = new Twitter();
        page.click(1);
        page.click(2);
        page.click(3);
        page.click(2);
        page.closeAll();
        page.click(1);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void runCodeChefScenarioTwo() {
        Integer[] shouldReturn = new Integer[] {0,0,1};
        Twitter page = new Twitter();
        page.click(1);
        page.click(2);
        page.click(3);
        page.click(2);
        page.click(1);
        assertArrayEquals(shouldReturn, page.states);
        page.display();
    }

    @Test
    public void countOne() {
        Integer[] shouldReturn = new Integer[] {1,0,0};
        Twitter page = new Twitter();
        page.click(1);
        assertArrayEquals(shouldReturn, page.states);
        assertEquals(1, page.count());
        page.display();
    }

    @Test
    public void countTwo() {
        Integer[] shouldReturn = new Integer[] {1,1,0};
        Twitter page = new Twitter();
        page.click(1);
        page.click(2);
        assertArrayEquals(shouldReturn, page.states);
        assertEquals(2, page.count());
        page.display();
    }

    @Test
    public void countThree() {
        Integer[] shouldReturn = new Integer[] {1,1,1};
        Twitter page = new Twitter();
        page.click(1);
        page.click(2);
        page.click(3);
        assertArrayEquals(shouldReturn, page.states);
        assertEquals(3, page.count());
        page.display();
    }
}
