package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX04E01NationalCourt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int timePerson1 = Integer.parseInt(scanner.nextLine());
        int timePerson2 = Integer.parseInt(scanner.nextLine());
        int timePerson3 = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());

        int hours = 0;

        while (peopleCount > 0) {
            hours++;

            if (hours % 4 != 0) {
                peopleCount -= (timePerson1 + timePerson2 + timePerson3);
            }

        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
