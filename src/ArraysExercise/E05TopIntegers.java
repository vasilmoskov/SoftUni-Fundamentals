package ArraysExercise;

import java.util.Scanner;

public class E05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(" ");

        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        boolean bigNumber = true;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    bigNumber = true;
                } else {
                    bigNumber = false;
                    break;
                }
            }
            if (bigNumber || i == numbers.length-1) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
