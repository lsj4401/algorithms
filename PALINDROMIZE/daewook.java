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
		int diff = 0;
		int duplicatedLenth = 1;
		
		for (int i = 0; i < inputLength; i++) {
			diff ^= (input.charAt(inputLength - i - 1) - 'a' + 1); 
			
			if(input.charAt(inputLength - 1) ==
					input.charAt(inputLength - i - 1)) {
				if((i % 2 == 0 && diff == input.charAt(inputLength - i / 2 - 1) - 'a' + 1 ) ||
						(i % 2 != 0 && diff == 0)) {
					duplicatedLenth = i + 1;
				}
			}
		}
		
		return inputLength + (inputLength - duplicatedLenth);
	}
}
