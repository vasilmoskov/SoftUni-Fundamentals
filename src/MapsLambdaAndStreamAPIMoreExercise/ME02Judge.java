package MapsLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class ME02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, Integer>> contests = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("no more time")) {
            String[] inputAsArr = input.split(" -> ");
            String username = inputAsArr[0];
            String contest = inputAsArr[1];
            int points = Integer.parseInt(inputAsArr[2]);

            if (!contests.containsKey(contest)) {
                TreeMap<String, Integer> usersPoints = new TreeMap<>();
                usersPoints.put(username, points);
                contests.put(contest, usersPoints);
            } else {
                TreeMap<String, Integer> usersPoints = contests.get(contest);
                if (!usersPoints.containsKey(username)) {
                    usersPoints.put(username, points);
                    contests.put(contest, usersPoints);
                } else {
                    int bestScoreSoFar = usersPoints.get(username);
                    if (points > bestScoreSoFar) {
                        usersPoints.put(username, points);
                        contests.put(contest, usersPoints);
                    }
                }
            }

            input = scanner.nextLine();
        }

        //print each contest in order of input,
        // for each contest print the participants ordered by points in desecending order,
        // than ordered by name in ascending order.

        for (Map.Entry<String, TreeMap<String, Integer>> entry : contests.entrySet()) {
            TreeMap<String, Integer> currentContest = entry.getValue();

            LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();

            System.out.printf("%s: %d participants%n", entry.getKey(), currentContest.size());

            currentContest.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

            int count = 1;
            for (Map.Entry<String, Integer> stringIntegerEntry : sorted.entrySet()) {
                System.out.printf("%d. %s <::> %d%n", count, stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                count++;
            }

        }

        TreeMap<String, Integer> totalPoints = new TreeMap<>();

        for (Map.Entry<String, TreeMap<String, Integer>> entry : contests.entrySet()) {
            TreeMap<String, Integer> currentContest = entry.getValue();
            for (Map.Entry<String, Integer> stringIntegerEntry : currentContest.entrySet()) {
                String participant = stringIntegerEntry.getKey();
                int points = stringIntegerEntry.getValue();

                if (!totalPoints.containsKey(participant)) {
                    totalPoints.put(participant, points);
                } else {
                    totalPoints.put(participant, totalPoints.get(participant) + points);
                }
            }
        }

        System.out.println("Individual standings:");


        LinkedHashMap<String, Integer> totalPointsSorted = new LinkedHashMap<>();

        totalPoints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> totalPointsSorted.put(x.getKey(), x.getValue()));

        int count = 1;

        for (Map.Entry<String, Integer> entry : totalPointsSorted.entrySet()) {
            System.out.printf("%d. %s -> %d%n", count, entry.getKey(), entry.getValue());
            count++;
        }

        // After that, you should print individual statistics for every participant
        // ordered by total points in desecnding order, and then by alphabetical order.


    }
}
