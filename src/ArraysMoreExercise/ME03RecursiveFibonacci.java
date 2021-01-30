package ArraysMoreExercise;

import java.util.Scanner;

public class ME03RecursiveFibonacci {
    public static void main(String[] args) {

        // 85 /100 - Test #6 (Runtime error)

        long [] numbers = new long[50];

        numbers [0] = 1;
        numbers [1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers [i] = numbers [i-1] + numbers [i-2];
        }

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt (scanner.nextLine());

        if (n==0) {
            System.out.println(1);
        } else {
            System.out.println(numbers[n - 1]);
        }
    }
}
