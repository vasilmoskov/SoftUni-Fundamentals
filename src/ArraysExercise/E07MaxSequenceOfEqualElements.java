package ArraysExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E07MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] numbersAsString = scanner.nextLine().split(" ");

        List<Integer> longestList = new ArrayList<>();

        List<Integer> numbers = new ArrayList<>();

        int count = 0;

        for (int i = 1; i < numbersAsString.length; i++) {
            count++;
            if (numbersAsString [i].equals(numbersAsString[i-1])) {

                if (count == 1) {
                    numbers.add(Integer.parseInt(numbersAsString[i-1]));
                }

                numbers.add(Integer.parseInt(numbersAsString[i]));

                if (numbers.size() > longestList.size()) {
                    longestList.removeAll(longestList);
                    longestList.addAll(numbers);
                }

            } else {
                count = 0;
                numbers.removeAll(numbers);
            }
        }
        System.out.println(longestList.toString().replaceAll("[\\[\\],]", ""));

    }
}
