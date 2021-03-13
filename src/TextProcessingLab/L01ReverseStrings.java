package TextProcessingLab;

import java.util.Scanner;

public class L01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            System.out.print(input + " = ");
            for (int i = input.length()-1; i >=0 ; i--) {
                System.out.print(input.charAt(i));
            }
            System.out.println();
            input= scanner.nextLine();
        }
    }
}
