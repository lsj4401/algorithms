import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  private static int min;
  private static int peopleCount;
  private static Map<Integer, List<Integer>> peopleTable;
  private static Map<Integer, List<Integer>> foodTable;
  private static int[] whoAte;
  private static int ateCount;
  public static void main(String[] arg) throws IOException {
    Scanner sc = new Scanner(new File("input.txt"));
    int testCase = sc.nextInt();
    for (int i = 0; i < testCase; i++) {
      ateCount = 0;
      min = Integer.MAX_VALUE;
      peopleCount = sc.nextInt();
      int foodCount = sc.nextInt();
      whoAte = new int[50];
      foodTable = new HashMap<>();
      peopleTable = new HashMap<>();
      
      Map<String, Integer> peopleMappingTabe = new HashMap<>();
      for (int j = 0; j < peopleCount; j++) {
        peopleMappingTabe.put(sc.next(), j);
      }
      
      for (int foodIdx = 0; foodIdx < foodCount; foodIdx++) {
        int c = sc.nextInt();
        for (int j = 0; j < c; j++) {
          Integer nameIdx = peopleMappingTabe.get(sc.next());
          List<Integer> canPeopleSet = foodTable.get(foodIdx);
          if (canPeopleSet == null) canPeopleSet = new ArrayList<>();
          canPeopleSet.add(nameIdx);
          foodTable.put(foodIdx, canPeopleSet);
          List<Integer> foodList = peopleTable.get(nameIdx);
          if (foodList == null) foodList = new ArrayList<>();
          foodList.add(foodIdx);
          peopleTable.put(nameIdx, foodList);
        }
      }
      
      for (int j = 0 ; j < peopleCount; j++) {
        min = Math.min(calcMinFood(j, 0), min);
      }
      
      System.out.println(min);
    }
    sc.close();
  }
  
  //못먹는 사람을 골라서 음식을 만든다 
  private static int calcMinFood(int nameIdx, int atePeopleCount) {
    if (peopleCount == atePeopleCount) return ateCount;
    
    for (int foodIdx : peopleTable.get(nameIdx)) {
      for (int nameIdxByFood : foodTable.get(foodIdx)) {
        if ((++whoAte[nameIdxByFood]) == 1) ateCount++;
      }
      
      min = Math.min(calcMinFood(doNotEat(), ateCount), min);
      
      for (int nameIdxByFood : foodTable.get(foodIdx)) {
        if ((--whoAte[nameIdxByFood]) == 0) ateCount--;
      }
    }
    
    return min;
  }

  private static int doNotEat() {
    for (int nameIdx = 0; nameIdx < whoAte.length; nameIdx++) {
      if (whoAte[nameIdx] == 0) return nameIdx;
    }
    return -1;
  }
}
