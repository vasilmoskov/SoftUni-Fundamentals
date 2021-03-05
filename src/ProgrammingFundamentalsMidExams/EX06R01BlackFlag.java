package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX06R01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfThePlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalPlunder = 0;

        for (int i = 1; i <= daysOfThePlunder; i++) {

            if (i % 3 == 0) {
                double additionalPlunder = dailyPlunder * 0.5;
                totalPlunder += additionalPlunder;
            }

            totalPlunder += dailyPlunder;

            if (i % 5 == 0) {
                totalPlunder *= 0.7;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", totalPlunder / expectedPlunder * 100);
        }

    }
}
