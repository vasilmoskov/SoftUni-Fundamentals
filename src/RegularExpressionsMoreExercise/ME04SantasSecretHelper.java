package RegularExpressionsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME04SantasSecretHelper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt (scanner.nextLine());

        String message = scanner.nextLine();

        List<String> goodKids = new ArrayList<>();

        while (!message.equals("end")) {
            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char currChar = (char) (message.charAt(i) - key);
                decryptedMessage.append(currChar);
            }

            String regex = "@(?<name>[A-Za-z]+)[^\\@\\-\\!\\:\\>]+!(?<behavior>[GN])!";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            String name = "";
            String behavior = "";

            while (matcher.find()) {
                name = matcher.group(1);
                behavior = matcher.group(2);

            }

            if (!name.equals("") && behavior.equals("G")) {
                goodKids.add(name);
            }

            decryptedMessage.setLength(0);
            message = scanner.nextLine();
        }

        for (String goodKid : goodKids) {
            System.out.println(goodKid);
        }

    }
}
