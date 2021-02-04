package MethodsLab;

import java.util.Scanner;

public class L10MultiplyEvensByOdds {

    static int getMultipleOfEvensAndOdds(int n) {
        int evenSum = getSumOfEvenDigits(n);
        int oddSum = getSumOfOddDigits(n);
        return evenSum * oddSum;
    }

    static int getSumOfEvenDigits(int n) {
        int counter = 0;
        int evenSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (counter % 2 == 0) {
                evenSum += digit;
            }
            n /= 10;
            counter++;
        }
            return evenSum;
    }

    static int getSumOfOddDigits(int n) {
        int counter = 0;
        int oddSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (counter % 2 == 1) {
                oddSum += digit;
            }
            n /= 10;
            counter++;
        }
        return oddSum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        n = Math.abs(n);

        System.out.println(getMultipleOfEvensAndOdds(n));

    }


}
