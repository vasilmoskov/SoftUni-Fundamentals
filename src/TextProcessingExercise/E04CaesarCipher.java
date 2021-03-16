package TextProcessingExercise;

import java.util.Scanner;

public class E04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {

            System.out.print((char)(input.charAt(i)+3));
        }
    }
}
