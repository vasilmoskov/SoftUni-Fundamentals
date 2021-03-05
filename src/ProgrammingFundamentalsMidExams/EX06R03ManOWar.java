package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Scanner;

public class EX06R03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ship = Arrays.stream(scanner.nextLine().split(">")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] warship = Arrays.stream(scanner.nextLine().split(">")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int maximumHealthCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        boolean stalemate = true;

        while (!command.equals("Retire")) {
            if (!stalemate) {
                break;
            }
            String[] commandAsArr = command.split(" ");
            String action = commandAsArr[0];

            if (action.equals("Fire")) {
                int index = Integer.parseInt(commandAsArr[1]);
                int damage = Integer.parseInt(commandAsArr[2]);

                if (index >= 0 && index < warship.length) {
                    warship[index] -= damage;
                    if (warship[index] <= 0) {
                        stalemate = false;
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }

            } else if (action.equals("Defend")) {
                int startIndex = Integer.parseInt(commandAsArr[1]);
                int endIndex = Integer.parseInt(commandAsArr[2]);
                int damage = Integer.parseInt(commandAsArr[3]);

                if (startIndex >= 0 && startIndex < ship.length && endIndex >= 0 && endIndex < ship.length) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        ship[i] -= damage;
                        if (ship[i] <= 0) {
                            stalemate = false;
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }

            } else if (action.equals("Repair")) {
                int index = Integer.parseInt(commandAsArr[1]);
                int health = Integer.parseInt(commandAsArr[2]);

                if (index >= 0 && index < ship.length) {
                    ship[index] += health;
                    if (ship[index] > maximumHealthCapacity) {
                        ship[index] = maximumHealthCapacity;
                    }
                }


            } else if (action.equals("Status")) {

                double lowHealth = maximumHealthCapacity * 0.2;
                int countShipsThatNeedRepair = 0;

                for (int i = 0; i < ship.length; i++) {
                    if (ship[i] < lowHealth) {
                        countShipsThatNeedRepair++;
                    }
                }

                System.out.printf("%d sections need repair.%n", countShipsThatNeedRepair);

            }

            command = scanner.nextLine();
        }

        if (stalemate) {
            int worshipSectionsSum = 0;
            int myShipSectionsSum = 0;

            for (int i = 0; i < warship.length; i++) {
                worshipSectionsSum += warship[i];
            }

            for (int i = 0; i < ship.length; i++) {
                myShipSectionsSum += ship[i];
            }

            System.out.printf("Pirate ship status: %d%n", myShipSectionsSum);
            System.out.printf("Warship status: %d%n", worshipSectionsSum);
        }
    }
}
