package ArraysLab;

import java.util.Scanner;

public class L04ReverseArrayOfStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String values = scanner.nextLine();

        String [] valuesAsString = values.split(" ");


        for (int i = valuesAsString.length-1; i >=0; i--) {
            System.out.printf("%s ", valuesAsString[i]);
        }
    }
}
