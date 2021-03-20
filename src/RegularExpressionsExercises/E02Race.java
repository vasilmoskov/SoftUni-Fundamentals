package RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(", ");

        LinkedHashMap<String, Integer> distances = new LinkedHashMap<>();

        for (int i = 0; i < participants.length; i++) {
            String currentRacerName = participants[i];
            distances.put(currentRacerName, 0);
        }


        String input = scanner.nextLine();
        String regexName = "[A-Za-z]";
        Pattern patternName = Pattern.compile(regexName);
        String regexKm = "[0-9]";
        Pattern patternKm = Pattern.compile(regexKm);

        while (!input.equals("end of race")) {

            Matcher matcherName = patternName.matcher(input);
            Matcher matcherKm = patternKm.matcher(input);

            int currentDistance = 0;
            StringBuilder currentRacer = new StringBuilder();

            while (matcherName.find()) {
                currentRacer.append(matcherName.group());
            }

            while (matcherKm.find()) {
                currentDistance += Integer.parseInt(matcherKm.group());
            }

            String currentRacerAsString = String.valueOf(currentRacer);

            if (distances.containsKey(currentRacerAsString)) {
                distances.put(currentRacerAsString, distances.get(currentRacerAsString) + currentDistance);
            }

            currentRacer.setLength(0);
            input = scanner.nextLine();
        }

        /*

        distances.entrySet().stream()
                .sorted((e1, e2) -> {
                            int res = e2.getValue().compareTo(e1.getValue());
                            if (res == 0) {
                                res = e1.getKey().compareTo(e2.getKey());
                            }
                            return res;
                        }
                )
                .limit(3)
                .forEach(e-> System.out.println());

                        System.out.println();


         */

        Set<Map.Entry<String, Integer>> setDistances = distances.entrySet();
        List<Map.Entry<String, Integer>> listDistances = new ArrayList<Map.Entry<String, Integer>>(setDistances);
        Collections.sort(listDistances, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> e1,
                               Map.Entry<String, Integer> e2) {

                return e2.getValue().compareTo(e1.getValue());

            }
        });

        int countPlaces = 0;

        for (Map.Entry<String, Integer> entry : listDistances) {
            if (countPlaces == 3) {
                break;
            }
            if (countPlaces == 0) {
                System.out.printf("1st place: %s%n", entry.getKey());
            } else if (countPlaces==1) {
                System.out.printf("2nd place: %s%n", entry.getKey());
            } else if (countPlaces==2) {
                System.out.printf("3rd place: %s%n", entry.getKey());
            }
            countPlaces++;
        }
    }
}
