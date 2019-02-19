package test.java;

import static main.java.Marcha.findXinSubset;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by stephenhales on 2/27/2017.
 */
public class MarchaTest {
    @Test
    public void one(){
        List<Integer> subset = Arrays.asList(1);
        assertTrue(findXinSubset(1,subset));
    }

    @Test
    public void five(){
        List<Integer> subset = Arrays.asList(5);
        assertTrue(findXinSubset(5,subset));
    }

    @Test
    public void oneFive(){
        List<Integer> subset = Arrays.asList(1,5);
        assertTrue(findXinSubset(5,subset));
    }
    @Test
    public void six(){
        List<Integer> subset = Arrays.asList(1,5);
        assertTrue(findXinSubset(6,subset));
    }

    @Test
    public void thirtyOne(){
        List<Integer> subset = Arrays.asList(1,2, 5,10,20);
        assertTrue(findXinSubset(31,subset));
    }

    @Test
    public void multipleOnes(){
        List<Integer> subset = Arrays.asList(1,1,1,1,1);
        assertTrue(findXinSubset(1,subset));
    }

    @Test
    public void multipleOnesAdd(){
        List<Integer> subset = Arrays.asList(1,1,1,1,1);
        assertTrue(findXinSubset(5,subset));
    }
}
