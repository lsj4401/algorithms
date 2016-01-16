public class Solution {
  public int hammingWeight(int n) {
    int mask = 1;
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += (n >> i & mask) == 0 ? 0 : 1;
    }
    return count;
  }
}
