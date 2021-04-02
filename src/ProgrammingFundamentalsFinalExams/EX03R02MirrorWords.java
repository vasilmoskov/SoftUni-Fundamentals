package ProgrammingFundamentalsFinalExams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX03R02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> mirrorWords = new LinkedHashMap<>();

        String regex = "([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int pairsFound = 0;

        while (matcher.find()) {
            pairsFound++;

            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");

            StringBuilder wordTwoReversed = new StringBuilder();

            for (int i = wordTwo.length() - 1; i >= 0; i--) {
                wordTwoReversed.append(wordTwo.charAt(i));
            }

            if (wordOne.equals(wordTwoReversed.toString())) {
                mirrorWords.put(wordOne, wordTwo);
            }

            wordTwoReversed.setLength(0);
        }

        if (pairsFound == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairsFound + " word pairs found!");
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");

            int loops = 0;
            for (Map.Entry<String, String> entry : mirrorWords.entrySet()) {

                if (loops != 0) {
                    System.out.print(", ");
                }

                System.out.print(entry.getKey() + " <=> " + entry.getValue());

                loops++;
            }

        }
    }
}
