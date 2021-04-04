package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\@\\*])(?<tag>[A-Z][a-z]{2,})\\1: (?<letters>\\[[A-Za-z]\\]\\|\\[[A-Za-z]\\]\\|\\[[A-Za-z]\\]\\|)$";

        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String message = matcher.group("letters");

                System.out.printf("%s: ", tag);

                for (int j = 0; j < message.length(); j++) {
                    if (Character.isLetter(message.charAt(j))) {
                        int code = message.charAt(j);
                        System.out.printf("%d ", code);
                    }
                }

                System.out.println();



            } else {
                System.out.println("Valid message not found!");
            }

        }


    }
}



/*
            if (matcher.find()) {
                String tag = matcher.group("tag");
                String [] message = matcher.group("letters").split("[\\[\\|\\]]+");

                System.out.printf("%s: ", tag);


                int [] encryptedMessage = new int[message.length];

                for (int j = 0; j < message.length; j++) {
                    encryptedMessage[j] = message[j].charAt(j);
                    System.out.printf("%d ", encryptedMessage[j]);
                }

                System.out.println();
 */