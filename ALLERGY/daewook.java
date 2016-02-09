import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {	
	private static Map<Integer, List<Integer>> peopleKeyTable = new HashMap<>();
	private static Map<Integer, List<Integer>> foodKeyTable = new HashMap<>();
	private static int minFoodCount;
	private static int notEatYetPeopleCount;
	private static int totalPeopleCount;
	private static int eatenFoodCount;
	private static int totalFoodCount;
	private static int[] peopleAteYn;

	public static void main(String[] arg) throws IOException {
		try (Scanner sc = new Scanner(new File("/home/daewook/workspace/springStudy/Al/src/input.txt"))) {
			int testCase = sc.nextInt();

			for (int test = 0; test < testCase; test++) {
				totalPeopleCount = notEatYetPeopleCount = sc.nextInt();
				totalFoodCount = sc.nextInt();
				minFoodCount = totalFoodCount;
				eatenFoodCount = 0;
				peopleAteYn = new int[notEatYetPeopleCount];

				Map<String, Integer> nameIdxTable = new HashMap<>();
				for (int i = 0; i < notEatYetPeopleCount; i++) {
					nameIdxTable.put(sc.next(), i);
				}
				
				for (int foodIdx = 0; foodIdx < totalFoodCount; foodIdx++) {
					int peopleCountWhoEatableFoodIdx = sc.nextInt(); 
					List<Integer> peopleList = new ArrayList<>(); 
					for (int i = 0; i < peopleCountWhoEatableFoodIdx; i++) {
						int pIdx = nameIdxTable.get(sc.next());
						List<Integer> eatFoodList = peopleKeyTable.get(pIdx);
						if (eatFoodList == null) {
							eatFoodList = new ArrayList<>();
						}
						eatFoodList.add(foodIdx);
						peopleList.add(pIdx);
						peopleKeyTable.put(pIdx, eatFoodList);
					}
					foodKeyTable.put(foodIdx, peopleList);
				}
				calculateMinFoodCount(0);
				System.out.println(minFoodCount);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void calculateMinFoodCount(int pIdx) {

		for (int foodIndex : peopleKeyTable.get(pIdx)) {
			int nextPeopleIndex = -1;
			eatenFoodCount++;

			for (int peopleIndex : foodKeyTable.get(foodIndex)) {
				if (peopleAteYn[peopleIndex] == 1) {
					continue;
				}
				peopleAteYn[peopleIndex] = 1;
				if (peopleAteYn[peopleIndex] == 1)
					notEatYetPeopleCount--;
			}

			if (notEatYetPeopleCount == 0) {
				if (minFoodCount > eatenFoodCount)
					minFoodCount = eatenFoodCount;
				peopleAteYn = new int[totalPeopleCount];
				notEatYetPeopleCount = totalPeopleCount;
				eatenFoodCount = 0;
				return;
			}

			List<Integer> notEatYetPeopleList = new ArrayList<>();

			for (int i = 0; i < peopleAteYn.length; i++) {
				if (peopleAteYn[i] == 0) {
					if (nextPeopleIndex == -1)
						nextPeopleIndex = i;
					notEatYetPeopleList.add(i);
				}
			}

			for (int j = 0; j < totalFoodCount; j++) {
				if (foodKeyTable.get(j).containsAll(notEatYetPeopleList)) {
					for (int peopleIndex : notEatYetPeopleList) {
						peopleAteYn[peopleIndex] = 1;
						notEatYetPeopleCount--;
					}
				}
			}

			for (int i = 0; i < peopleAteYn.length; i++) {
				if (peopleAteYn[i] == 0) {
					if (nextPeopleIndex == -1) {
						nextPeopleIndex = i;
						break;
					}
				}
			}

			if (nextPeopleIndex > 0) {
				calculateMinFoodCount(nextPeopleIndex);
			}
		}
	}
}