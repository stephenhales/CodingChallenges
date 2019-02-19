package palindrome;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static int findNextPalin(int n){
        int i = n+1;
        while(isPalin(i) == false){
            i++;
        }
        return i;
    }

    public static boolean isPalin(int n){
        List<Integer> number = splitUpNumber(n);
        for(int i = 0; i < number.size(); i++){
            if(number.get(i) != number.get(number.size() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> splitUpNumber(int n){
        List<Integer> number = new ArrayList<Integer>();
        int x = n;
        int i = 0;
        while( x >= 1 ){
            number.add(x % 10);
            i++;
            x /= 10;
        }
        return number;
    }
}
