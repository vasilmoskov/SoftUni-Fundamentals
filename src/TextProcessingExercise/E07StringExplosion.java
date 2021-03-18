package TextProcessingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                if (i + 1 < input.length()) {
                    power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                    while (power > 0) {
                        if (i + 1 < input.length()) {

                            if (input.charAt(i + 1) == '>') {
                                break;
                            }

                            input.replace(i + 1, i + 2, "");
                            power--;
                        } else {
                            System.out.println(input);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(input);
    }
}
