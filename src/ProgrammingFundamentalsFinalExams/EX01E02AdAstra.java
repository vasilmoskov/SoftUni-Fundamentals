package ProgrammingFundamentalsFinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX01E02AdAstra {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "([#\\|])(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,4})\\1";

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;
        List<Product> food = new ArrayList<>();

        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt (matcher.group("calories"));

            totalCalories += calories;
            Product product = new Product(itemName, expirationDate, calories);
            food.add(product);
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        food.forEach(e -> System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",
                e.getItemName(), e.getExpirationDate(), e.getCalories()));
    }

    public static class Product {
        String itemName;
        String expirationDate;
        int calories;

        public Product(String itemName, String expirationDate, int calories) {
            this.itemName = itemName;
            this.expirationDate = expirationDate;
            this.calories = calories;
        }

        public String getItemName() {
            return itemName;
        }

        public String getExpirationDate () {
            return expirationDate;
        }

        public int getCalories() {
            return calories;
        }

    }
}
