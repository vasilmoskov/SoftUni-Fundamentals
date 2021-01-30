package ArraysMoreExercise;

import java.util.Scanner;

public class ME02PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int [] currentRow = new int[rows];

        for (int i = 0; i < rows; i++) {
            int[] upperRow = new int[i + 1];
            upperRow[0] = 1;
            currentRow[0] = 1;

            if (upperRow.length > 1) {
                upperRow[upperRow.length - 1] = 1;
                currentRow [upperRow.length - 1] = 1;
            }

            int[] downRow = new int[i];

            for (int k = 0; k < i; k++) {
                upperRow[k] = currentRow[k];
            }

            System.out.print(upperRow[0] + " ");

            if (i>1) {

                for (int j = 1; j < upperRow.length - 1; j++) {
                    downRow[j] = upperRow[j - 1] + upperRow[j];
                    currentRow[j] = downRow [j];

                    System.out.print(downRow[j] + " ");

                }
            }

            if (i>0) {
                System.out.print(upperRow[upperRow.length - 1]);
            }
            System.out.println();
        }
    }
}