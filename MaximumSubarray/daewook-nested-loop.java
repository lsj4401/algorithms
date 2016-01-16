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