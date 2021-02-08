package MethodsExercise;

import java.util.Scanner;

public class E05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt (scanner.nextLine());
        int n2 = Integer.parseInt (scanner.nextLine());
        int n3 = Integer.parseInt (scanner.nextLine());

        System.out.println(subtractThirdNumberFromSum(n3, n1, n2));

    }

    static int sumFirstAndSecondNumber (int n1, int n2) {
        return n1+n2;
    }

    static int subtractThirdNumberFromSum (int n3, int n1, int n2) {
        return sumFirstAndSecondNumber(n1, n2) - n3;
    }
}
