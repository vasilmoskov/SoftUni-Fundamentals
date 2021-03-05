package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX06R02TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<String> items = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {

            String[] commandAsArr = command.split(" ");

            String action = commandAsArr[0];

            if (action.equals("Loot")) {
                for (int i = 1; i < commandAsArr.length; i++) {
                    String currentItem = commandAsArr[i];
                    if (!items.contains(currentItem)) {
                        items.add(0, currentItem);
                    }
                }

            } else if (action.equals("Drop")) {
                int index = Integer.parseInt(commandAsArr[1]);

                if (index >= 0 && index < items.size()) {
                    String element = items.get(index);
                    items.add(element);
                    items.remove(index);
                }

            } else if (action.equals("Steal")) {

                int count = Integer.parseInt(commandAsArr[1]);

                if (count >= items.size()) {
                    System.out.println(String.join(", ", items));
                    items.clear();

                } else {
                    while (count>0) {
                        String currentItem = items.get(items.size() - count);
                        System.out.print(currentItem);
                        items.remove(currentItem);
                        count--;
                        if (count != 0) {
                            System.out.print(", ");
                        } else {
                            System.out.println();
                        }
                    }

                }

            }


            command = scanner.nextLine();
        }

        if (items.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageGain = 0;

            for (int i = 0; i < items.size(); i++) {
                String currentItem = items.get(i);
                averageGain += currentItem.length();
            }

            averageGain /= items.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);

        }


    }
}
