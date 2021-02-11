package MethodsMoreExercise;

import java.util.Scanner;

public class ME05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n1 = scanner.nextLine();
        String n2 = scanner.nextLine();
        String n3 = scanner.nextLine();

        printSign(n1,n2,n3);
    }

    public static void printSign (String n1, String n2, String n3){
        int countMinus = 0;
        boolean thereIsZero = false;
        if (n1.charAt(0) == '-'){
            countMinus++;
        }
        if (n2.charAt(0) == '-') {
            countMinus++;
        }
        if (n3.charAt(0) == '-') {
            countMinus++;
        }

        if (n1.equals("0")){
            thereIsZero = true;
        }
        if (n2.equals("0")){
            thereIsZero = true;
        }
        if (n3.equals("0")){
            thereIsZero = true;
        }

        if (thereIsZero) {
            System.out.println("zero");
        } else if (countMinus%2==1) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }


}
