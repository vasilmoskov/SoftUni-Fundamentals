package MethodsMoreExercise;

import java.util.Scanner;

public class ME01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();
        String input = scanner.nextLine();

        printProcessedInput(dataType, input);
    }


    public static void printProcessedInput(String dataType, String input) {
        switch (dataType) {
            case "int":
                int number = Integer.parseInt(input);
                System.out.println(2 * number);
                break;
            case "real":
                double doubleNumber = Double.parseDouble(input);
                System.out.printf("%.2f", doubleNumber * 1.5);
                break;
            case "string":
                System.out.println("$" + input + "$");
                break;
        }

    }

}
