package MethodsExercise;

import java.util.Scanner;

public class E01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt (scanner.nextLine());
        int secondNum = Integer.parseInt (scanner.nextLine());
        int thirdNum = Integer.parseInt (scanner.nextLine());

        System.out.println(smallestNumber(firstNum,secondNum,thirdNum));

    }

    static int smallestNumber(int firstNum, int secondNum, int thirdNum) {
        int smallestNum = Integer.MAX_VALUE;
        if (firstNum< smallestNum) {
            smallestNum = firstNum;
        }
        if (secondNum < smallestNum) {
            smallestNum = secondNum;
        }
        if (thirdNum < smallestNum) {
            smallestNum = thirdNum;
        }

        return smallestNum;
    }
}
