package numberOfAnagram;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println(numberOfAnagram("mississippi", "issi"));
	}
	
	public static int numberOfAnagram(String orgStr, String anagram) {
		int result = 0;
		
		String[] suffixArray = convertToSuffixArray(orgStr);
		Arrays.sort(suffixArray);
		
		for (String suffix : suffixArray) {
			if(suffix.length() >= anagram.length() && include(suffix, anagram))
				result++;
		}
		
		return result;
	}
	
	private static String[] convertToSuffixArray(String str)	 {
		String[] suffixArray = new String[str.length()];
		
		for (int i = 0; i < suffixArray.length; i++) {
			suffixArray[i] = str.substring(i);
		}		
		
		return suffixArray;
	}
	
	private static boolean include(String suffix, String anagram){
		boolean result = true;
		
		for (int i = 0; i < anagram.length(); i++) {
			if (anagram.charAt(i) != suffix.charAt(i))
				return false;
		}
		
		return result;
	}
}

