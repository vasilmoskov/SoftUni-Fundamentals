package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class L09SumOfOddNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        int oddSum=0;
        int oddNumber = 1;


        for (int i = 1; i <= n; i++) {
            if (oddNumber%2!=0) {
                System.out.println(oddNumber);
                oddSum += oddNumber;
            }
            oddNumber+=2;

        }
        System.out.printf("Sum: %d", oddSum);
    }
}
