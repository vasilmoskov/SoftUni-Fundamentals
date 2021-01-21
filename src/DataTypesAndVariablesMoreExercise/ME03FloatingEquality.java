package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class ME03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = Double.parseDouble (scanner.nextLine());
        double secondNum = Double.parseDouble (scanner.nextLine());

        double difference = Math.abs(firstNum-secondNum);

        if (difference>0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
