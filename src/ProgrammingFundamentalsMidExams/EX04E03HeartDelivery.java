package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Scanner;

public class EX04E03HeartDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@")).mapToInt(e -> Integer.parseInt(e)).toArray();

        String input = scanner.nextLine();

        int lastPosition = 0;
        int currentHouse = 0;

        while (!input.equals("Love!")) {
            String[] inputAsArr = input.split(" ");
            int jumpLength = Integer.parseInt(inputAsArr[1]);

            currentHouse += jumpLength;

            if (currentHouse >= neighborhood.length) {
                currentHouse = 0;
            }

            lastPosition = currentHouse;

            if (neighborhood[currentHouse] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentHouse);
            } else {
                neighborhood[currentHouse] -= 2;
                if (neighborhood[currentHouse] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentHouse);
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", lastPosition);

        int countHousesThatDidNotCelebrate = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            if (neighborhood[i] != 0) {
                countHousesThatDidNotCelebrate++;
            }
        }

        if (countHousesThatDidNotCelebrate == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", countHousesThatDidNotCelebrate);
        }
    }
}
