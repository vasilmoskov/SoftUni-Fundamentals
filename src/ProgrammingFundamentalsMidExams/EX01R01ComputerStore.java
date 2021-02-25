package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX01R01ComputerStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double totalWithoutTaxes = 0;

        while (!command.equals("special") && !command.equals("regular")) {
            double priceOfCurrentProduct = Double.parseDouble(command);
            if (priceOfCurrentProduct <= 0) {
                System.out.println("Invalid price!");
            } else {
                totalWithoutTaxes += priceOfCurrentProduct;
            }

            command = scanner.nextLine();
        }

        if (totalWithoutTaxes == 0) {
            System.out.println("Invalid order!");
        } else {
            double taxes = totalWithoutTaxes * 0.2;
            double totalWithTaxes = totalWithoutTaxes + taxes;

            if (command.equals("special")) {
                totalWithTaxes *= 0.9;
            }

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalWithTaxes);

        }
    }
}
