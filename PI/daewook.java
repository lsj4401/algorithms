import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int testCase = s.nextInt();
//		String input = new String();
//		
//		for (int i = 0; i < testCase; i++) {
//			input = s.next();			
//			char[] inputArr = input.toCharArray();
//			System.out.println(getMinGrade(inputArr));
//		}
//		s.close();
		
		try {
			Scanner s = new Scanner(new File("c:\\dev\\input2.txt"));
			
			int testCase = s.nextInt();
			String input = new String();
			
			for (int i = 0; i < testCase; i++) {
				input = s.next();
				System.out.println(getMinGrade(input));
			}
			
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getMinGrade (String input) {		
		int blockSize = 3;
		int blockGrade = 0;
		int minGrade = Integer.MAX_VALUE;
		int len = input.length();
		
		if (len < 6 && len > 2) {
			blockGrade += getBlockGrade(input);
//			System.out.println("final block's grade : " + blockGrade );
			return blockGrade;
		}

		while (len - blockSize > 2 && blockSize < 6) {
			blockGrade = 0;
//			blockGrade += getBlockGrade(Arrays.copyOf(input, blockSize));
//			blockGrade += getMinGrade(Arrays.copyOfRange(input, blockSize, len));
			blockGrade += getBlockGrade(input.substring(0, blockSize));
			blockGrade += getMinGrade(input.substring(blockSize, len));
			
			minGrade = Math.min(minGrade, blockGrade);
			blockSize++;
		}
		
		return minGrade;
	}
	
	public static int getBlockGrade (String input) {
		int subtract = input.charAt(1) - input.charAt(0);
		int resultGrade = -1;
		int prevGrade = -1;
		int tmpSubtract = 0;
		
		for (int i = 2; i < input.length(); i ++) {
			prevGrade = resultGrade;
			if (prevGrade != 10) {
				tmpSubtract = input.charAt(i) - input.charAt(i-1);
				if (subtract == tmpSubtract) {
					if (tmpSubtract == 0)
						resultGrade = 1;
					else if (Math.abs(tmpSubtract) == 1)
						resultGrade = 2;
					else
						resultGrade = 5;
				} else {
					if (tmpSubtract != 0 && subtract / tmpSubtract == -1)
						resultGrade = 4;
					else
						resultGrade = 10;
				}
				subtract = tmpSubtract;
			}
			
			if (prevGrade != -1 && prevGrade != resultGrade)
				resultGrade = 10;
		}
		return resultGrade;
	}
}
