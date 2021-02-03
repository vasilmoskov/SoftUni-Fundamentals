package MethodsLab;

import java.util.Scanner;

public class L07RepeatString {

    static String repeatString (String input, int repetitions) {
        String newString = "";
        for (int i = 0; i < repetitions; i++) {
            newString += input;
        }
        return newString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repetitions = Integer.parseInt (scanner.nextLine());
        System.out.println(repeatString(input, repetitions));
    }
}
