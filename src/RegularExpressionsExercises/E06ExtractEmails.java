package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(?<user>[A-Za-z0-9]+[.\\-_]?[A-Za-z0-9]+)@(?<host>[a-z]+\\-?[a-z]+(\\.?[a-z]+\\-?[a-z]+)+)";
        //String regex = "^(?<user>[A-Za-z0-9]+[.\\-_]?[A-Za-z0-9]+)@(?<host>[a-z]+\\-?[a-z]+(\\.?[a-z]+\\-?[a-z]+)+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
