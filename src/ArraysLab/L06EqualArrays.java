package ArraysLab;

import java.util.Scanner;

public class L06EqualArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        String [] firstArrayNumbersAsStrings = input1.split(" ");
        String [] secondArrayNumbersAsStrings = input2.split(" ");

        int sum = 0;
        int differenceAt=-1;

        int [] firstArray = new int [firstArrayNumbersAsStrings.length];
        for (int i = 0; i < firstArrayNumbersAsStrings.length; i++) {
            firstArray[i] = Integer.parseInt(firstArrayNumbersAsStrings[i]);
            sum += firstArray[i];
        }
        int [] secondArray = new int [secondArrayNumbersAsStrings.length];
        for (int i = 0; i < secondArrayNumbersAsStrings.length; i++) {
            secondArray[i] = Integer.parseInt(secondArrayNumbersAsStrings[i]);
        }

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]){
                differenceAt=i;
                break;
            }
        }

        if (input1.equals(input2)) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", differenceAt);
        }

    }
}
