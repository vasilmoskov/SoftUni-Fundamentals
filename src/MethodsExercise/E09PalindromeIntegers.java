package MethodsExercise;

import java.util.Scanner;

public class E09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.println(palindrome(input));
            input = scanner.nextLine();
        }
    }

    static boolean palindrome (String input) {
        String inputReversed = "";
        for (int i = input.length()-1; i >= 0 ; i--) {
            inputReversed += input.charAt(i);
        }
        if (input.equals(inputReversed)) {
            return true;
        } else {
            return false;
        }
    }
}
