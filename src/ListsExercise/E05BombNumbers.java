package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05BombNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbersAsString = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsString.size(); i++) {
            numbers.add(Integer.parseInt(numbersAsString.get(i)));
        }

        int bombNumber = scanner.nextInt();
        int power = scanner.nextInt();


        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (i<numbers.size()) {
                if (numbers.get(i) == bombNumber) {
                    for (int j = i + power; j > i; j--) {
                        if (j < numbers.size()) {
                            numbers.remove(j);
                        }
                    }
                    for (int j = i; j >= i - power; j--) {
                        if (j >= 0) {
                            numbers.remove(j);
                        }
                    }
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        System.out.println(sum);
    }
}
