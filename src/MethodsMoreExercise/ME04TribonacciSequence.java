package MethodsMoreExercise;

import java.util.Scanner;

public class ME04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int [] tribonacci = new int[num];

        printTribonacci(tribonacci,num);

    }

    public static void printTribonacci(int[] tribonacci, int num) {
        if (num==1) {
            System.out.println(1);
        } else if (num == 2) {
            System.out.print("1 1");
        } else {
            tribonacci = new int[num];

            tribonacci[0] = 1;
            tribonacci[1] = 1;
            tribonacci[2] = 2;

            for (int i = 3; i < tribonacci.length; i++) {
                tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
            }


            for (int i = 0; i < tribonacci.length; i++) {
                System.out.print(tribonacci[i] + " ");

            }
        }
    }
}
