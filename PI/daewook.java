import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		String input = new String();
		
		for (int i = 0; i < testCase; i++) {
			input = s.next();
			System.out.println(init(input));
		}
		s.close();		
	}
	
	public static int[] cache;
	
	public static int init(String input) {
		cache = new int[10001];
		Arrays.fill(cache, -1);
		return getMinGrade(input, 0);
	}	
	
	public static int getMinGrade (String input, int index) {
		int blockSize = 3;
		int blockGrade = 0;
		int len = input.length();
		int minGrade = Integer.MAX_VALUE;
		
		if (len < 6 && len > 2) {
			blockGrade += getBlockGrade(input, index);
			cache[index] = blockGrade;
			return blockGrade;
		}

		while (len - blockSize > 2 && blockSize < 6) {
			if(cache[index + blockSize] == -1) {				
				blockGrade = getBlockGrade(input.substring(0, blockSize), index);				
				blockGrade += getMinGrade(input.substring(blockSize, len), index + blockSize);
			} else {
				blockGrade += cache[index + blockSize];
			}
			
			minGrade = Math.min(minGrade, blockGrade);
			cache[index] = minGrade;
			blockSize++;			
			
		}		
		
		return minGrade;
	}
	
	public static int getBlockGrade (String input, int index) {		
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
