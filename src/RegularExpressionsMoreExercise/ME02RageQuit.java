package RegularExpressionsMoreExercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<Character> uniqueSymbols = new HashSet<>();
        StringBuilder finalString = new StringBuilder();

        StringBuilder currentString = new StringBuilder();

        Pattern patternForStrings = Pattern.compile("[^\\d]+");
        Pattern patternForNumbers = Pattern.compile("[\\d]+");

        Matcher matcherForStrings = patternForStrings.matcher(input);
        Matcher matcherForNumbers = patternForNumbers.matcher(input);

        while (matcherForStrings.find()) {
            String currentWord = matcherForStrings.group();
            int repetitions = 0;

            if (matcherForNumbers.find()) {
                repetitions = Integer.parseInt(matcherForNumbers.group());
            }

            for (int i = 0; i < repetitions; i++) {
                finalString.append(currentWord.toUpperCase());
            }
        }

        for (int i = 0; i < finalString.length(); i++) {
            uniqueSymbols.add(finalString.charAt(i));
        }

        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(finalString);
    }
}
