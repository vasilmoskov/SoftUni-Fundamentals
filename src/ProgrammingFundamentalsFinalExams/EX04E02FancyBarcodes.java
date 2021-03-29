package ProgrammingFundamentalsFinalExams;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX04E02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            String barcode = "";

            while (matcher.find()) {
                barcode = matcher.group();
            }

            StringBuilder productGroup = new StringBuilder();

            if (barcode.equals("")) {
                System.out.println("Invalid barcode");
            } else {
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))) {
                        productGroup.append(barcode.charAt(j));
                    }
                }

                if (productGroup.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }

                productGroup.setLength(0);
            }

        }

    }
}
