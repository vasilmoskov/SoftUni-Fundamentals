package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX02E01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = Integer.parseInt(scanner.nextLine());
        int employee2 = Integer.parseInt(scanner.nextLine());
        int employee3 = Integer.parseInt(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());

        int hours = 0;

        while (countStudents > 0) {

            hours++;

            if (hours%4 != 0) {
                countStudents -= (employee1 + employee2 + employee3);
            }

        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
