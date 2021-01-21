package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class ME04RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int dividor = 2; dividor < i; dividor++) {
                if (i % dividor == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }

    }
}
