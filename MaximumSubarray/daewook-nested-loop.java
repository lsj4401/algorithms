// Maximum Subarray
// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public int maxSubArray(int[] nums) {
    int result = 0;        
    
    for (int i=0; i<nums.length-1; i++) {
    	int sum = 0;
        if(sum < nums[i])
            sum = nums[i];
        
        for (int j=i+1; j<nums.length; j++) {
        	sum += nums[j];
            if (result < sum)
                result = sum;
        }            
    }
    
    return result;
}