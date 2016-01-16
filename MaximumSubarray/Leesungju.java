public class Solution {
  public int maxSubArray(int[] nums) {
    int endIdx= getIdx(nums, 0, nums.length, +1, true);
    int startIdx = getIdx(nums, nums.length - 1, -1, -1, false);
    if (endIdx < startIdx) return nums[0];
    return Arrays.stream(Arrays.copyOfRange(nums, startIdx, endIdx + 1)).sum();
  }

  private int getIdx(int[] nums, int start, int end, int addValue, boolean isStart) {
    int idx = 0, max = Integer.MIN_VALUE, sum = 0;
    for (int i = start; i != end; i += addValue) {
      sum = Math.max(nums[i], sum + nums[i]);
      if (max < sum || (max == sum && isStart)) {
        idx = i;
      }
      max = Math.max(max, sum);
    }
    return idx;
  }
}
