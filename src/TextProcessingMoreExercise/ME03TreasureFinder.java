package TextProcessingMoreExercise;

import java.util.Scanner;

public class ME03TreasureFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String key = String.join("", scanner.nextLine().split(" "));

        String input = scanner.nextLine();

        while (!input.equals("find")) {

            StringBuilder currentWord = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {

                int indexForKeyWord = i;

                while (indexForKeyWord >= key.length()) {
                    indexForKeyWord -= key.length();
                }

                char currentChar = (char) (input.charAt(i) - Integer.parseInt(String.valueOf(key.charAt(indexForKeyWord))));
                currentWord.append(currentChar);
            }

            int typeStart = currentWord.toString().indexOf('&');
            int typeEnd = currentWord.toString().lastIndexOf('&');

            int coordinatesStart = currentWord.toString().indexOf('<');
            int coordinatesEnd = currentWord.toString().indexOf('>');

            String type = currentWord.substring(typeStart + 1, typeEnd);
            String coordinates = currentWord.substring(coordinatesStart + 1, coordinatesEnd);

            System.out.printf("Found %s at %s%n", type, coordinates);

            currentWord.setLength(0);

            input = scanner.nextLine();
        }

    }
}
