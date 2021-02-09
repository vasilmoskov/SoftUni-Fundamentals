package MethodsExercise;

import java.util.Scanner;

public class E07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt (scanner.nextLine());

        printNxNMatrix(input);

    }

    static void printNxNMatrix (int input) {
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                System.out.print(input + " ");
            }
            System.out.println();
        }
    }
}
