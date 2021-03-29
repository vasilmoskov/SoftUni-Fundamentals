package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;

public class EX04E01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Done")) {

            String[] tokens = command.split(" ");

            String action = tokens[0];

            switch (action) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();

                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            char currentChar = password.charAt(i);
                            newPassword.append(currentChar);
                        }
                    }

                    password = newPassword;

                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt (tokens[1]);
                    int length = Integer.parseInt (tokens[2]);

                    //String substring = password.substring(index, index+length);

                    password.delete(index, index + length);
                    System.out.println(password);

                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    boolean substituted = false;

                    while (password.indexOf(substring) != -1) {
                        substituted = true;
                        int startIndex = password.indexOf(substring);
                        int endIndex = password.indexOf(substring) + substring.length();
                        password.replace(startIndex, endIndex, substitute);
                    }

                    if (!substituted){
                        System.out.println("Nothing to replace!");
                    } else {
                        System.out.println(password);
                    }

                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}
