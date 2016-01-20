public class Solution {
    public int titleToNumber(String s) {
        char[] input = s.toCharArray();
        
        int size = input.length - 1;
        int result = 0;
        for (int i = size; i > -1; i--) {
            int num = input[size - i] - 'A' + 1;
            result += (Math.pow(26, i) * num);
        }
        return result;
    }
}
