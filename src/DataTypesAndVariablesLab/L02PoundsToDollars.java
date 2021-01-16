package DataTypesAndVariablesLab;

import java.util.Scanner;

public class L02PoundsToDollars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pounds = Integer.parseInt(scanner.nextLine());
        int dollarsInCents = pounds * 1310;
        int cents = dollarsInCents % 1000;
        int wholeDollars = dollarsInCents / 1000;



        System.out.printf("%d.%03d", wholeDollars, cents);
    }
}
