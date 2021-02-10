package MethodsExercise;

import java.util.Scanner;

public class E10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {
            if (sumOfDigitsIsDivisibleByEight(i) && holdsOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean sumOfDigitsIsDivisibleByEight(int number) {
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }

        return sum % 8 == 0;
    }

    public static boolean holdsOddDigit (int number) {
        boolean oddFound = false;

        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                oddFound = true;
                break;
            }
            number /= 10;
        }

        return oddFound;
    }
}
