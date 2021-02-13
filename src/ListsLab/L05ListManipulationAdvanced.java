package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> numbersAsStrings = Arrays.stream(input.split(" ")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsStrings.size(); i++) {
            numbers.add(Integer.parseInt(numbersAsStrings.get(i)));
        }
        String command = scanner.nextLine();

        int sum = 0;

        while (!command.equals("end")) {
            List<String> commandAsString = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            switch (commandAsString.get(0)) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(commandAsString.get(1)))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (commandAsString.get(1)) {
                        case "even":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) % 2 == 0) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case "odd":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) % 2 == 1) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    for (int i = 0; i < numbers.size(); i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (commandAsString.get(1)) {
                        case "<":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) < Integer.parseInt(commandAsString.get(2))) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) <= Integer.parseInt(commandAsString.get(2))) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) > Integer.parseInt(commandAsString.get(2))) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) >= Integer.parseInt(commandAsString.get(2))) {
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
