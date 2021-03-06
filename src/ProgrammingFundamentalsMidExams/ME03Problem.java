package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String instruction = input.split(" ")[0];

            switch (instruction) {
                case "Change":
                    int paintingNumber = Integer.parseInt(input.split(" ")[1]);
                    int changeNumber = Integer.parseInt(input.split(" ")[2]);

                    if (numbers.contains(paintingNumber)) {
                        numbers.set(numbers.indexOf(paintingNumber), changeNumber);
                    }

                    break;

                case "Hide":
                    paintingNumber = Integer.parseInt(input.split(" ")[1]);
                    numbers.remove((Object) paintingNumber);
                    break;

                case "Switch":
                    paintingNumber = Integer.parseInt(input.split(" ")[1]);
                    int paintingNumber2 = Integer.parseInt(input.split(" ")[2]);

                    if (numbers.contains(paintingNumber) && numbers.contains(paintingNumber2)) {

                        int indexOfFirstNumber = numbers.indexOf(paintingNumber);
                        int indexOfSecondNumber = numbers.indexOf(paintingNumber2);

                        numbers.set(indexOfFirstNumber, paintingNumber2);
                        numbers.set(indexOfSecondNumber, paintingNumber);

                    }
                    break;

                case "Insert":
                    int place = Integer.parseInt(input.split(" ")[1]);
                    paintingNumber = Integer.parseInt(input.split(" ")[2]);

                    int indexToAddPaintingNumberOn = place + 1;
                    if (indexToAddPaintingNumberOn>=0 && indexToAddPaintingNumberOn <=numbers.size()){
                        numbers.add(indexToAddPaintingNumberOn, paintingNumber);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(numbers);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
