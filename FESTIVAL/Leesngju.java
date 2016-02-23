import java.util.Scanner;

public class Main {

  public static void main(String[] arg) {
    try (Scanner sc = new Scanner(System.in)) {
      int testCase = sc.nextInt();
      for (int i = 0; i < testCase; i++) {
        int inputCount = sc.nextInt();
        int range = sc.nextInt();
        int[] input = new int[inputCount];
        for (int j = 0; j < inputCount; j++) {
          input[j] = sc.nextInt();
        }

        System.out.printf("%.8f\n", festival(input, range, inputCount));
      }
    }
  }

  private static double festival(int[] input, int minLen, int len) {
    double[] sArray = new double[len + 1];
    for (int i = 1; i < len + 1; i++) {
      sArray[i] = sArray[i - 1] + input[i - 1];
    }

    double min = Double.MAX_VALUE;
    for (int end = minLen; end < len + 1; end++) {
      for (int start = 0; start < (end + 1 - minLen); start++) {
        min = Math.min((sArray[end] - sArray[start]) / (end - start), min);
      }
    }
    return min;
  }
}
