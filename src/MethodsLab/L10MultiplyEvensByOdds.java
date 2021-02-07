package MethodsLab;

import java.util.Scanner;

public class L10MultiplyEvensByOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        n = Math.abs(n);

        int result = getMultiplyOfEvenNumbers(n);

        System.out.println(result);
    }

    public static int getMultiplyOfEvenNumbers(int n) {

        int sumOfEven = 0;
        int sumOfOdd = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                sumOfEven += digit;
            } else {
                sumOfOdd += digit;
            }
            n /= 10;
        }

        return sumOfEven * sumOfOdd;
    }

}
