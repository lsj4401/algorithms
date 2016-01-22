public class Solution {
    public boolean isPowerOfThree(int n) {
        boolean result = true;
        int input = n;

        if (input <= 0)
            return false;

        if (input == 1)
            return result;

        if(n % 3 == 0) {
            input = n;
            while (input > 1) {
                if(input % 3 == 0)
                    input = input / 3;
                else
                    return false;
            }
        } else {
            return false;
        }

        return true;
    }
}
