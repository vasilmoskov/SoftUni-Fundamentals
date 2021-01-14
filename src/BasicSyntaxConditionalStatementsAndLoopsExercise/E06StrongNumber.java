package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E06StrongNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int numberToTreat = number;

        int digit = 0;
        int sum = 0;


        while (numberToTreat > 0) {

            digit = numberToTreat % 10;

            numberToTreat = numberToTreat / 10;

            int i, fact = 1;

            for (i = 1; i <= digit; i++) {
                fact = fact * i;
            }
            sum += fact;
        }

        if (number==sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }


}
