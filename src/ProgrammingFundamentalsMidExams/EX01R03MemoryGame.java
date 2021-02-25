package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX01R03MemoryGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        int moves = 0;

        boolean youWon = false;

        while (!input.equals("end")) {
            String[] inputAsArr = input.split(" ");
            int index1 = Integer.parseInt(inputAsArr[0]);
            int index2 = Integer.parseInt(inputAsArr[1]);

            moves++;

            if (index1 == index2 || index1 < 0 || index2 < 0 || index1 >= elements.size() || index2 >= elements.size()) {
                System.out.println("Invalid input! Adding additional elements to the board");

                int indexToAddNumbers = elements.size() / 2;
                String elementToAdd = String.format("-%da", moves);
                elements.add(indexToAddNumbers, elementToAdd);
                elements.add(indexToAddNumbers, elementToAdd);

            } else if (elements.get(index1).equals(elements.get(index2))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", elements.get(index1));
                if (index1 > index2) {
                    elements.remove(index1);
                    elements.remove(index2);
                } else {
                    elements.remove(index2);
                    elements.remove(index1);
                }
            } else if (!elements.get(index1).equals(elements.get(index2))) {
                System.out.println("Try again!");
            }

            if (elements.isEmpty()) {
                youWon = true;
                break;
            }


            input = scanner.nextLine();
        }

        if (youWon) {
            System.out.printf("You have won in %d turns!", moves);
        } else {
            System.out.println("Sorry you lose :(");
            for (String element : elements) {
                System.out.print(element + " ");
            }
        }

    }
}
