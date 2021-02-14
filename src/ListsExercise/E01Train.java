package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> inputAsStringList = Arrays.stream(input.split(" ")).collect(Collectors.toList());

        List<Integer> wagons = new ArrayList<>();
        for (int i = 0; i < inputAsStringList.size(); i++) {
            wagons.add(Integer.parseInt(inputAsStringList.get(i)));
        }

        int maxCapacity = Integer.parseInt (scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.contains("Add")) {
                String [] passengersToBeAdded = command.split(" ");
                wagons.add(Integer.parseInt(passengersToBeAdded[1]));
                //System.out.println();
            } else {
                int passengers = Integer.parseInt (command);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passengers <= maxCapacity) {
                        wagons.set(i, wagons.get(i)+ passengers);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));

    }
}
