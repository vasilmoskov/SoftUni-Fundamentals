package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E08TriangleOfNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j <= i) {
                System.out.printf("%d ", i);
                j++;
            }
            System.out.println();
        }
    }
}
