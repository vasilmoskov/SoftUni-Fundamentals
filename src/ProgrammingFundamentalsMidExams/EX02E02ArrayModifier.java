package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Scanner;

public class EX02E02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String [] inputAsArr = input.split(" ");
            String command = inputAsArr[0];

            if (command.equals("swap")){
                int index1 = Integer.parseInt(inputAsArr[1]);
                int index2 = Integer.parseInt(inputAsArr[2]);

                int temp = numbers [index1];
                numbers [index1] = numbers [index2];
                numbers [index2] = temp;

            } else if (command.equals("multiply")){
                int index1 = Integer.parseInt(inputAsArr[1]);
                int index2 = Integer.parseInt(inputAsArr[2]);

                numbers[index1] = numbers [index1] * numbers [index2];

            } else if (command.equals("decrease")) {

                for (int i = 0; i < numbers.length; i++) {
                    numbers [i] -= 1;
                }

            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length-1) {
                System.out.print(", ");
            }
        }
    }
}
