package ProgrammingFundamentalsFinalExams;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX05E02EmojiDetector {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "([:\\*])\\1[A-Z][a-z]{2,}\\1\\1";

        BigDecimal threshold = new BigDecimal(1);

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                int number = Integer.parseInt(String.valueOf(currentChar));
                threshold = threshold.multiply(BigDecimal.valueOf(number));
            }
        }

        System.out.println("Cool threshold: " + threshold);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> emojis = new ArrayList<>();

        while (matcher.find()) {
            emojis.add(matcher.group());
        }

        System.out.println(emojis.size() + " emojis found in the text. The cool ones are:");

        for (int i = 0; i < emojis.size(); i++) {
            String currentEmoji = emojis.get(i).substring(2, emojis.get(i).length()-2);

            BigDecimal sumOfCurrEmoji = new BigDecimal(0);

            for (int j = 0; j < currentEmoji.length(); j++) {
                sumOfCurrEmoji = sumOfCurrEmoji.add(BigDecimal.valueOf(currentEmoji.charAt(j)));

                if (sumOfCurrEmoji.compareTo(threshold) > 0) {
                    System.out.println(emojis.get(i));
                    break;
                }
            }
        }

    }
}