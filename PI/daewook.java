package algospot.pi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		String input = new String();
		
		for (int i = 0; i < testCase; i++) {
			input = s.next();
			init(input);
			System.out.println(result);
		}
		s.close();
		
//		try {
//			Scanner s = new Scanner(new File("c:\\dev\\input2.txt"));
//			
//			int testCase = s.nextInt();
//			String input = new String();
//			
//			for (int i = 0; i < testCase; i++) {
//				input = s.next();
//				init(input);
//				System.out.println(result);
//			}
//			
//			s.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
	}
	
	public static int[] grade3;
	public static int[] grade4;
	public static int[] grade5;
	public static int result ;
	
	public static void init(String input) {
		grade3 = new int[input.length()];
		grade4 = new int[input.length()];
		grade5 = new int[input.length()];
		
		result = Integer.MAX_VALUE;
		
		getMinGrade(input, 0, 0);
	}
	
	
	public static void getMinGrade (String input, int index, int prevSum) {
		int blockSize = 3;
		int blockGrade = 0;
		int len = input.length();
		
//		System.out.println("input length " + len + ", " + prevSum);
		
		if (len < 6 && len > 2) {
			blockGrade += getBlockGrade(input, index);			
			result = Math.min(result, prevSum + blockGrade);
//			System.out.println("result " + result);
			
			return;
		}

		while (len - blockSize > 2 && blockSize < 6) {
//			System.out.println();
//			System.out.println("block size " + blockSize);
			blockGrade = getBlockGrade(input.substring(0, blockSize), index);
//			System.out.println(blockGrade);
			getMinGrade(input.substring(blockSize, len), index + blockSize, prevSum + blockGrade);
			blockSize++;
		}		
	}
	
	public static int getBlockGrade (String input, int index) {
		
		Integer cachedGrade = null;
		cachedGrade = getCachedGrade(input.length(), index);
		
		if (cachedGrade != null && cachedGrade != 0)
			return cachedGrade;
		
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
		
		setGradeCache(resultGrade, input.length(), index);
		
		return resultGrade;
	}
	
	public static  int getCachedGrade(int blockSize, int index) {
		Integer cachedGrade = null;
		
		if (blockSize == 3)
			cachedGrade = grade3[index];
		else if (blockSize == 4)
			cachedGrade = grade4[index];
		else if (blockSize == 5)
			cachedGrade = grade5[index];
		
		return cachedGrade;
	}
	
	public static void setGradeCache(int grade, int blockSize, int index) {
		switch(blockSize) {
		case 3:
			grade3[index] = grade;
			break;
		case 4:
			grade4[index] = grade;
			break;
		case 5:
			grade5[index] = grade;
			break;			
		}		
	}
}
