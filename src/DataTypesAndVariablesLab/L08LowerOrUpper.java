package DataTypesAndVariablesLab;

import java.util.Scanner;

public class L08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);

        if (symbol >= 65 && symbol <= 90) {
            System.out.println("upper-case");
        } else if (symbol >= 97 && symbol <=122) {
            System.out.println("lower-case");
        }
    }
}
