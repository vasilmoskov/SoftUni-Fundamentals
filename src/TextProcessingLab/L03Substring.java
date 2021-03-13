package TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L03Substring {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String removeWord = scanner.nextLine();
        String text = scanner.nextLine();

        int index = text.indexOf(removeWord);
        while (index != -1) {
            text = text.replace(removeWord, "");
            index = text.indexOf(removeWord);
        }

        System.out.println(text);

        /*
        String[] initialArray = text.split(removeWord);
        String finalWordAsString = String.join("", initialArray);
        while (finalWordAsString.contains(removeWord)) {
            String [] newArray = finalWordAsString.split(removeWord);
            finalWordAsString = String.join("", newArray);
        }
        System.out.println(finalWordAsString);
         */
    }
}
