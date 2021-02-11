package MethodsMoreExercise;

import java.util.Scanner;

public class ME02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        printClosestPoint(x1, y1, x2, y2);
    }

    public static void printClosestPoint(int x1, int y1, int x2, int y2) {
        int firstCoordinates = Math.abs(x1 + y1);
        int secondCoordinates = Math.abs(x2 + y2);
        if (firstCoordinates <= secondCoordinates) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }
}
