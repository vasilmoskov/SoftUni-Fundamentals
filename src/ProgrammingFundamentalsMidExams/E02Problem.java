package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friends = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Report")) {
            String[] inputAsArr = input.split(" ");
            String command = inputAsArr[0];

            if (command.equals("Blacklist")) {
                String name = inputAsArr[1];

                if (!friends.contains(name)) {
                    System.out.println(name + " was not found.");
                } else {
                    int indexOfName = friends.indexOf(name);
                    friends.set(indexOfName, "Blacklisted");
                    System.out.println(name + " was blacklisted.");
                }

            } else if (command.equals("Error")) {
                int index = Integer.parseInt(inputAsArr[1]);

                if (index >= 0 && index < friends.size()) {
                    String name = friends.get(index);
                    if (!name.equals("Blacklisted") && !name.equals("Lost")) {
                        friends.set(index, "Lost");
                        System.out.println(name + " was lost due to an error.");
                    }
                }

            } else if (command.equals("Change")) {
                int index = Integer.parseInt(inputAsArr[1]);
                String newName = inputAsArr[2];

                if (index >= 0 && index < friends.size()) {

                    String oldName = friends.get(index);

                    friends.set(index, newName);

                    System.out.println(oldName + " changed his username to "+ newName +".");

                }


            }

            input = scanner.nextLine();
        }

        int countBlacklisted = 0;
        int countLost = 0;

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals("Blacklisted")){
                countBlacklisted++;
            } else if (friends.get(i).equals("Lost")) {
                countLost++;
            }
        }

        System.out.println("Blacklisted names: " + countBlacklisted);
        System.out.println("Lost names: " + countLost);
        System.out.println(String.join(" ", friends));
    }

}