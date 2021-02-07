package MethodsExercise;

import java.util.Scanner;

public class E02VowelsCount {
    public static void main(String[] args) {

        printNumberVowels();

    }

    static void printNumberVowels () {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        int countVowels = 0;
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'o'|| word.charAt(i) == 'e'|| word.charAt(i) == 'u'|| word.charAt(i) == 'i') {
                countVowels++;
            }
        }

        System.out.println(countVowels);
    }


}
