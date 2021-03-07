package MapsLambdaAndStreamAPILab;

import java.util.*;

public class L02WordSynonyms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());
        Map<String, List<String>> wordSynonyms = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            /*
            List<String> currentSynonyms = wordSynonyms.get(word);
            if (currentSynonyms== null) {
                currentSynonyms = new ArrayList<>();
                wordSynonyms.put(word, currentSynonyms);
            }
            currentSynonyms.add(synonym);
            */

            wordSynonyms.putIfAbsent(word, new ArrayList<>());
            wordSynonyms.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }
    }
}
