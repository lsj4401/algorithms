import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	/*
	 * peopleKeyTable : {key: 사람, value: 사람이 먹을 수 있는 음식 목록} foodKeyTable : {key:
	 * 음식, value: 해당 음식을 먹을 수 있는 사람 목록} minFoodCount : 모든 사람을 먹일 수 있는 최소 음식 수. 본
	 * 프로그램의 result value notEatYetPeopleCount : 아직 음식을 먹지 않은 사람의 수
	 * eatenFoodCount : 사람들이 먹은 음식의 수 totalFoodCount : 음식의 총수 peopleAteYn : 취식
	 * 여부 확인을 위한 배열
	 */
	private static Map<Integer, List<Integer>> peopleKeyTable = new HashMap<>();
	private static Map<Integer, List<Integer>> foodKeyTable = new HashMap<>();
	private static int minFoodCount;
	private static int notEatYetPeopleCount;
	private static int totalPeopleCount;
	private static int eatenFoodCount;
	private static int totalFoodCount;
	private static int[] peopleAteYn;

	public static void main(String[] arg) throws IOException {
		// try (Scanner sc = new Scanner(new
		// File("/home/daewook/workspace/springStudy/Al/src/input.txt"))) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
//		System.out.println("테스트 케이스의 수 : " + testCase);

		for (int test = 0; test < testCase; test++) {
			totalPeopleCount = notEatYetPeopleCount = sc.nextInt();
			totalFoodCount = sc.nextInt();
//			System.out.println("사람의 수 : " + notEatYetPeopleCount + ", 음식의 수 : " + totalFoodCount);

			minFoodCount = totalFoodCount;
			eatenFoodCount = 0;

			peopleAteYn = new int[notEatYetPeopleCount];

			// 사람 목록 구성하기 {key: name, value: index}
			Map<String, Integer> nameIdxTable = new HashMap<>();
			for (int i = 0; i < notEatYetPeopleCount; i++) {
				nameIdxTable.put(sc.next(), i);
			}

			// 음식, 사람 기준으로 list 생성
			for (int foodIdx = 0; foodIdx < totalFoodCount; foodIdx++) {
				int peopleCountWhoEatableFoodIdx = sc.nextInt(); // peopleCountWhoEatableFoodIdx,
																	// 음식을 먹을 수
																	// 있는 사람의 수

				List<Integer> peopleList = new ArrayList<>(); // peopleList,
																// foodIdx번째 음식을
																// 먹을 수 있는 사람
																// 리스트
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

				if (peopleList.size() == notEatYetPeopleCount)
					minFoodCount = 1;
			}

			if (minFoodCount != 1) {
				calculateMinFoodCount(0);
			}

			System.out.println(minFoodCount);
//			System.out.println();
		}
		sc.close();
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
	}

	private static void calculateMinFoodCount(int pIdx) {

		for (int foodIndex : peopleKeyTable.get(pIdx)) {
			int nextPeopleIndex = -1;
//			System.out.println(foodIndex + "번째 음식");
			eatenFoodCount++;

			for (int peopleIndex : foodKeyTable.get(foodIndex)) {
//				System.out.println(peopleIndex + "사람이 먹을 수 있음");
				if (peopleAteYn[peopleIndex] == 1) {
					continue;
				}
				peopleAteYn[peopleIndex] = 1;
				if (peopleAteYn[peopleIndex] == 1)
					notEatYetPeopleCount--;

			}
//			System.out.println(notEatYetPeopleCount + "명이 음식을 먹지 못했음");

			if (notEatYetPeopleCount == 0) {
				if (minFoodCount > eatenFoodCount)
					minFoodCount = eatenFoodCount;
//				System.out.println("모든 사람이 음식을 다 먹음, 음식의 수 : " + minFoodCount);
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
//				System.out.println("다음 사람 : " + nextPeopleIndex);
				calculateMinFoodCount(nextPeopleIndex);
			}

			// for (int peopleIndex : foodKeyTable.get(foodIndex)) {
			// peopleAteYn[peopleIndex] = 0;
			// if (peopleAteYn[peopleIndex] == 0) notEatYetPeopleCount++;
			// }
			//
			// eatenFoodCount--;

//			System.out.println();
		}
	}
}