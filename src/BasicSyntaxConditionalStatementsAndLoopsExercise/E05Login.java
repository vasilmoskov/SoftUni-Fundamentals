package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E05Login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String account = scanner.nextLine();

        String reverse = "";


        for (int i = account.length() - 1; i >= 0; i--) {
            // - 1 защото символите са от 0 до 3, а иначе дължината на думата е 4
            reverse = reverse + account.charAt(i);
        }

        String currentTry = scanner.nextLine();

        int counter = 0;

        boolean loggedIn = true;

        while (!currentTry.equals(reverse)) {
            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", account);
                loggedIn = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            currentTry = scanner.nextLine();
        }
        if (loggedIn) {
            System.out.printf("User %s logged in.", account);
        }
    }
}