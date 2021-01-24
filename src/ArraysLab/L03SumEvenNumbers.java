package ArraysLab;

import java.util.Scanner;

public class L03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbersAsStrings = input.split(" ");

        int[] numbers = new int[numbersAsStrings.length];

        int sum = 0;

        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }

        System.out.println(sum);
    }
}
