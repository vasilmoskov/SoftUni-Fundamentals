package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX02E03Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());


        int sumOfAllNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sumOfAllNumbers += numbers.get(i);
        }

        double average = (double) sumOfAllNumbers / numbers.size();

        Collections.sort(numbers);
        Collections.reverse(numbers);

        int countNumbers = 0;
        boolean noSuchNumbers = true;

        for (int i = 0; i < numbers.size(); i++) {
            if (countNumbers < 5 && numbers.get(i) > average) {
                noSuchNumbers = false;
                System.out.print(numbers.get(i) + " ");
                countNumbers++;
            }
        }

        if (noSuchNumbers) {
            System.out.println("No");
        }

    }
}
