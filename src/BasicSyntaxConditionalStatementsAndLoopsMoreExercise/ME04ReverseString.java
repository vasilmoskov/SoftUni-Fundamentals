package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class ME04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        for (int i = word.length()-1; i >=0 ; i--) {
            System.out.print(word.charAt(i));
        }
    }
}
