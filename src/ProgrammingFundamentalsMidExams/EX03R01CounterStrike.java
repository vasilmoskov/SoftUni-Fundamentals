package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX03R01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int wonBattles = 0;

        String input = scanner.nextLine();

        boolean gameLost = false;

        while (!input.equals("End of battle")) {
            int currentDistance = Integer.parseInt(input);

            if (energy - currentDistance < 0) {
                gameLost = true;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wonBattles, energy);
                break;
            } else {

                energy -= currentDistance;
                wonBattles++;

                if (wonBattles % 3 == 0) {
                    energy += wonBattles;
                }
            }


            input = scanner.nextLine();
        }

        if (!gameLost) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
        }
    }
}
