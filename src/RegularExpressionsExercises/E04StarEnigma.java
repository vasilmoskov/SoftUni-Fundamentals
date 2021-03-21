package RegularExpressionsExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String currentMessage = scanner.nextLine();
            int key = 0;

            String regexStar = "[SsTtAaRr]";
            Pattern patternStar = Pattern.compile(regexStar);
            Matcher matcherStar = patternStar.matcher(currentMessage);

            while (matcherStar.find()) {
                key++;
            }

            StringBuilder decryptedWord = new StringBuilder();

            for (int j = 0; j < currentMessage.length(); j++) {
                decryptedWord.append((char) (currentMessage.charAt(j) - key));
            }

            //String regex = "@(?<planetName>[A-Za-z]+)\\d?:(?<population>\\d+)!(?<attackType>[A-Z])!->(?<soldierCount>\\d+)";
            //regex [^@\-!:>]? between each part ?

            String regex = "@(?<planetName>[A-z]+)[^\\@\\-\\!\\:\\>]*:(?<population>\\d+)[^\\@\\-\\!\\:\\>]*!(?<attackType>[AD])![^\\@\\-\\!\\:\\>]*->(?<soldiersCount>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedWord);

            if (matcher.find()) {
                if (matcher.group("attackType").equals("A")) {
                    attackedPlanets.add(matcher.group("planetName"));
                } else if (matcher.group("attackType").equals("D")) {
                    destroyedPlanets.add(matcher.group("planetName"));
                }
            }

            decryptedWord.setLength(0);

        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        if (attackedPlanets.size() > 0) {
            for (int i = 0; i < attackedPlanets.size(); i++) {
                System.out.printf("-> %s%n", attackedPlanets.get(i));
            }
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        if (destroyedPlanets.size() > 0) {
            for (int i = 0; i < destroyedPlanets.size(); i++) {
                System.out.printf("-> %s%n", destroyedPlanets.get(i));
            }
        }


    }
}
