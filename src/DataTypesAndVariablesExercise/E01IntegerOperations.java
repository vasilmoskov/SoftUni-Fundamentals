package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt (scanner.nextLine());
        int second = Integer.parseInt (scanner.nextLine());
        int third = Integer.parseInt (scanner.nextLine());
        int forth = Integer.parseInt (scanner.nextLine());

        int firstOperation = first+second;
        int secondOperation = firstOperation/third;
        int thirdOperation = secondOperation * forth;

        System.out.println(thirdOperation);
    }
}
