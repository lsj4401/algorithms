public class Solution {
    public int rs[];
    public int climbStairs(int n) {
        rs = new int[n];
        if (n < 2)
            return 1;
        rs[0] = 1;
        rs[1] = 2;
        
        for (int i = 2; i < n; i++) {
            rs[i] = rs[i-1] + rs[i-2];
        }
        
        return rs[n-1];
    }
    
    // public int climb(int n) {
    //     if (n<3) return rs[n] = n;
    //     return rs[n] = climb(n-1) + climb(n-2);
    // }
}
