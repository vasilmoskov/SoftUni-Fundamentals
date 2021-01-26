package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class E03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        int [] firstArray = new int[n];
        int [] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                firstArray[i] = scanner.nextInt();
                secondArray[i] = scanner.nextInt();
            } else {
                secondArray[i] = scanner.nextInt();
                firstArray[i] = scanner.nextInt();
            }
        }

        System.out.println(Arrays.toString(firstArray).replace("[", "")
                .replace("]", "")
                .replace(",", ""));
        System.out.println(Arrays.toString(secondArray).replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
