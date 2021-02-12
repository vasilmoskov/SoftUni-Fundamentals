package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean onlyOneNumber= true;

        List<String> numbersAsString = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsString.size(); i++) {
            numbers.add(Integer.parseInt(numbersAsString.get(i)));
        }

        int i = 0;


        while (numbers.size()>1) {
            onlyOneNumber=false;
            System.out.print(numbers.get(i) + numbers.get(numbers.size() - 1) + " ");
            numbers.remove(numbers.size() - 1);
            numbers.remove(i);

            if (numbers.size()==1){
                onlyOneNumber=true;
            }
        }



        if (onlyOneNumber){
            System.out.print(numbers.get(0));
        }

    }
}
