package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class ME06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int counterOpeningBracket = 0;
        int counterClosingBracket = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (Math.abs(counterOpeningBracket - counterClosingBracket) == 2 || counterClosingBracket > counterOpeningBracket) {
                break;
            }
            if (input.equals("(")) {
                counterOpeningBracket++;
            }
            if (input.equals(")")) {
                counterClosingBracket++;
            }
        }

        if (counterClosingBracket == counterOpeningBracket) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}


