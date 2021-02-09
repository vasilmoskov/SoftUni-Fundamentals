package MethodsExercise;

import java.util.Scanner;

public class E08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt (scanner.nextLine());
        int secondNumber = Integer.parseInt (scanner.nextLine());

        printDivisionOfFactorials(firstNumber, secondNumber);
    }

    public static long getFactorial (int number) {
        long fact = 1;

        for (int i = 1; i <= number; i++) {
            fact *= i;
        }

        return fact;
    }

    static void printDivisionOfFactorials (int firstNumber, int secondNumber) {
        double result = (double) getFactorial(firstNumber) / getFactorial(secondNumber);
        System.out.printf("%.2f", result);
    }
}