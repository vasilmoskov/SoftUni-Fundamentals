package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class ME03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scanner.nextLine());

        String currentGame = scanner.nextLine();

        double priceGame = 0;
        double totalSpent = 0;
        boolean gameFound = true;

        while (!currentGame.equals("Game Time")) {
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }
            gameFound = true;
            switch (currentGame) {
                case "OutFall 4":
                    priceGame = 39.99;
                    break;
                case "CS: OG":
                    priceGame = 15.99;
                    break;
                case "Zplinter Zell":
                    priceGame = 19.99;
                    break;
                case "Honored 2":
                    priceGame = 59.99;
                    break;
                case "RoverWatch":
                    priceGame = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    priceGame = 39.99;
                    break;
                default:
                    gameFound = false;
                    System.out.println("Not Found");
            }
            if (gameFound) {
                if (currentBalance >= priceGame) {
                    System.out.printf("Bought %s%n", currentGame);
                    totalSpent += priceGame;
                    currentBalance -= priceGame;
                } else {
                    System.out.println("Too Expensive");
                }
            }
            currentGame = scanner.nextLine();
        }
        if (currentBalance == 0) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
        }
    }
}
