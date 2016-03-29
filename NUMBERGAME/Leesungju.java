import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
  
  private static int[] input;
  private static int[][] dp; 
  private static boolean[][] check;
  public static void main( String [] arg ) {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    for (int i = 0; i < count; i++) {
      int length = sc.nextInt();
      input = new int[length];
      dp = new int[length][length];
      check = new boolean[length][length];
      for (int idx = 0; idx < length; idx++) {
        input[idx] = sc.nextInt();
      }
      
      System.out.println(game(0, input.length - 1, 0, 0, true));
    }
    sc.close();
  }
  private static int game(int lIdx, int rIdx, int aScore, int bScore, boolean turn) {
    if (check[lIdx][rIdx]) return dp[lIdx][rIdx];
    
    int turnScore = turn ? aScore : bScore;
    if (rIdx - lIdx == 1) return Math.max(input[rIdx], input[lIdx]) - Math.min(input[rIdx], input[lIdx]);
    if (rIdx - lIdx == 0) return turnScore + input[lIdx];
    
    int  worst = Integer.MAX_VALUE;
    worst = Math.min(worst, game(lIdx + 2, rIdx, aScore, bScore, !turn));
    worst = Math.min(worst, game(lIdx, rIdx - 2, aScore, bScore, !turn));
    worst = Math.min(worst, game(lIdx + 1, rIdx, aScore, bScore, !turn) - input[lIdx]);
    worst = Math.min(worst, game(lIdx, rIdx - 1, aScore, bScore, !turn) - input[rIdx]);
    
    check[lIdx][rIdx] = true;
    
    return dp[lIdx][rIdx] = turnScore -  worst;
  }
}
