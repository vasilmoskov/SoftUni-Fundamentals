package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%([^\\|\\$\\%\\.]*)<(?<product>[\\w]+)>([^\\|\\$\\%\\.]*)\\|(?<quantity>\\d+)\\|([^\\|\\$\\%\\.\\d]*)(?<price>\\d+\\.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double total = 0;

        String input = scanner.nextLine();

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int quantity = Integer.parseInt (matcher.group("quantity"));
                double price = Double.parseDouble (matcher.group("price"));
                double totalPriceCurrentProduct = quantity * price;
                total += totalPriceCurrentProduct;
                String priceFormatted = String.format("%.2f", totalPriceCurrentProduct);
                System.out.print(matcher.group("name") + ": " + matcher.group("product") + " - " + priceFormatted);
                System.out.println();
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",total);
    }
}
