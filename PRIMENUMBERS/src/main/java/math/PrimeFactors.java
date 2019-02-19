package main.java.math;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by stephenhales on 2/27/2017.
 */
public class PrimeFactors {

    public static List<Integer> factor(int n) {
        List<Integer> primes = new ArrayList<>();
        int m = 2;
        while( n>1) {
            while (n % m == 0) {
                primes.add(m);
                n /= m;
            }
            m++;
        }

        return primes;
    }
}
