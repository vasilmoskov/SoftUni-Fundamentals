package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class E06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        while (firstHand.size() > 0 && secondHand.size() > 0) {

            int firstCardFirstHand = firstHand.get(0);
            int firstCardSecondHand = secondHand.get(0);

            if (firstCardFirstHand == firstCardSecondHand) {
                firstHand.remove(0);
                secondHand.remove(0);
            } else if (firstCardFirstHand > firstCardSecondHand) {
                firstHand.add(firstCardFirstHand);
                firstHand.add(firstCardSecondHand);
                firstHand.remove(0);
                secondHand.remove(0);
            } else if (firstCardSecondHand > firstCardFirstHand) {
                secondHand.add(firstCardSecondHand);
                secondHand.add(firstCardFirstHand);
                secondHand.remove(0);
                firstHand.remove(0);
            }
        }

        if (firstHand.size()>0) {
            int sum = 0;
            for (int i = 0; i < firstHand.size(); i++) {
                sum += firstHand.get(i);
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }

        if (secondHand.size()>0) {
            int sum = 0;
            for (int i = 0; i < secondHand.size(); i++) {
                sum += secondHand.get(i);
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }
}

