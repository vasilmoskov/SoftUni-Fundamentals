package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX04E02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] inputAsArr = input.split(" ");
            String command = inputAsArr[0];
            String currentProduct = inputAsArr[1];

            if (command.equals("Urgent")) {

                if (!products.contains(currentProduct)) {
                    products.add(0, currentProduct);
                }

            } else if (command.equals("Unnecessary")) {

                products.remove(currentProduct);

            } else if (command.equals("Correct")) {

                String newName = inputAsArr[2];

                if (products.contains(currentProduct)) {
                    int index = products.indexOf(currentProduct);
                    products.set(index, newName);
                }

            } else if (command.equals("Rearrange")) {

                if (products.contains(currentProduct)) {
                    products.add(currentProduct);
                    products.remove(currentProduct);
                }

            }


            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", products));
    }
}
