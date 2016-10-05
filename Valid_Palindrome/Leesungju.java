public class Solution {
    public boolean isPalindrome(String s) {
        int foward = 0;
        int back = s.length() - 1; 
        while (foward < back) {
            if (!isAlphNum(s.charAt(foward))) {
                foward += 1;
            }
            
            if (!isAlphNum(s.charAt(back))) {
                back -= 1;
            }
            
            if (isAlphNum(s.charAt(foward)) && isAlphNum(s.charAt(back))) {
                if (Character.toLowerCase(s.charAt(foward)) != Character.toLowerCase(s.charAt(back))) return false;
                foward += 1;
                back -= 1;
            }
        }
        
        return true;
    }
    
    private boolean isAlphNum(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch); 
    }
}
