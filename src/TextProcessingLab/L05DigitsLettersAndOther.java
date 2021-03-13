package TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Character> firstLine = new ArrayList<>();
        List<Character> secondLine = new ArrayList<>();
        List<Character> thirdLine = new ArrayList<>();

        /*
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <=57){
                firstLine.add(input.charAt(i));
            } else if (input.charAt(i) >= 65 && input.charAt(i) <=90 || input.charAt(i) >= 97 && input.charAt(i) <=122){
                secondLine.add(input.charAt(i));
            } else {
                thirdLine.add(input.charAt(i));
            }
        }

         */

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                firstLine.add(input.charAt(i));
            } else if (Character.isAlphabetic(input.charAt(i))) {
                secondLine.add(input.charAt(i));
            } else {
                thirdLine.add(input.charAt(i));
            }
        }
        System.out.println(firstLine.toString().replaceAll("[\\[\\], ]", ""));
        System.out.println(secondLine.toString().replaceAll("[\\[\\], ]", ""));
        System.out.println(thirdLine.toString().replaceAll("[\\[\\], ]", ""));


    }
}
