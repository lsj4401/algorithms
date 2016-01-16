// Maximum Subarray
// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public static int maxSubArray(int[] nums) {
    int result = nums[0];
    int sum = nums[0];

    for (int i = 1; i<nums.length; i++) {
    	sum = Math.max(nums[i], sum + nums[i]);
    	result = Math.max(sum, result);
    }
    
    return result;
}