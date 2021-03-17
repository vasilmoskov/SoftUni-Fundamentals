package TextProcessingMoreExercise;

import java.util.Scanner;

public class ME01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int nameStart = input.indexOf('@');
            int nameEnd = input.indexOf('|');

            int ageStart = input.indexOf('#');
            int ageEnd = input.indexOf('*');

            String name = input.substring(nameStart + 1, nameEnd);
            int age = Integer.parseInt(input.substring(ageStart + 1, ageEnd));

            System.out.printf("%s is %d years old.%n", name, age);

        }
    }
}
