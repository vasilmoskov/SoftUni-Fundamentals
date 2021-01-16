package DataTypesAndVariablesLab;

import java.util.Scanner;

public class L12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int n = Integer.parseInt(scanner.nextLine());
        boolean isSpecialNum = false;

        for (int i = 1; i <= n; i++) {
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> %b%n");
            }
        }
    }
}
