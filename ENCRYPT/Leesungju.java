import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int testCases = sc.nextInt();
      for (int i = 0; i < testCases; i++) {
        String input = sc.next();
        StringBuilder odd = new StringBuilder();
        StringBuilder eve = new StringBuilder();
        for (int j = 0; j < input.length(); j++) {
          if (j % 2 == 0) {
            eve.append(input.charAt(j));
          } else {
            odd.append(input.charAt(j));
          }
        }
        System.out.println(eve.toString() + odd.toString());
      }
    }
  }
}
