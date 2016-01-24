public class Solution {
    public int titleToNumber(String s) {
      int result = 0;
      int strLen = s.length();

    	for (int i =0; i<strLen; i++) {
    		result += Math.pow(26, strLen - i - 1) * (s.charAt(i) - 'A' + 1);
    	}

    	return result;
    }
}
