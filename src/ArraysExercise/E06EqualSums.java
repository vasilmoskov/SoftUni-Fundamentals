package ArraysExercise;

import java.util.Scanner;

public class E06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(" ");

        int[] numbers = new int[numbersAsString.length];


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        int sumLeftSide = 0;
        int sumRightSide = 0;
        boolean thereIsSuchIndex = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int indexLeft = 0; indexLeft < i; indexLeft++) {
                sumLeftSide += numbers[indexLeft];
            }
            for (int indexRight = i + 1; indexRight < numbers.length; indexRight++) {
                sumRightSide += numbers[indexRight];
            }
            if (sumLeftSide == sumRightSide) {
                thereIsSuchIndex = true;
                System.out.println(i);
            }

            sumLeftSide = 0;
            sumRightSide = 0;
        }


        if (!thereIsSuchIndex) {
            System.out.println("no");
        }
    }
}