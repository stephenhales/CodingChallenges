package Anagram;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main( String[] args )  {
        boolean isPalindrome = false;
        boolean isAnagram = false;

        //get user input
        System.out.println("Enter a word: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        //determine if it is a palindrome
        isPalindrome = checkPalindrome(word);
        isAnagram = checkAnagrams(word);
        if(isPalindrome){
            System.out.println(word + " is a palindrome");
        }
        else if(isAnagram){
            System.out.println(word + " is an anagram");
        }
        else{
            System.out.println(word + " is an NOT an anagram and is NOT a palindrome ");
        }
    }

    public static Boolean checkPalindrome(String word){

        String reversedWord = new StringBuilder(word).reverse().toString();

        if(word.equals(reversedWord)) {
            return true;
        }
        return false;
    }

   public static Boolean checkAnagrams(String word){
        return false;
    }
}
