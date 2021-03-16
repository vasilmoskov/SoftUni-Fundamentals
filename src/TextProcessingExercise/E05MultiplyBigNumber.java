package TextProcessingExercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class E05MultiplyBigNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigDecimal n1 = new BigDecimal(scanner.nextLine());
        int n2 = Integer.parseInt (scanner.nextLine());

        BigDecimal sum = n1.multiply(BigDecimal.valueOf(n2));

        System.out.println(sum);
    }
}
