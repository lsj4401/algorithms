import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
  private static final char NULL_CHAR = '\u0000';
  
  static int[] backDp;
  public static void main(String[] args) throws FileNotFoundException {
    try (Scanner sc = new Scanner(new File("input.txt"))) {
      int testCases = sc.nextInt();
      for (int i = 0; i < testCases; i++) {
        input = sc.next();
        backDp = new int[10001];
        Arrays.fill(backDp, -1);
        System.out.println(pi(0, new char[10000], 0));
      }
    }
  }
 
  private static String input;
  private static int pi(int start, char[] checkString, int idx) {
//    if (backDp[idx] != -1) return backDp[idx];
    
    int remainLength = input.length() - start;
    if (remainLength == 0) {
      return fullScore(checkString);
    } else if (remainLength < 3) {
      return Integer.MAX_VALUE;
    }
    
    checkString[idx] = '3';
    int min = pi(start + 3, checkString, idx + 1);
    checkString[idx] = '4';
    min = Math.min(pi(start + 4, checkString, idx + 1), min);
    checkString[idx] = '5';
    min = Math.min(pi(start + 5, checkString, idx + 1), min);
    
    checkString[idx] = NULL_CHAR;
    return backDp[idx] = min; 
  }
 
  private static int fullScore(char[] checkString) {
    int startIdx = 0;
    int endIdx = 0; 
    int result = 0;
    for (char ch : checkString) {
      if (ch == NULL_CHAR) break;
      endIdx = Character.getNumericValue(ch) + startIdx;
      result += subScore(input.substring(startIdx, endIdx));
      startIdx = endIdx;
    }
    return result;
  }
  
  //점수 계산
  private static int subScore(String input) {
    int length = input.length();
    int score = 1;
    for (int i = 1; i < length; i++) {
      if (input.charAt(i) == input.charAt(i - 1) && score == 1) score = 1;
      
      else {score = 2; break;};
    }
    if (score == 1) return 1;
    
    int prevDiff = Character.getNumericValue(input.charAt(0)) - Character.getNumericValue(input.charAt(1));
    for (int i = 2; i < length; i++) {
      int diff = Character.getNumericValue(input.charAt(i - 1)) - Character.getNumericValue(input.charAt(i));
      if (diff == prevDiff && Math.abs(diff) == 1 && Math.abs(prevDiff) == 1) score = 2;
      else {score = 5; break;};
    }
    if (score == 2) return 2;
 
    if (length == 3) {
      if (input.charAt(0) == input.charAt(2)) return 4; 
    } else if (length == 4) {
      if (input.charAt(0) == input.charAt(2) && input.charAt(1) == input.charAt(3)) return 4;
    } else if (length == 5) {
      if (input.charAt(0) == input.charAt(2) && input.charAt(2) == input.charAt(4) && input.charAt(1) == input.charAt(3)) return 4;
    }
    
    for (int i = 2; i < length; i++) {
      if (Character.getNumericValue(input.charAt(i - 1)) - Character.getNumericValue(input.charAt(i)) == prevDiff) score = 5;
      else { score = 10; break; } ;
    }
    if (score == 5) return 5;
    
    return 10;
  }
}
