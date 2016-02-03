
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  private static int minCount;
  private static int peopleCount;
  private static Map<Integer, List<Integer>> foodTable;
  private static int[] preparedFood;
  private static int[] whoAte;
  private static int ateCount;
  private static int preparedFoodCount;
  public static void main(String[] arg) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(sc.readLine());
    for (int i = 0; i < caseCount; i++) {
      String[] count = sc.readLine().split(" ");
      ateCount = 0;
      preparedFoodCount = 0;
      peopleCount = Integer.parseInt(count[0]);
      int foodCount = Integer.parseInt(count[1]);
      preparedFood = new int[50];
      foodTable = new HashMap<>();
      
      Map<String, Integer> peopleMappingTabe = new HashMap<>();
      String[] names = sc.readLine().split(" "); 
      whoAte = new int[51];
      for (int j = 0; j < peopleCount; j++) {
        peopleMappingTabe.put(names[j], j);
      }
      
      for (int foodIdx = 0; foodIdx < foodCount; foodIdx++) {
        String[] readLine = sc.readLine().split(" ");
        int c = Integer.parseInt(readLine[0]);
        for (int j = 0; j < c; j++) {
          List<Integer> canPeopleSet = foodTable.get(foodIdx);
          if (canPeopleSet == null) canPeopleSet = new ArrayList<>();
          canPeopleSet.add(peopleMappingTabe.get(readLine[j + 1]));
          foodTable.put(foodIdx, canPeopleSet);
        }
      }
      
      minCount = Integer.MAX_VALUE;
      calcMinFood(0);
      System.out.println(minCount);
    }
    sc.close();
  }
  
  //모든 음식을 조합해서 조합 갯수가 가장 적은 count 를 찾는다
  private static void calcMinFood(int startFoodIdx) {
    if (preparedFoodCount >= minCount) return;
    for (int foodIdx = startFoodIdx; foodIdx < foodTable.size(); foodIdx++) {
      if (preparedFood[foodIdx] != 0 || foodTable.get(foodIdx) == null) continue;
      if ((++preparedFood[foodIdx]) == 1) preparedFoodCount++;
      
      for (int name : foodTable.get(foodIdx)) {
        if ((++whoAte[name]) == 1) ateCount++;
      }
      
      if (peopleCount == ateCount) {
        minCount = Math.min(minCount, preparedFoodCount);
      } else {
        calcMinFood(startFoodIdx + 1);
      }
      
      for (int name : foodTable.get(foodIdx)) {
        if ((--whoAte[name]) == 0) ateCount--;
      }
      if ((--preparedFood[foodIdx]) == 0) preparedFoodCount--;
    }
  }
}
