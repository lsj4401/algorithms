import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			String input = s.next();			
			System.out.println(getEncryptedString(input));
		}
	}	
	
	public static String getEncryptedString(String input) {
		int inputLength = input.length();
		char[] result = new char[inputLength];
		int currentIndex = 0;
		
		for (int i = 0; i < inputLength; i = i + 2) {			
			result[currentIndex++] = input.charAt(i);
		}
		
		for (int i = 1; i < inputLength; i = i + 2) {			
			result[currentIndex++] = input.charAt(i);
		}
		
		return String.valueOf(result);
	}
}
