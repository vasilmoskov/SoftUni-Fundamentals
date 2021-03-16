package TextProcessingExercise;

import java.util.Scanner;

public class E06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder currentSequence = new StringBuilder();
        StringBuilder newWord = new StringBuilder();


        for (int i = 1; i < input.length(); i++) {

            char lastLetter = input.charAt(i - 1);
            char currentLetter = input.charAt(i);

            if (lastLetter == currentLetter) {
                currentSequence.append(lastLetter);
                if (i == input.length()-1) {
                    newWord.append(currentLetter);
                }
            } else {
                currentSequence.append(lastLetter);
                String replacement = String.valueOf(lastLetter);
                newWord.append(currentSequence);
                int start = newWord.length() - currentSequence.length();
                int end = newWord.length();
                newWord.replace(start, end, replacement);
                if (i == input.length()-1) {
                    newWord.append(currentLetter);
                }
                currentSequence.setLength(0);
            }
        }

        System.out.println(newWord);
    }
}
