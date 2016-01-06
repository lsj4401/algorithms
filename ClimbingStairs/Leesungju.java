public class Solution {
    int[] dp;
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n < 0) return 0;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return s(n);
    }
    
    private int s(int n) {
        if (dp[n] != -1) return dp[n];
        dp[n] = s(n -1) + s(n -2);
        
        return dp[n];
    }
}
