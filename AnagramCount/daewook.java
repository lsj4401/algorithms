public static int countAnagram(String s1, String s2) {
	int result = 0;
	int diff = 0;
	int tmp = 0;
	
	int anagramLength = s2.length();
	
	for (int i = 0; i < anagramLength; i++) {
		tmp ^= s1.charAt(i);
		diff ^= s2.charAt(i);
	}
	
	if ((tmp ^ diff) == 0)
		result++;
	
	for (int i = anagramLength; i < s1.length(); i++) {
		tmp = tmp ^ s1.charAt(i - anagramLength) ^ s1.charAt(i);
		if ((tmp ^ diff) == 0)
			result++;
	}
	
	return result;