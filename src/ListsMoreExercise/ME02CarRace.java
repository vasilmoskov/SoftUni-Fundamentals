package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double timeLeftSide = timeLeftSide(numbers);
        double timeRightSide = timeRightSide(numbers);

        if (timeLeftSide < timeRightSide) {
            System.out.printf("The winner is left with total time: %.1f", timeLeftSide);
        } else if (timeRightSide < timeLeftSide) {
            System.out.printf("The winner is right with total time: %.1f", timeRightSide);
        }
    }

    static double timeLeftSide(List<Integer> numbers) {
        double timeLeftSide = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {
            timeLeftSide += numbers.get(i);
            if (numbers.get(i) == 0) {
                timeLeftSide *= 0.8;
            }
        }

        return timeLeftSide;
    }

    static double timeRightSide(List<Integer> numbers) {
        double timeRightSide = 0;

        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            timeRightSide += numbers.get(i);
            if (numbers.get(i) == 0) {
                timeRightSide *= 0.8;
            }
        }

        return timeRightSide;
    }
}
