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
		char[] result = new char[inputLength+1];
		
		for (int i = 0; i < inputLength; i++) {
			result[i / 2 + (i % 2) * (inputLength / 2)] = input.charAt(i);
		}
		
		return String.valueOf(result);
	}
}
