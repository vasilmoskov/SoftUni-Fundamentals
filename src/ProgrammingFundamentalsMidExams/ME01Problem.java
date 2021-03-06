package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class ME01Problem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double journeyCost = Double.parseDouble(scanner.nextLine());
        int monthsForCollecting = Integer.parseInt(scanner.nextLine());

        double spendingsInTheEndOfTheMonth = journeyCost * 0.25;
        double totalSpendings = 0;

        for (int month = 1; month <= monthsForCollecting; month++) {

            if (month != 1 && month % 2 == 1) {
                totalSpendings *= 0.84;
            }

            if (month % 4 == 0) {
                totalSpendings *= 1.25;
            }

            totalSpendings += spendingsInTheEndOfTheMonth;
        }

        if (totalSpendings >= journeyCost) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.%n", totalSpendings - journeyCost);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", journeyCost - totalSpendings);
        }
    }
}
