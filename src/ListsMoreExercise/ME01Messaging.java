package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        List<String> textAsList = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            int sum = 0;

            while (currentNumber > 0) {
                int digit = currentNumber % 10;
                sum += digit;
                currentNumber /= 10;
            }

            printAndRemoveCharacter(textAsList, sum);

        }
    }

    public static void printAndRemoveCharacter(List<String> textAsList, int index) {

        while (index > textAsList.size()) {
            index -= textAsList.size();
        }

        for (int i = 0; i < textAsList.size(); i++) {
            if (i == index) {
                System.out.print(textAsList.get(i));
                textAsList.remove(i);
                break;
            }
        }
    }
}
