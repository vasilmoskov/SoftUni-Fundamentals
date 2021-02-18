package ObjectsAndClassesLab;


import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class L01RandomizeWords {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String [] words = input.split(" ");

        Random random = new Random();
        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = random.nextInt(words.length);
            String oldWordPos1 = words[pos1];
            words[pos1] = words[pos2];
            words[pos2] = oldWordPos1;
        }
        System.out.println(String.join(System.lineSeparator(), words));


    }
}
