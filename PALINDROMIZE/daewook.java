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
		if (input == null)
			return 0;
		
		int inputLength = input.length();
		int addLength = -1;
		
		for(int i = 0; i < inputLength; i++) {
			if(isPalindrome(input, i, inputLength - 1))
				addLength = i;
			
			if(addLength > -1)
				break;
		}
		
		return inputLength + addLength;
	}
	
	public static boolean isPalindrome(String input, int start, int end) {
		if(start >= end) return true;
		
		return input.charAt(start) == input.charAt(end)? 
				isPalindrome(input, start + 1, end - 1) : false;
	}
}
