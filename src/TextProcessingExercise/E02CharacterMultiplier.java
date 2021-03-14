package TextProcessingExercise;

import java.util.Scanner;

public class E02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputAsArray = scanner.nextLine().split(" ");

        String firstWord = inputAsArray[0];
        String secondWord = inputAsArray[1];

        printSum(firstWord, secondWord);

    }

    static void printSum (String s1, String s2) {
        int smallerNumber = Math.min(s1.length(), s2.length());

        int sum = 0;

        for (int i = 0; i < smallerNumber; i++) {
            int multiplication = s1.charAt(i) * s2.charAt(i);
            sum += multiplication;
        }

        if (s1.length()>s2.length()) {
            int rest = s1.length() - s2.length();
            int startingIndex = s1.length() - rest;
            for (int i = startingIndex; i < s1.length(); i++) {
                sum += s1.charAt(i);
            }
        } else {
            int rest = s2.length() - s1.length();
            int startingIndex = s2.length() - rest;
            for (int i = startingIndex; i < s2.length(); i++) {
                sum += s2.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
