package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX05E03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            String[] commandAsArray = command.split(" - ");
            String action = commandAsArray[0];
            String item = commandAsArray[1];

            if (action.equals("Collect")) {

                if (!items.contains(item)) {
                    items.add(item);
                }

            } else if (action.equals("Drop")) {
                items.remove(item);

            } else if (action.equals("Combine Items")) {
                String [] twoItems = item.split(":");
                String oldItem = twoItems[0];
                String newItem = twoItems[1];

                if (items.contains(oldItem)) {
                    int indexToPutNewItem = items.indexOf(oldItem) + 1;
                    items.add(indexToPutNewItem, newItem);
                }

            } else if (action.equals("Renew")) {
                if (items.contains(item)) {
                    items.add(item);
                    items.remove(item);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", items));
    }
}
