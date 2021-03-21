package RegularExpressionsExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split("[,\\s]+")).collect(Collectors.toList());

        Collections.sort(participants);

        String regexHealth = "[^0-9\\+\\-\\/\\*\\.]";
        Pattern patternHealth = Pattern.compile(regexHealth);

        String regexDamage = "\\-?[0-9]+\\.?([0-9]+)?";
        Pattern patternDamage = Pattern.compile(regexDamage);

        for (int i = 0; i < participants.size(); i++) {
            String currentWord = participants.get(i);
            int demonsHealth = 0;
            double demonsDamage = 0;

            Matcher matcherHealth = patternHealth.matcher(currentWord);
            while (matcherHealth.find()) {
                char currentLetter = matcherHealth.group().charAt(0);
                demonsHealth += currentLetter;
            }

            Matcher matcherDamage = patternDamage.matcher(currentWord);
            while (matcherDamage.find()) {
                demonsDamage += Double.parseDouble(matcherDamage.group());
            }

            String regexMultipliers = "\\*";
            Pattern patternMultipliers = Pattern.compile(regexMultipliers);
            Matcher matcherMultipliers = patternMultipliers.matcher(currentWord);

            while (matcherMultipliers.find()) {
                demonsDamage *= 2;
            }

            String regexDividers = "\\/";
            Pattern patternDividers = Pattern.compile(regexDividers);
            Matcher matcherDividers = patternDividers.matcher(currentWord);

            while (matcherDividers.find()) {
                demonsDamage /= 2;
            }

            System.out.printf("%s - %d health, %.2f damage%n", participants.get(i), demonsHealth, demonsDamage);
        }
    }
}
