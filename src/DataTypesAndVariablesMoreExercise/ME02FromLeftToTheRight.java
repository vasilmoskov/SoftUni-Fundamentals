package DataTypesAndVariablesMoreExercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class ME02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            long leftNum = scanner.nextLong();
            long rightNum = scanner.nextLong();
            if (leftNum > rightNum) {
                int sumN1 = 0;
                while (leftNum != 0) {
                    long currentDigit = leftNum % 10;
                    leftNum /= 10;
                    sumN1 += currentDigit;
                }
                System.out.println(Math.abs(sumN1));
            } else {
                int sumN2 = 0;
                while (rightNum != 0) {
                    long currentDigit = rightNum % 10;
                    rightNum /= 10;
                    sumN2 += currentDigit;
                }
                System.out.println(Math.abs(sumN2));
            }
        }
    }
}
