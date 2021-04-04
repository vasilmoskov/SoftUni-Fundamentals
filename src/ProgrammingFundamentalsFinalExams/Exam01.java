package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder username = new StringBuilder(scanner.nextLine().trim());

        String command = scanner.nextLine().trim();

        while (!command.equals("Sign up")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Case":
                    String type = tokens[1];

                    if (type.equals("lower")) {
                        String newWord = username.toString().toLowerCase();
                        username.setLength(0);
                        username.append(newWord);
                    } else if (type.equals("upper")) {
                        String newWord = username.toString().toUpperCase();
                        username.setLength(0);
                        username.append(newWord);
                    }

                    System.out.println(username);

                    break;

                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex < username.length()) {

                        String substring = username.substring(startIndex, endIndex + 1);

                        StringBuilder reversedWord = new StringBuilder();

                        for (int i = substring.length() - 1; i >= 0; i--) {
                            reversedWord.append(substring.charAt(i));
                        }

                        System.out.println(reversedWord);
                        reversedWord.setLength(0);
                    }


                    break;

                case "Cut":
                    String substring = tokens[1];

                    if (username.toString().contains(substring)) {
                        String newWord = username.toString().replace(substring, "");
                        username.setLength(0);
                        username.append(newWord);
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username, substring);
                    }

                    break;

                case "Replace":
                    char ch = tokens[1].charAt(0);

                    String newWord = username.toString().replace(ch, '*');
                    username.setLength(0);
                    username.append(newWord);
                    System.out.println(username);

                    break;

                case "Check":
                    String letter = tokens[1];

                    if (username.indexOf(letter) == -1) {
                        System.out.println("Your username must contain " + letter + ".");
                    } else {
                        System.out.println("Valid");
                    }

                    break;
            }


            command = scanner.nextLine();
        }
    }
}
