package TextProcessingExercise;

import java.util.Scanner;

public class E03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\\\");

        String [] fileAndExtension = input[input.length-1].split("\\.");

        String file = fileAndExtension [0];
        String extension = fileAndExtension [1];

        System.out.println("File name: " + file);
        System.out.println("File extension: " + extension);

    }
}
