package MapsLambdaAndStreamAPILab;

import java.util.Arrays;
import java.util.Scanner;

public class L04WordFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] filtered = Arrays.stream(scanner.nextLine()
                .split(" "))
                .filter(w -> w.length()%2==0)
                .toArray(String[]::new);

        for (String word : filtered) {
            System.out.println(word);
        }

    }

}
