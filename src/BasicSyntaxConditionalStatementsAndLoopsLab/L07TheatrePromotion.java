package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class L07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfTheDay = scanner.nextLine();
        int age = Integer.parseInt (scanner.nextLine());

        int price = 0;

        boolean error = false;

        switch (typeOfTheDay) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    price = 12;
                } else if (age >18 && age <= 64) {
                    price = 18;
                } else if (age > 64 && age <= 122) {
                    price = 12;
                } else {
                    error = true;
                    System.out.println("Error!");
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    price = 15;
                } else if (age >18 && age <= 64) {
                    price = 20;
                } else if (age > 64 && age <= 122) {
                    price = 15;
                } else {
                    error = true;
                    System.out.println("Error!");
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age >18 && age <= 64) {
                    price = 12;
                } else if (age > 64 && age <= 122) {
                    price = 10;
                } else {
                    error = true;
                    System.out.println("Error!");
                }
                break;
        }

        if (!error) {
            System.out.printf("%d$", price);
        }
    }
}
