package ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class L04ListManipulationBasics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandAsArr = command.split(" ");
            String operation = commandAsArr[0];

            switch (operation) {
                case "Add" -> {
                    int number = Integer.parseInt(commandAsArr[1]);
                    numbers.add(number);

                    break;
                }
                case "Remove" -> {
                    int number = Integer.parseInt(commandAsArr[1]);
                    numbers.remove((Object) number);

                    break;
                }
                case "RemoveAt" -> {
                    int index = Integer.parseInt(commandAsArr[1]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.remove(index);
                    }

                    break;
                }
                case "Insert" -> {
                    int number = Integer.parseInt(commandAsArr[1]);
                    int index = Integer.parseInt(commandAsArr[2]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, number);
                    }

                    break;
                }
            }

            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }
}