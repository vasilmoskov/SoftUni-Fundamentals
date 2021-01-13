package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class L11MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt (scanner.nextLine());
        int multiplier = Integer.parseInt (scanner.nextLine());

        for (int i = multiplier; i <= 10; i++) {
            int sum = number * i;
            System.out.printf("%d X %d = %d%n", number, i, sum);

        }

        if (multiplier> 10) {
            int otherSum = multiplier * number;
            System.out.printf("%d X %d = %d%n", number, multiplier, otherSum);

        }
    }
}
