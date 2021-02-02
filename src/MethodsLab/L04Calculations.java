package MethodsLab;

import java.util.Scanner;

public class L04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int firstNumber = Integer.parseInt (scanner.nextLine());
        int secondNumber = Integer.parseInt (scanner.nextLine());

        if (input.equals("add")) {
            addedNumbers(firstNumber, secondNumber);
        } else if (input.equals("multiply")) {
            multipliedNumbers(firstNumber, secondNumber);
        } else if (input.equals("subtract")) {
            subtractedNumbers(firstNumber, secondNumber);
        } else if (input.equals("divide")) {
            dividedNumbers(firstNumber, secondNumber);
        }
    }

    static void addedNumbers (int firstNumber, int secondNumber) {
        int sum = firstNumber+secondNumber;
        System.out.println(sum);
    }

    static void multipliedNumbers (int firstNumber, int secondNumber) {
        int sum = firstNumber*secondNumber;
        System.out.println(sum);
    }

    static void subtractedNumbers (int firstNumber, int secondNumber) {
        int sum = firstNumber-secondNumber;
        System.out.println(sum);
    }

    static void dividedNumbers (int firstNumber, int secondNumber) {
        int sum = firstNumber/secondNumber;
        System.out.println(sum);
    }


}
