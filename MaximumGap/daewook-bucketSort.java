public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0; 
            
        if (nums.length == 2)
            return Math.abs(nums[0] - nums[1]);
        
        int result = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int gapCnt = nums.length - 1 ;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        double holeGapSize = (double) (max - min) / gapCnt;
        
        if (holeGapSize == 0) {
            return max - min;
        }
        
        int[] holeMin = new int[gapCnt];
        int[] holeMax = new int[gapCnt];
        Arrays.fill(holeMin, Integer.MAX_VALUE);
        Arrays.fill(holeMax, Integer.MIN_VALUE);        
        int holeNum = -1;
        
        for (int num : nums) {
            holeNum = (int) ((num - min) / holeGapSize);            
            if (holeNum == gapCnt)
                holeNum--;

            holeMin[holeNum] = Math.min(holeMin[holeNum], num);
            holeMax[holeNum] = Math.max(holeMax[holeNum], num);
        }
        
        int prev = min;
        for (int i = 0; i < gapCnt; i++) {
            if (holeMin[i] == Integer.MAX_VALUE && holeMax[i] == Integer.MIN_VALUE)
                continue;

            result = Math.max(result, holeMin[i] - prev);
            prev = holeMax[i];
        }
        
        result = Math.max (result, max - prev);
        
        return result;
    }
}