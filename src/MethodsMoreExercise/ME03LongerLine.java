package MethodsMoreExercise;

import java.util.Scanner;

public class ME03LongerLine {
    public static void main(String[] args) {

        // 60 / 100

        Scanner scanner = new Scanner(System.in);

        int x1p1 = Integer.parseInt(scanner.nextLine());
        int y1p1 = Integer.parseInt(scanner.nextLine());
        int x2p1 = Integer.parseInt(scanner.nextLine());
        int y2p1 = Integer.parseInt(scanner.nextLine());
        int x1p2 = Integer.parseInt(scanner.nextLine());
        int y1p2 = Integer.parseInt(scanner.nextLine());
        int x2p2 = Integer.parseInt(scanner.nextLine());
        int y2p2 = Integer.parseInt(scanner.nextLine());

        printClosestPoint(x1p1, y1p1, x2p1, y2p1, x1p2, y1p2, x2p2, y2p2);
    }

    public static void printClosestPoint(int x1p1, int y1p1, int x2p1, int y2p1, int x1p2, int y1p2, int x2p2, int y2p2) {
        int lineFirstPair = Math.abs(x1p1 + y1p1 + x2p1 + y2p1);
        int lineSecondPair = Math.abs(x1p2 + y1p2 + x2p2 + y2p2);

        if (lineFirstPair >= lineSecondPair) {
            int coordinatesFirstPair = Math.abs(x1p1 + y1p1);
            int coordinatesSecondPair = Math.abs(x2p1 + y2p1);
            if (coordinatesFirstPair <= coordinatesSecondPair) {
                System.out.printf("(%d, %d)(%d, %d)", x1p1, y1p1, x2p1, y2p1);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x2p1, y2p1, x1p1, y1p1);
            }
        } else {
            int coordinatesThirdPair = Math.abs(x1p2 + y1p2);
            int coordinatesForthPair = Math.abs(x2p2 + y2p2);
            if (coordinatesThirdPair <= coordinatesForthPair) {
                System.out.printf("(%d, %d)(%d, %d)", x1p2, y1p2, x2p2, y2p2);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x2p2, y2p2, x1p2, y1p2);
            }
        }
    }
}
