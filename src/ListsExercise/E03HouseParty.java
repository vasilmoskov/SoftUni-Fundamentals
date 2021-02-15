package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] currentCommand = scanner.nextLine().split(" ");
            String name = currentCommand[0];
            if (currentCommand[2].equals("going!")) {
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }
            } else if (currentCommand[2].equals("not")){
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        for (String guest:guests) {
            System.out.println(guest);
        }

    }
}