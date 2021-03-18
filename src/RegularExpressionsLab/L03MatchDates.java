package RegularExpressionsLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L03MatchDates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "\\b(?<day>\\d{2})(\\.|\\/|\\-)(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";

        // End. Matches the end of the string, or the end of a line if the multiline flag is enabled.

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print("Day: " + matcher.group("day") + ", Month: " + matcher.group("month") + ", Year: " + matcher.group("year") );
            System.out.println();
        }
    }
}
