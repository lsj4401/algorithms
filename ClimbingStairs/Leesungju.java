public class Solution {
  int[] dp;
  public int climbStairs(int n) {
    if (n < 0) return 0;
    dp = new int[Math.max(n + 1, 3)];
    dp[1] = 1; 
    dp[2] = 2;
    return s(n);
  }
  
  private int s(int n) {
    if (dp[n] != 0) return dp[n];
    return dp[n] = s(n - 1) + s(n - 2);
  }
}
