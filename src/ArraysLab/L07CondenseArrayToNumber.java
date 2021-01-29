package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class L07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbersAsString = input.split(" ");
        int sum = 0;

        int[] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);

        }

        while (numbers.length>1) {
            int [] condensed = new int[numbers.length-1];
            for (int i = 0; i < condensed.length; i++) {
                condensed [i] = numbers[i] + numbers [i+1];
            }
            numbers = condensed;

        }


        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
