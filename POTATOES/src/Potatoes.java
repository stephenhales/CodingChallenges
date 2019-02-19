/**
 * Created by shales on 2/21/2017.
 */
public class Potatoes {
    public static int getPrime(Integer[] numbers){
        int total = 0;
        int prime = 2;

        for (int number : numbers) {
            total += number;
        }
        System.out.println("total: " + total);
        prime = getNextPrime(total);
        return prime;
    }
    public static int getNextPrime(int total){
        int prime;
        if(total%2 == 1){
            total += 1;
        }
        for(int i  = total+1; i < 1000 ; i+=2){
            if(isPrime(i)){
                return i;
            }
        }
        return 0;
    }
    public static boolean isPrime(int result){
        for(int i = 2; i <= result/2; i++ ) {
            System.out.println(" i: " + i + " result: " + result);
            if (result % i == 0) {
                System.out.println("failed, not prime");
                return false;
            }
        }
        System.out.println(result + " is prime!");
        return true;
    }
}
