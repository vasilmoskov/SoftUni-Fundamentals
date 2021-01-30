package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ME01EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt (scanner.nextLine());

        int [] numbers = new int[n];

        String [] names = new String[n];

        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();
            Character[] letters = new Character[names[i].length()];
            for (int j = 0; j < letters.length; j++) {
                letters[j] = names[i].charAt(j);
                if (letters[j] == 'a' || letters[j] == 'e'|| letters[j]=='i'|| letters[j]=='o'|| letters[j]=='u' ||
                        letters[j] == 'A' || letters[j] == 'E'|| letters[j]=='I'|| letters[j]=='O'|| letters[j]=='U'){
                    numbers [i] += (letters[j] * names[i].length());
                } else {
                    numbers [i] += (letters[j] / names[i].length());
                }
            }
        }

        Arrays.sort(numbers);

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
