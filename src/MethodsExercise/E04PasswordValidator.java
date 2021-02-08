package MethodsExercise;

import java.util.Scanner;

public class E04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!passwordLengthIsSufficient(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!passwordConsistOnlyOfLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!passwordHasAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (passwordLengthIsSufficient(password) && passwordConsistOnlyOfLettersAndDigits(password)&& passwordHasAtLeastTwoDigits(password)) {
            System.out.println("Password is valid");
        }

    }

    static boolean passwordLengthIsSufficient(String password) {
        // boolean passwordLengthIsSufficient = true;
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    static boolean passwordConsistOnlyOfLettersAndDigits(String password) {
        boolean passwordHasOtherSymbols = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57 || password.charAt(i) >= 65 && password.charAt(i) <= 90 || password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                passwordHasOtherSymbols = false;
            } else {
                passwordHasOtherSymbols = true;
                break;
            }
        }
        if (passwordHasOtherSymbols) {
            return false;
        } else {
            return true;
        }
    }

    static boolean passwordHasAtLeastTwoDigits(String password) {
        boolean passwordHasLessThanTwoDigits = false;
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                countDigits++;
            }
        }
        if (countDigits >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
