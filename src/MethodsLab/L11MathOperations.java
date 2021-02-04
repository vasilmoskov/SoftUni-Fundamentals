package MethodsLab;

import java.util.Scanner;

public class L11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = Double.parseDouble(scanner.nextLine());
        char operation = scanner.nextLine().charAt(0);
        double secondNumber = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", calculatedResult(firstNumber,operation,secondNumber));
    }

    static double calculatedResult(double firstNumber, char operation, double secondNumber) {
        double result = 0;
        switch (operation) {
            case '/':
                result = firstNumber / secondNumber;
                break;
            case '*':
                result= firstNumber * secondNumber;
                break;
            case '-':
                result= firstNumber - secondNumber;
                break;
            case '+':
                result= firstNumber + secondNumber;
                break;
        }
        return result;
    }


}

