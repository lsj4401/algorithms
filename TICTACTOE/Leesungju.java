import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class Main {
  private static List<Set<Integer>> winningSet = new ArrayList<>();
  private static Set<Integer> o = new LinkedHashSet<>();
  private static Set<Integer> x = new LinkedHashSet<>();
  public static void main(String[] args) {
    winningSet.add(new HashSet<>(Arrays.asList(0, 1, 2)));
    winningSet.add(new HashSet<>(Arrays.asList(3, 4, 5)));
    winningSet.add(new HashSet<>(Arrays.asList(6, 7, 8)));
    winningSet.add(new HashSet<>(Arrays.asList(0, 3, 6)));
    winningSet.add(new HashSet<>(Arrays.asList(1, 4, 7)));
    winningSet.add(new HashSet<>(Arrays.asList(2, 5, 8)));
    winningSet.add(new HashSet<>(Arrays.asList(0, 4, 8)));
    winningSet.add(new HashSet<>(Arrays.asList(2, 4, 6)));
    try (Scanner s = new Scanner(System.in)) {
      int testCase = s.nextInt();
      for (int i = 0; i < testCase; i++) {
        o.clear(); x.clear();
        setBoard(s);
        System.out.println(tictactoe(x.size() <= o.size()));
      }
    }
  }

  private static void setBoard(Scanner s) {
    for (int j = 0; j < 3; j++) {
      String input = s.next();
      for (int k = 0; k < 3; k++) {
        int idx = j * 3 + k;
        if (input.charAt(k) == '.') continue;
        else if (input.charAt(k) == 'o') o.add(idx);
        else x.add(idx);
      }
    }
  }
 
  private static String tictactoe(boolean isXturn) {
    if (isWin(!isXturn)) 
      return !isXturn ? "x" : "o";
    else if (x.size() + o.size() == 9)
      return "TIE";
    
    
    Collection<Integer> user = isXturn ? x : o;
    String expectGameResult = isXturn ? "x" : "o";
    boolean isTie = false;
    for (int i = 0; i < 9; i++) {
      if (x.contains(i) || o.contains(i)) continue;
      user.add(i);
      String gameResult = tictactoe(!isXturn);
      if (expectGameResult.equals(gameResult)) { 
        user.remove(i);
        return expectGameResult;
      } else if (gameResult.equals("TIE")) {
        isTie = true;
      }
      user.remove(i);
    }
    
    return isTie ? "TIE" : expectGameResult.equals("x") ? "o" : "x"; 
  }
  
  private static boolean isWin(boolean isXturn) {
    Collection<Integer> c = isXturn ? x : o;
    for (Set<Integer> set : winningSet) {
      if (c.containsAll(set)) return true;
    }
    return false;
  }
  
}
