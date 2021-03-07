package MapsLambdaAndStreamAPILab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L03OddOccurrences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = (words[i].toLowerCase());
            Integer occurences = counts.get(word);
            if (occurences == null) {
                occurences = 0;
            }
            counts.put(word, occurences + 1);
        }

        String output = "";

        ArrayList<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", odds));

/*
        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i<odds.size()-1){
                System.out.print(", ");
            }
        }

 */
    }
}
