package ListsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class ME04MixedUpLists {
    public static void main(String[] args) {

        //•	Start from the beginning of the first list and from the ending of the second
        //•	Add element from the first and element from the second
        //•	At the end there will always be a list in which there are 2 elements remaining
        //•	These elements will be the range of the elements you need to print
        //•	Loop through the result list and take only the elements that fulfill the condition
        //•	Print the elements ordered in ascending order and separated by a space

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int smallerList = Math.min(firstList.size(), secondList.size());

        List<Integer> combinedList = new ArrayList<>();

        for (int i = 0; i < smallerList; i++) {
            combinedList.add(firstList.get(i));
            combinedList.add(secondList.get(secondList.size() - 1 - i));
        }

        int rangeNumber1 = 0;
        int rangeNumber2 = 0;

        if (firstList.size() > secondList.size()) {
            rangeNumber1 = firstList.get(firstList.size() - 1);
            rangeNumber2 = firstList.get(firstList.size() - 2);
        } else {
            rangeNumber1 = secondList.get(0);
            rangeNumber2 = secondList.get(1);
        }

        int upperLimit = 0;
        int lowerLimit = 0;

        if (rangeNumber1 > rangeNumber2) {
            upperLimit = rangeNumber1;
            lowerLimit = rangeNumber2;
        } else {
            upperLimit = rangeNumber2;
            lowerLimit = rangeNumber1;
        }

        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < combinedList.size(); i++) {
            if (combinedList.get(i) > lowerLimit && combinedList.get(i) < upperLimit) {
                finalList.add(combinedList.get(i));
            }
        }

        Collections.sort(finalList);

        for (Integer integer : finalList) {
            System.out.print(integer + " ");
        }
    }
}
