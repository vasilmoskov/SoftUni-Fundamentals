package TextProcessingExercise;

import java.util.Scanner;

public class E08LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        double totalSum = 0;

        for (int i = 0; i < strings.length; i++) {

            String currentWord = strings[i];
            totalSum += getResult(currentWord);

        }

        System.out.printf("%.2f", totalSum);

    }

    public static double getResult(String word) {
        double sum = 0;

        char letterBeforeTheNumber = word.charAt(0);
        char letterAfterTheNumber = word.charAt(word.length() - 1);

        double numberInBetween = Integer.parseInt(word.substring(1, word.length() - 1));

        if (Character.isUpperCase(letterBeforeTheNumber)) {
            int positionOfTheLetterInTheAlphabet = letterBeforeTheNumber - 64;

            sum += numberInBetween / positionOfTheLetterInTheAlphabet;

        } else if (Character.isLowerCase(letterBeforeTheNumber)) {
            int positionOfTheLetterInTheAlphabet = letterBeforeTheNumber - 96;

            sum += numberInBetween * positionOfTheLetterInTheAlphabet;

        }

        if (Character.isUpperCase(letterAfterTheNumber)) {
            int positionOfTheLetterInTheAlphabet = letterAfterTheNumber - 64;

            sum -= positionOfTheLetterInTheAlphabet;

        } else if (Character.isLowerCase(letterAfterTheNumber)) {
            int positionOfTheLetterInTheAlphabet = letterAfterTheNumber - 96;

            sum += positionOfTheLetterInTheAlphabet;

        }

        return sum;
    }
}
