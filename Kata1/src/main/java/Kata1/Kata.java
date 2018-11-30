
package Kata1;

import java.util.List;
import java.util.stream.Collectors;

public class Kata {

	public List<Integer> getPrimeNumbers(List<Integer> numbers){
		return numbers.stream()
			.filter(number -> isPrime(number))
			.collect(Collectors.toList());
	}

	private boolean isPrime(Integer number){
		int max = number/2;

		for(int i = 2; i <= max; i++ ){
			if(number%i == 0){
				if(number == i){
					return true;
				}
				return false;
			}
		}
		if(number == 0){
			return false;
		}
		if(number == 1){
			return false;
		}
		return true;
	}
}