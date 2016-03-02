import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static int[] backDp;
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int testCases = sc.nextInt();
      for (int i = 0; i < testCases; i++) {
        input = sc.next();
        backDp = new int[10001];
        Arrays.fill(backDp, -1);
        System.out.println(pi(0, 0));
      }
    }
  }

  private static String input;

  private static int pi(int start, int score) {
    if (backDp[start] > -1) {
      return backDp[start] + score;
    }

    int remainLength = input.length() - start;
    if (remainLength == 0) {
      return score;
    } else if (remainLength < 3) {
      return Integer.MAX_VALUE;
    }

    int min = Integer.MAX_VALUE;
    min = Math.min(pi(start + 3, subScore(start, start + 3)), min);
    min = Math.min(pi(start + 4, subScore(start, start + 4)), min);
    min = Math.min(pi(start + 5, subScore(start, start + 5)), min);

    backDp[start] = min;
    return min + score;
  }

  //점수 계산
  private static int subScore(int start, int end) {
    int length = end - start;
    if (length < 3 || start + length > input.length()) return 0;
    
    int score = 1;
    for (int i = start + 1; i < start + length; i++) {
      if (input.charAt(i) == input.charAt(i - 1) && score == 1) {
        score = 1;
      } else {
        score = 2;
        break;
      };
    }
    if (score == 1)
      return 1;

    int prevDiff = Character.getNumericValue(input.charAt(start)) - Character.getNumericValue(input.charAt(start + 1));
    for (int i = start + 2; i < start + length; i++) {
      int diff = Character.getNumericValue(input.charAt(i - 1)) - Character.getNumericValue(input.charAt(i));
      if (diff == prevDiff && Math.abs(diff) == 1 && Math.abs(prevDiff) == 1) {
        score = 2;
      } else {
        score = 5;
        break;
      };
    }
    if (score == 2)
      return 2;

    if (length == 3) {
      if (input.charAt(start) == input.charAt(start + 2))
        return 4;
    } else if (length == 4) {
      if (input.charAt(start) == input.charAt(start + 2) && input.charAt(start + 1) == input.charAt(start + 3))
        return 4;
    } else if (length == 5) {
      if (input.charAt(start) == input.charAt(start + 2) && input.charAt(start + 2) == input.charAt(start + 4)
          && input.charAt(start + 1) == input.charAt(start + 3))
        return 4;
    }

    for (int i = start + 2; i < start + length; i++) {
      if (Character.getNumericValue(input.charAt(i - 1)) - Character.getNumericValue(input.charAt(i)) == prevDiff)
        score = 5;
      else {
        score = 10;
        break;
      };
    }
    if (score == 5)
      return 5;

    return 10;
  }
}
