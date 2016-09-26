import java.util.*;
import java.lang.*;
import java.io.*;
 
class Solution {
  public static void main (String[] args) throws java.lang.Exception {
  	System.out.println(new Solution().canCross(new int[] {0,1,3,5,6,8,12,17}));
  }
 
  private int[] stones;
  private int lastStone = 0;
  private Map<String, Boolean> mem;
  public boolean canCross(int[] stones) {
    if (stones[1] - stones[0] != 1) return false;
    this.stones = stones;
    this.lastStone = stones[stones.length - 1];
    this.mem = new HashMap<>();
    return cross(1, 1);
  }
 
  private boolean cross(int idx, int dis) {
    if (idx == -1) return false;
    if (lastStone == stones[idx]) return true;
 
    Boolean result = mem.get(idx + "," + dis);
    if (result != null) return result;
 
    result = cross(searchNextStoneIdx(stones[idx] + dis - 1, idx), dis - 1) ||
        cross(searchNextStoneIdx(stones[idx] + dis, idx), dis) ||
        cross(searchNextStoneIdx(stones[idx] + dis + 1, idx), dis + 1);
    mem.put(idx + "," + dis, result);
    return result;
  }
 
  private int searchNextStoneIdx(int v, int idx) {
    while (idx + 1 < stones.length && stones[idx + 1] <= v) {
      idx += 1;
      if (stones[idx] == v) return idx;
    }
    return -1;
  }
}
