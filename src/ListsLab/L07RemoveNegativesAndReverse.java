package ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class L07RemoveNegativesAndReverse {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> numbersAsString = Arrays.stream(input.split(" ")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersAsString.size(); i++) {
            numbers.add(Integer.parseInt(numbersAsString.get(i)));
        }

        int i =0;
        while (i<numbers.size()) {
            if (numbers.get(i) < 0 ) {
                numbers.remove(numbers.get(i));
            } else {
                i++;
            }
        }

        Collections.reverse(numbers);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

        }





    }
}
