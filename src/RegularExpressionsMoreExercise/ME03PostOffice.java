package RegularExpressionsMoreExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME03PostOffice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");

        String regexFirstPart = "([\\#\\$\\%\\*\\&])[A-Z]+\\1";

        Pattern pattern = Pattern.compile(regexFirstPart);
        Matcher matcher = pattern.matcher(input[0]);

        String firstPart = "";

        while (matcher.find()) {
            String match = matcher.group();
            firstPart = match.substring(1, match.length() - 1);
        }

        String regexSecondPart = "\\d+:\\d{2}";
        List<String> secondPart = new ArrayList<>();

        pattern = Pattern.compile(regexSecondPart);
        matcher = pattern.matcher(input[1]);

        while (matcher.find()) {
            secondPart.add(matcher.group());
        }

        Map<Integer, Integer> wordsLength = new LinkedHashMap<>();

        for (int i = 0; i < secondPart.size(); i++) {
            String[] tokens = secondPart.get(i).split(":");

            int asciiCode = Integer.parseInt(tokens[0]);
            int number = Integer.parseInt(tokens[1]);

            for (int j = 0; j < firstPart.length(); j++) {
                // A 65 M 77 L 76
                if (asciiCode == firstPart.charAt(j)) {
                    wordsLength.put(asciiCode, number + 1);
                }
            }
        }


        String[] wordsThirdPart = input[2].split("\\s+");

        for (int i = 0; i < wordsThirdPart.length; i++) {
            String currentWord = wordsThirdPart[i];

            for (Map.Entry<Integer, Integer> entry : wordsLength.entrySet()) {
                if (currentWord.charAt(0) == entry.getKey() && currentWord.length() == entry.getValue()) {
                    System.out.println(currentWord);
                }
            }
        }
    }
}
