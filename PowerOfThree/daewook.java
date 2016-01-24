public class Solution {
    public boolean isPowerOfThree(int n) {
        boolean result = true;

        if (n <= 0)
            return false;

        if (n == 1)
            return result;

        while (n > 1) {
            if(n % 3 == 0)
                n = n / 3;
            else
                return false;
        }

        return true;
    }
}
