package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ME01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1 = Double.parseDouble (scanner.nextLine());
        double number2 = Double.parseDouble (scanner.nextLine());
        double number3 = Double.parseDouble (scanner.nextLine());

        List<Double> numbers = new ArrayList<>();
        numbers.add(number1);
        numbers.add(number2);
        numbers.add(number3);

        Collections.sort(numbers);
        Collections.reverse(numbers);


        for (double number:numbers) {
            System.out.printf("%.0f%n", number);
        }
    }
}
