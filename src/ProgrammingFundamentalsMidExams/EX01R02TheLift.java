package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Scanner;

public class EX01R02TheLift {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        int[] lifts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean notEnoughSpace = false;

        while (people > 0) {
            for (int i = 0; i < lifts.length; i++) {
                while (lifts[i] < 4 && people != 0) {
                    lifts[i] += 1;
                    people--;
                }
            }
            if (people > 0) {
                notEnoughSpace = true;
                break;
            }

        }

        if (notEnoughSpace) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }

        int emptySpaces = 0;

        for (int i = 0; i < lifts.length; i++) {
            if (lifts[i] != 4) {
                emptySpaces += (4 - lifts[i]);
            }
        }

        if (emptySpaces > 0) {
            System.out.println("The lift has empty spots!");
        }

        for (int lift : lifts) {
            System.out.print(lift + " ");
        }

    }
}
