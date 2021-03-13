package TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04TextFilter {

    static String repeat(String str, int repeatCount) {
        String replacement = "";
        for (int i = 0; i < repeatCount; i++) {
            replacement+=str;
        }
        return replacement;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String bannedWords = scanner.nextLine();
        String text = scanner.nextLine();

        String [] bannedWordsSeparated = bannedWords.split(", ");

        for (int i = 0; i < bannedWordsSeparated.length; i++) {
            String replacement = repeat("*", bannedWordsSeparated[i].length());
            text = text.replace(bannedWordsSeparated[i], replacement);
        }
        System.out.println(text);
    }
}
