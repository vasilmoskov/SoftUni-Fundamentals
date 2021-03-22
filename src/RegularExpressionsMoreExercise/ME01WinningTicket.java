package RegularExpressionsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME01WinningTicket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "(\\${5,10})?(\\@{5,10})?(\\#{5,10})?(\\^{5,10})?";

        String[] input = scanner.nextLine().split("[\\s\\,]+");

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < input.length; i++) {
            String currentTicket = input[i];

            if (currentTicket.length() == 20) {
                String firstHalfOfTheWord = currentTicket.substring(0, 10);
                String secondHalfOfTheWord = currentTicket.substring(10);

                Matcher matcherFirstHalf = pattern.matcher(firstHalfOfTheWord);
                Matcher matcherSecondHalf = pattern.matcher(secondHalfOfTheWord);

                StringBuilder firstHalf = new StringBuilder();

                while (matcherFirstHalf.find()) {
                    firstHalf.append(matcherFirstHalf.group());
                }

                StringBuilder secondHalf = new StringBuilder();

                while (matcherSecondHalf.find()) {
                    secondHalf.append(matcherSecondHalf.group());
                }

                if (!secondHalf.toString().equals("") && !firstHalf.toString().equals("")) {

                    char winningSymbolFirstHalf = firstHalf.charAt(0);
                    char winningSymbolSecondHalf = secondHalf.charAt(0);

                    if (winningSymbolFirstHalf != winningSymbolSecondHalf) {
                        break;
                    }

                    String shorterHalf = "";

                    if (firstHalf.length()<secondHalf.length()) {
                        shorterHalf = firstHalf.toString();
                    } else {
                        shorterHalf = secondHalf.toString();
                    }

                    int countWinningSymbol = 0;

                    for (int j = 0; j < shorterHalf.length(); j++) {
                        if (shorterHalf.charAt(j) == winningSymbolFirstHalf) {
                            countWinningSymbol++;
                        }
                    }

                    if (shorterHalf.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", currentTicket, countWinningSymbol, winningSymbolFirstHalf);
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", currentTicket, countWinningSymbol, winningSymbolFirstHalf);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", currentTicket);
                }

                firstHalf.setLength(0);
                secondHalf.setLength(0);

            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
