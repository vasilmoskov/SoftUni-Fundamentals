package DataTypesAndVariablesLab;

import java.util.Scanner;

public class L12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumDigits = 0;


        for (int i = 1; i <= n; i++) {
            int j = i;
            sumDigits = 0;
            while (j > 0) {
                int digit = j % 10;
                j /= 10;
                sumDigits += digit;
            }

            if (sumDigits == 5 || sumDigits == 7 || sumDigits == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }

        }
    }
}
