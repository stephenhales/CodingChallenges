package countSubstring;

public class CountSubstring {

	public int getCount(String inputString) {
		if(inputString.length() > 1) {
			if(inputString.length() == countOnes(inputString) && inputString.length() > 2){
				return getFactorial(inputString.length());
			}
			return countOnes(inputString) + 1;
		}
		return countOnes(inputString);
	}

	private int countOnes(String inputString){
		return inputString.replace("0", "").length();
	}

	private int getFactorial(int number){
		int total = 0;
		for(int i = 0; i <= number; i++){
			total += i;
		}
		return total;
	}
}
