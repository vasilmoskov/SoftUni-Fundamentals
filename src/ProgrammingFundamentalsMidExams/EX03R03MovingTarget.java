package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX03R03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] inputAsArr = input.split(" ");
            String command = inputAsArr[0];
            int index = Integer.parseInt(inputAsArr[1]);
            int number = Integer.parseInt(inputAsArr[2]);

            if (command.equals("Shoot")) {

                if (index >= 0 && index < targets.size()) {
                    int newValue = targets.get(index) - number;
                    targets.set(index, newValue);

                    if (targets.get(index) <= 0) {
                        targets.remove(index);
                    }
                }

            } else if (command.equals("Add")) {

                if (index >= 0 && index < targets.size()) {
                    targets.add(index, number);
                } else {
                    System.out.println("Invalid placement!");
                }

            } else if (command.equals("Strike")) {
                int radiusReachBeginning = index - number;
                int radiusReachEnding = index + number;

                if (radiusReachBeginning >= 0 && radiusReachEnding < targets.size()) {
                    for (int i = radiusReachEnding; i >= radiusReachBeginning; i--) {
                        targets.remove(i);
                    }

                } else {
                    System.out.println("Strike missed!");
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            System.out.print(targets.get(i));
            if (i != targets.size() - 1) {
                System.out.print("|");
            }
        }

    }
}
