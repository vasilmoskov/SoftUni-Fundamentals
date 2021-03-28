package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;

public class EX03R01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder concealedMessage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String [] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt (tokens[1]);
                    concealedMessage.insert(index, " ");
                    System.out.println(concealedMessage);
                    break;

                case "Reverse":
                    String substring = tokens[1];

                    if (concealedMessage.toString().contains(substring)) {

                        StringBuilder substringReversed = new StringBuilder();

                        for (int i = substring.length()-1; i >= 0 ; i--) {
                            substringReversed.append(substring.charAt(i));
                        }

                        int startIndex = concealedMessage.indexOf(substring);
                        int endIndex = concealedMessage.indexOf(substring) + substring.length();

                        concealedMessage.replace(startIndex, endIndex, "");
                        concealedMessage.append(substringReversed);
                        System.out.println(concealedMessage);
                        substringReversed.setLength(0);

                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    substring = tokens [1];
                    String replacement = tokens[2];
                    String newConcealedMessage = concealedMessage.toString().replaceAll(substring, replacement);
                    concealedMessage.setLength(0);
                    concealedMessage.append(newConcealedMessage);
                    System.out.println(concealedMessage);
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + concealedMessage);


    }
}
