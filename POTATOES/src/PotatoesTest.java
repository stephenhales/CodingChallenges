/**
 * Created by shales on 2/21/2017.
 */

import org.junit.Test;

public class PotatoesTest {
    @Test
    public void testIsPrime(){
        boolean isPrime = true;
        Integer[] numbers  = {720,74};
        Potatoes potate = new Potatoes();
        int result = potate.getPrime(numbers);

        if(result == 2){
            isPrime = false;
            assert(isPrime);
        }
        if(result%2 == 0){
            isPrime = false;
            assert(isPrime);
        }
        for(int i = 3; i <= result/2; i+=2 ) {
            System.out.println(" test: " + i + " result: " + result);
            if (result % i == 0) {
                System.out.println("failed, not prime");
                isPrime = false;
                assert(isPrime);
            }
        }
        System.out.println(result + " is prime!");
        assert(isPrime);
    }
}
