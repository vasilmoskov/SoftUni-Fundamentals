package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09PokemonDontGo {

    /*
        private static void addOrSubtractValue(List<Integer> numbers, int valueToBeAddedOrSubtraced) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > valueToBeAddedOrSubtraced) {
                int newValue = numbers.get(i) - valueToBeAddedOrSubtraced;
                numbers.set(i, newValue);
            } else {
                int newValue = numbers.get(i) + valueToBeAddedOrSubtraced;
                numbers.set(i, newValue);
            }
        }
    }
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbersAsString = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsString.size(); i++) {
            numbers.add(Integer.parseInt(numbersAsString.get(i)));
        }

        String strCurrentIndex = scanner.nextLine();
        if (strCurrentIndex.equalsIgnoreCase("")) {
            System.out.println(0);
            return;
        }

        int currentIndex = Integer.parseInt(strCurrentIndex);

        int sum = 0;

        while (true) {

            if (currentIndex < 0) {

                int valueToBeAddedOrSubtraced = numbers.get(0);
                sum += valueToBeAddedOrSubtraced;

                int valueOfTheLastElement = numbers.get(numbers.size() - 1);

                numbers.remove(0);
                numbers.add(0, valueOfTheLastElement);

                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > valueToBeAddedOrSubtraced) {
                        int newValue = numbers.get(i) - valueToBeAddedOrSubtraced;
                        numbers.set(i, newValue);
                    } else {
                        int newValue = numbers.get(i) + valueToBeAddedOrSubtraced;
                        numbers.set(i, newValue);
                    }
                }

            } else if (currentIndex >= numbers.size()) {
                int lastElement = numbers.size() - 1;
                int valueOfTheFirstElement = numbers.get(0);

                int valueToBeAddedOrSubtraced = numbers.get(lastElement);
                sum += valueToBeAddedOrSubtraced;

                numbers.remove(lastElement);
                numbers.add(lastElement, valueOfTheFirstElement);


                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > valueToBeAddedOrSubtraced) {
                        int newValue = numbers.get(i) - valueToBeAddedOrSubtraced;
                        numbers.set(i, newValue);
                    } else {
                        int newValue = numbers.get(i) + valueToBeAddedOrSubtraced;
                        numbers.set(i, newValue);
                    }
                }

            } else {

                int valueToBeAddedOrSubtraced = numbers.get(currentIndex);
                sum += valueToBeAddedOrSubtraced;
                numbers.remove(currentIndex);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > valueToBeAddedOrSubtraced) {
                        int newValue = numbers.get(i) - valueToBeAddedOrSubtraced;
                        numbers.set(i, newValue);
                    } else {
                        int newValue = numbers.get(i) + valueToBeAddedOrSubtraced;
                        numbers.set(i, newValue);
                    }
                }

            }
            strCurrentIndex = scanner.nextLine();
            if (strCurrentIndex.equalsIgnoreCase("")) {
                break;
            }
            currentIndex = Integer.parseInt(strCurrentIndex);

        }

        System.out.println(sum);
    }

}

