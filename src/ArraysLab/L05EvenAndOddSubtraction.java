package ArraysLab;

import java.util.Scanner;

public class L05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String [] numbersAsString = input.split(" ");

        int [] numbers = new int[numbersAsString.length];

        int sumEven=0;
        int sumOdd=0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
            if (numbers[i]%2==0) {
                sumEven+=numbers[i];
            } else {
                sumOdd+=numbers[i];
            }
        }

        System.out.println(sumEven-sumOdd);
    }
}
