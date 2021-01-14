package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;


        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                if (people >= 30) {
                    price *= 0.85;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.0;
                        break;
                }
                if (people >= 100) {
                    people -= 10;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15.00;
                        break;
                    case "Saturday":
                        price = 20.00;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                if (people >= 10 && people <=20) {
                    price *= 0.95;
                }
                break;
        }

        double total = price * people;

        System.out.printf("Total price: %.2f", total);
    }
}
