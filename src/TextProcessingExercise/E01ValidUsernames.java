package TextProcessingExercise;

import java.util.Scanner;

public class E01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            String currentWord = input[i];
            if (currentWord.length() >= 3 && currentWord.length() <= 16) {
                boolean wordConsistsForbiddenCharacter = false;
                for (int j = 0; j < currentWord.length(); j++) {
                    if ((currentWord.charAt(j) >= 65 && currentWord.charAt(j) <= 90)
                            || (currentWord.charAt(j) >= 97 && currentWord.charAt(j) <= 122)
                            || (currentWord.charAt(j) >= 48 && currentWord.charAt(j) <= 57)
                            || currentWord.charAt(j) == 45
                            || currentWord.charAt(j) == 95) {
                    } else {
                        wordConsistsForbiddenCharacter = true;
                        break;
                    }
                }
                if (!wordConsistsForbiddenCharacter) {
                    System.out.println(currentWord);
                }
            }
        }
    }
}
