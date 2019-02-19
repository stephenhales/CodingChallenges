package test.java.math;
import org.junit.Test;
import java.util.Arrays;
import static java.util.Arrays.asList;
import static main.java.math.PrimeFactors.factor;
import static org.junit.Assert.assertEquals;

/**
 * Created by stephenhales on 2/27/2017.
 */
public class PrimeFactorsTest {
    @Test
    public void emptyListIfNoPrimes(){
        assertEquals(asList(), factor(0));
    }

    @Test
    public void oneIsNotAPrime() throws Exception{
        assertEquals(asList(), factor(1));
    }

    @Test
    public void two() throws Exception{
        assertEquals(asList(2), factor(2));
    }

    @Test
    public void three() throws Exception{
        assertEquals(asList(3), factor(3));
    }

    @Test
    public void four() throws Exception{
        assertEquals(asList(2,2), factor(4));
    }

    @Test
    public void five() throws Exception{
        assertEquals(asList(5), factor(5));
    }

    @Test
    public void six() throws Exception{
        assertEquals(asList(2,3), factor(6));
    }

    @Test
    public void eight() throws Exception{
        assertEquals(asList(2,2,2), factor(8));
    }

    @Test
    public void nine() throws Exception{
        assertEquals(asList(3,3), factor(9));
    }

    @Test
    public void fortyNine() throws Exception{
        assertEquals(asList(7,7), factor(49));
    }
}
