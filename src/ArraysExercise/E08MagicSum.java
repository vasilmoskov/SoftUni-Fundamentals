package ArraysExercise;

import java.util.Scanner;

public class E08MagicSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] numbersAsString = scanner.nextLine().split(" ");
        int n = Integer.parseInt (scanner.nextLine());

        int [] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers [i] = Integer.parseInt(numbersAsString[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers [i] + numbers [j] == n) {
                    System.out.print(numbers[i] + " " + numbers[j]);
                }
            }
            System.out.println();
        }

    }
}
