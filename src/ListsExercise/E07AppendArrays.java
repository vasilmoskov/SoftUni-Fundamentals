package ListsExercise;

import java.util.Scanner;

public class E07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] allArrays = scanner.nextLine().split("\\|");

        for (int i = allArrays.length-1; i >= 0; i--) {
            String [] currentArray = allArrays[i].split("\\s+");
            for (int j = 0; j < currentArray.length; j++) {
                if (!currentArray[j].equals("")) {
                    System.out.print(currentArray[j] + " ");
                }
            }
        }
    }
}
