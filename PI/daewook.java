package test;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static int[] grade3;
	public static int[] grade4;
	public static int[] grade5;

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int testCase = s.nextInt();
//		String input = new String();
//		
//		for (int i = 0; i < testCase; i++) {
//			input = s.next();			
//			System.out.println(init(input));
//		}
//		s.close();
		
		try {
			Scanner s = new Scanner(new File("c:\\dev\\input2.txt"));
			
			int testCase = s.nextInt();
			String input = new String();
			
			for (int i = 0; i < testCase; i++) {
				input = s.next();
				System.out.println(init(input));
			}
			
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int init(String input) {
		grade3 = new int[input.length()];
		grade4 = new int[input.length()];
		grade5 = new int[input.length()];
		
		return getMinGrade(input, 0);
	}
	
	public static int getMinGrade (String input, int index) {		
		int blockSize = 3;
		int blockGrade = 0;
		int minGrade = Integer.MAX_VALUE;
		int len = input.length();
		
		if (len < 6 && len > 2) {
			blockGrade += getBlockGrade(input, index);
//			System.out.println("final block's grade : " + blockGrade );
			return blockGrade;
		}

		while (len - blockSize > 2 && blockSize < 6) {
			blockGrade = 0;
//			blockGrade += getBlockGrade(Arrays.copyOf(input, blockSize));
//			blockGrade += getMinGrade(Arrays.copyOfRange(input, blockSize, len));
			blockGrade += getBlockGrade(input.substring(0, blockSize), index);
			blockGrade += getMinGrade(input.substring(blockSize, len), index + blockSize);
			
			minGrade = Math.min(minGrade, blockGrade);
			blockSize++;
		}
		
		return minGrade;
	}
	
	public static int getBlockGrade (String input, int index) {
		Integer cachedGrade = null;
		cachedGrade = getCachedGrade(input.length(), index);
		
		if (cachedGrade != null)
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
	
	public static Integer getCachedGrade(int blockSize, int index) {
		Integer cachedGrade = null;
		
		if (blockSize == 3)
			cachedGrade = grade3[index];
		else if (blockSize == 4)
			cachedGrade = grade4[index];
		else if (blockSize == 5)
			cachedGrade = grade5[index];
		
		if (cachedGrade == 0)
			cachedGrade = null;
		
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
