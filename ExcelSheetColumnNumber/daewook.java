public class Solution {
    public int titleToNumber(String s) {
      int result = 0;

    	for (int i =0; i<s.length(); i++) {
    		result += Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 'A' + 1); 
    	}

    	return result;
    }
}
