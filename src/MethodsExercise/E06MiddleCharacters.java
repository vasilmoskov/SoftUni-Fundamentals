package MethodsExercise;

import java.util.Scanner;

public class E06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleCharacter(input);
    }

    static void printMiddleCharacter(String input) {
        int middle = input.length() / 2;
        if (input.length() % 2 == 1) {
            System.out.println(input.charAt(middle));
        } else {
            System.out.print(input.charAt(middle-1) + "" + input.charAt(middle));
        }

    }
}
