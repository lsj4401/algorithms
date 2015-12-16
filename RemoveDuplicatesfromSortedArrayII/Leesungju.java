public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int tLength = 1;
        int lLength = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                lLength++;
            } else {
                prev = nums[i];
                tLength += Math.min(2, lLength);
                lLength = 1;
            }
            if (lLength > 2) nums[i] = Integer.MAX_VALUE;
        }
        
        Arrays.sort(nums);
        
        if (lLength > 1) tLength += Math.min(2, lLength) - 1;
        return tLength;
    }
}
