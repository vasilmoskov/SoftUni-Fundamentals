package MapsLambdaAndStreamAPIExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputAsArrayString = scanner.nextLine().split(" ");

        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < inputAsArrayString.length; i++) {
            String currentWord = inputAsArrayString[i];
            for (int j = 0; j < currentWord.length(); j++) {
                char currentSymbol = currentWord.charAt(j);
                if (!counts.containsKey(currentSymbol)) {
                    counts.put(currentSymbol, 0);
                }
                counts.put(currentSymbol, counts.get(currentSymbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
