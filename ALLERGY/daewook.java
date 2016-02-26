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
	private static int notEatYetPeopleCount;
	private static int totalFoodCount;
	private static int[] peopleAteYn;
	private static int[] foodMadeYn;
	private static List<Integer> notEatYetPeopleList;
	private static int resultFoodCount;

	public static void main(String[] arg) throws IOException {
		notEatYetPeopleList = new ArrayList<>();

		try (Scanner sc = new Scanner(
				new File("/home/daewook/workspace/springStudy/algospot-allergy/src/input3.txt"))) {
			// Scanner sc = new Scanner(System.in);
			int testCase = sc.nextInt();

			for (int test = 0; test < testCase; test++) {
				notEatYetPeopleCount = sc.nextInt();
				totalFoodCount = sc.nextInt();

				resultFoodCount = 0;

				peopleAteYn = new int[notEatYetPeopleCount];
				foodMadeYn = new int[totalFoodCount];

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

				calculateMinFoodCountV2(0);

				System.out.println(resultFoodCount);
				// System.out.println();
			}

			// sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void calculateMinFoodCountV2(Integer peopleIndex) {
		if (notEatYetPeopleCount == 0 || peopleIndex < 0)
			return;

		System.out.println(peopleIndex + "번째 사람");
		int foodIndex = findFoodIndex(peopleIndex);
		foodMadeYn[foodIndex] = 1;
		eatYnChange(foodIndex);

		int nextpeopleIndex = findNextPeopleIndex();
		resultFoodCount++;
		System.out.println(resultFoodCount + "개의 음식을 먹음");
		System.out.println();
		calculateMinFoodCountV2(nextpeopleIndex);
	}

	private static int findFoodIndex(Integer peopleIndex) {
		int result = -1;
		int tmpNotEatFoodPeopleCnt = 0;

		notEatYetPeopleList.clear();

		for (int foodIndexOfpeople : peopleKeyTable.get(peopleIndex)) {
			if (foodMadeYn[foodIndexOfpeople] == 1)
				continue;

			for (int peopleIndexOfFood : foodKeyTable.get(foodIndexOfpeople)) {
				if (peopleAteYn[peopleIndexOfFood] == 1)
					continue;

				System.out.println(foodIndexOfpeople + "번째 음식, " + peopleIndexOfFood + "번째 사람이 아직 먹지 않음 ");
				notEatYetPeopleList.add(peopleIndexOfFood);
			}

			System.out.println(foodIndexOfpeople + "번째 음식, " + notEatYetPeopleList.size() + "명의 사람이 먹을 수 있음");

			if (tmpNotEatFoodPeopleCnt < Math.max(tmpNotEatFoodPeopleCnt, notEatYetPeopleList.size())) {
				tmpNotEatFoodPeopleCnt = Math.max(tmpNotEatFoodPeopleCnt, notEatYetPeopleList.size());
				result = foodIndexOfpeople;
				break;
			}
		}

		System.out.println(result + "번째 음식을 시식");
		return result;
	}

	private static void eatYnChange(int foodIndex) {
		for (int peopleIndex : foodKeyTable.get(foodIndex)) {
			peopleAteYn[peopleIndex] = 1;
			notEatYetPeopleCount--;
			System.out.println(peopleIndex + "번째 사람이 함께 먹음");
		}
	}

	private static int findNextPeopleIndex() {
		int result = -1;

		for (int i = 0; i < peopleAteYn.length; i++) {
			if (peopleAteYn[i] == 0)
				return i;
		}

		return result;
	}
}