package TextProcessingMoreExercise;

import java.util.Scanner;

public class ME02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);

        char lowerBound;
        char upperBound;

        if (char1 < char2) {
            lowerBound = char1;
            upperBound = char2;
        } else {
            lowerBound = char2;
            upperBound = char1;
        }

        String string = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > lowerBound && string.charAt(i) < upperBound) {
                sum += string.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
