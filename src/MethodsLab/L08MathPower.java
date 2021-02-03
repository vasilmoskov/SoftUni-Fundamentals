package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class L08MathPower {

    static double numberRaised (double number, int givenPower) {
        double numberRaised = Math.pow(number, givenPower);

        return numberRaised;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble (scanner.nextLine());
        int givenPower = Integer.parseInt (scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(numberRaised(number,givenPower)));
    }

}
