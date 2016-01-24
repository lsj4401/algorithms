//정답 봤음!!!!
public class Solution {
  public int[] singleNumber(int[] nums) {
    int diff = 0;
    for (int num : nums) {
      diff ^= num;
    }
    diff &= -diff;

    int[] rets = { 0, 0 };
    for (int num : nums) {
      rets[(num & diff) == 0 ? 0 : 1] ^= num;
    }
    return rets;
  }
}
