package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME02Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String command = input.split(" ")[0];
            String item = input.split(" ")[1];

            switch (command) {
                case "Urgent":
                    if (!products.contains(item)) {
                        products.add(0, item);
                    }
                    break;

                case "Unnecessary":
                    products.remove(item);
                    break;

                case "Correct":
                    String newItem = input.split(" ")[2];
                    if (products.contains(item)) {
                        products.set(products.indexOf(item), newItem);
                    }
                    break;

                case "Rearrange":
                    if (products.contains(item)) {
                        products.add(item);
                        products.remove(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", products));

    }
}
