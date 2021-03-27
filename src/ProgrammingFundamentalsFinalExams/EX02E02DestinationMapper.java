package ProgrammingFundamentalsFinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02E02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> destinations = new ArrayList<>();

        String regex = "([=\\/])(?<location>[A-Z][A-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            destinations.add(matcher.group("location"));
        }

        System.out.println("Destinations: " + String.join(", ", destinations));
        
        int travelPoints = 0;

        for (int i = 0; i < destinations.size(); i++) {
            travelPoints += destinations.get(i).length();
        }

        System.out.println("Travel Points: " + travelPoints);

    }
}
