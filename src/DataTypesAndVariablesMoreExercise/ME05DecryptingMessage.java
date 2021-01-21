package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class ME05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt (scanner.nextLine());
        int n = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String currentLetterEncrypted = scanner.nextLine();
            char currentLetterDecrypted = (char) (currentLetterEncrypted.charAt(0) + key);
            System.out.print(currentLetterDecrypted);
        }
    }
}
