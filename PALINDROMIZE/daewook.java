import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			String input = s.next();			
			System.out.println(getLengthOfPalindrome(input));
		}
	}	
	
	public static int getLengthOfPalindrome(String input) {
		int inputLength = input.length();
		int duplicatedIndex = 0;
		
		for(int i = 0; i < inputLength; i++) {
			if (input.charAt(i) == input.charAt(inputLength - duplicatedIndex - 1))
				duplicatedIndex++;
			else
				duplicatedIndex = 0;
		}
		
		return 2 * inputLength - duplicatedIndex;
	}
}
