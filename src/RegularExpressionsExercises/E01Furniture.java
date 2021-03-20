package RegularExpressionsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);

        double totalMoneySpend = 0;
        List<String> furniture = new ArrayList<>();

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                furniture.add(matcher.group("furniture"));

                double priceCurrentFurniture = Double.parseDouble (matcher.group("price"));
                int quantityCurrentFurniture = Integer.parseInt (matcher.group("quantity"));
                double totalMoneyForCurrentFurniture = priceCurrentFurniture * quantityCurrentFurniture;

                totalMoneySpend += totalMoneyForCurrentFurniture;
            }

            input = scanner.nextLine();
        }

            System.out.println("Bought furniture:");
            furniture.forEach(System.out::println);
            System.out.printf("Total money spend: %.2f", totalMoneySpend);
    }
}
