import java.io.File;
import java.util.Scanner;

public class Main {

	private static int rentalbleDays;
	private static int mainBandsCount;
	private static Integer[] rentFee;
	private static double minFeeAvg = Double.MAX_VALUE;

	public static void main(String[] args) {
//		try (Scanner sc = new Scanner(
//				new File("/home/daewook/workspace/springStudy/algospot-festival/src/input1.txt"))) {
//			int testCases = sc.nextInt();
//
//			for (int testIndex = 0; testIndex < testCases; testIndex++) {
//				rentalbleDays = sc.nextInt();
//				mainBandsCount = sc.nextInt();
//
//				rentFee = new Integer[rentalbleDays];
//				for (int i = 0; i < rentalbleDays; i++) {
//					rentFee[i] = sc.nextInt();
//				}
//				System.out.println(calculateMinimumFeeAverage());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();

		for (int testIndex = 0; testIndex < testCases; testIndex++) {
			rentalbleDays = sc.nextInt();
			mainBandsCount = sc.nextInt();

			rentFee = new Integer[rentalbleDays];
			for (int i = 0; i < rentalbleDays; i++) {
				rentFee[i] = sc.nextInt();
			}
			System.out.println((double)calculateMinimumFeeAverage());
		}
		sc.close();
		
	}

	public static double calculateMinimumFeeAverage() {
		int sum = recursiveSum(mainBandsCount - 1, mainBandsCount);
		int cnt = mainBandsCount;
		minFeeAvg = (double) sum / cnt;

		for (int i = mainBandsCount; i < rentFee.length; i++) {
			if (minFeeAvg >= rentFee[i]) {
				if (rentFee[i] < rentFee[i - cnt]) {
					minFeeAvg = (double) recursiveSum(i, cnt) / cnt;
				} else {
					sum += rentFee[i];
					minFeeAvg = (double) sum / ++cnt;
				}
			}
		}

		return minFeeAvg;
	}

	private static int recursiveSum(int startIndex, int cnt) {
		int sum = 0;

		for (int i = startIndex; i > startIndex - cnt; i--) {
			sum += rentFee[i];
		}

		return sum;
	}

}
