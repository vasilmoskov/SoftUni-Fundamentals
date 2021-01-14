package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E07VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2|| coin == 0.5|| coin == 1.0|| coin == 2.0) {
                sum += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        double priceCurrentProduct = 0;

        boolean validProduct = true;

        while (!secondInput.equals("End")) {

            switch (secondInput) {
                case "Nuts":
                    priceCurrentProduct=2.0;
                    break;
                case "Water":
                    priceCurrentProduct=0.7;
                    break;
                case "Crisps":
                    priceCurrentProduct=1.5;
                    break;
                case "Soda":
                    priceCurrentProduct=0.8;
                    break;
                case "Coke":
                    priceCurrentProduct=1.0;
                    break;
                default:
                    validProduct = false;
                    System.out.println("Invalid product");
                    break;
            }
            if (sum < priceCurrentProduct) {
                System.out.println("Sorry, not enough money");
            } else if (validProduct){
                sum -= priceCurrentProduct;
                System.out.printf("Purchased %s%n", secondInput);
            }
            secondInput = scanner.nextLine();
        }

        if (sum >= 0) {
            System.out.printf("Change: %.2f", sum);
        }
    }
}
