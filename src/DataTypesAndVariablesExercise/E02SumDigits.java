package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int total = 0;
        for (int i = 0; i < number.length(); i++) {
            String digitStr = String.valueOf(number.charAt(i));
            int digit = Integer.parseInt(digitStr);
            total += digit;
        }
        System.out.println(total);
    }
}