package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L03MergingLists {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        List<String> firstListAsString = Arrays.stream(input1.split(" ")).collect(Collectors.toList());

        List<Integer> firstList = new ArrayList<>();
        for (int i = 0; i < firstListAsString.size(); i++) {
            firstList.add(Integer.parseInt(firstListAsString.get(i)));
        }

        List<String> secondListAsString = Arrays.stream(input2.split(" ")).collect(Collectors.toList());

        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < secondListAsString.size(); i++) {
            secondList.add(Integer.parseInt(secondListAsString.get(i)));
        }

        int i = 0;

        while (i < firstList.size() || i < secondList.size()) {
            if (firstList.size() >= 1) {
                System.out.print(firstList.get(i)+" ");
                firstList.remove(i);
            }
            if (secondList.size() >= 1) {
                System.out.print(secondList.get(i)+" ");
                secondList.remove(i);
            }

        }
    }
}
