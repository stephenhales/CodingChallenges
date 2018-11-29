
package Kata2;

public class Kata {

	public int getNextPalindrome(int number) throws Exception{
		int index = number;

		isUnderMillion(number);
		isNotNegative(number);

		while(!isPalindrome(++index)){ }
		return index;
	}

	private Boolean isPalindrome(int number){
		String digits = String.valueOf(number);
		String digitsReversed = new StringBuilder(digits).reverse().toString();
		return digits.equals(digitsReversed);
	}

	private static void isUnderMillion(int number) throws Exception{
		if(number >= 999999){
			throw new Exception("Number too large");
		}
	}

	private static void isNotNegative(int number) throws Exception{
		if(number < 0){
			throw new Exception("Number is negative");
		}
	}
}