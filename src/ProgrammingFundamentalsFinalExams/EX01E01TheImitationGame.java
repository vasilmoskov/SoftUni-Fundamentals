package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;

public class EX01E01TheImitationGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder word = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {

            String[] tokens = input.split("\\|");
            String operation = tokens[0];

            switch (operation) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String substring = word.substring(0, numberOfLetters);
                    word.delete(0, numberOfLetters);
                    word.append(substring);

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    word.insert(index, value); // evtl. value + 1

                    break;
                case "ChangeAll":
                    substring = tokens[1];
                    String replacement = tokens[2];

                    String wordAfterReplacement = word.toString().replace(substring, replacement);
                    word.setLength(0);
                    word.append(wordAfterReplacement);

                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + word);
    }
}
