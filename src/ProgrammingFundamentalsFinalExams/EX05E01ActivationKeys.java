package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;

public class EX05E01ActivationKeys {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("Generate")) {
            String[] tokens = inputCommand.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];

                    if (input.toString().contains(substring)) {
                        System.out.println(input + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }

                    break;
                case "Flip":
                    String type = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    if (type.equals("Upper")) {
                        String replacement = input.substring(startIndex, endIndex).toUpperCase();
                        input.replace(startIndex, endIndex, replacement);
                    } else if (type.equals("Lower")) {
                        String replacement = input.substring(startIndex, endIndex).toLowerCase();
                        input.replace(startIndex, endIndex, replacement);
                    }

                    System.out.println(input);

                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);

                    input.replace(startIndex, endIndex, "");

                    System.out.println(input);

                    break;

            }

            inputCommand = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + input);
    }
}
