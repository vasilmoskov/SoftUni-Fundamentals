package MapsLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class ME01Ranking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> contestsPasswords = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String[] inputAsArr = input.split(":");
            String contest = inputAsArr[0];
            String password = inputAsArr[1];
            contestsPasswords.put(contest, password);

            input = scanner.nextLine();
        }

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            String[] inputAsArr = input.split("=>");
            String contest = inputAsArr[0];
            String password = inputAsArr[1];
            String username = inputAsArr[2];
            int points = Integer.parseInt(inputAsArr[3]);

            if (contestsPasswords.containsKey(contest)) {
                String correctPassword = contestsPasswords.get(contest);

                if (password.equals(correctPassword)) {

                    if (!users.containsKey(username)) {
                        TreeMap<String, Integer> contestsPoints = new TreeMap<>();
                        contestsPoints.put(contest, points);
                        users.put(username, contestsPoints);

                    } else {
                        TreeMap<String, Integer> contestsPoints = users.get(username);

                        if (!contestsPoints.containsKey(contest)) {
                            contestsPoints.put(contest, points);
                            users.put(username, contestsPoints);
                        } else {
                            int bestResultSoFar = contestsPoints.get(contest);
                            if (points > bestResultSoFar) {
                                contestsPoints.put(contest, points);
                                users.put(username, contestsPoints);
                            }
                        }

                    }
                }
            }

            input = scanner.nextLine();
        }
        
        int mostPoints = Integer.MIN_VALUE;
        String userWithMostPoints = "";

        for (Map.Entry<String, TreeMap<String, Integer>> entry : users.entrySet()) {
            String currentUser = entry.getKey();
            TreeMap<String, Integer> currentPoints = entry.getValue();

            int pointsCurrentUser = 0;

            for (Integer value : currentPoints.values()) {
                pointsCurrentUser += value;
            }

            if (pointsCurrentUser>mostPoints) {
                mostPoints = pointsCurrentUser;
                userWithMostPoints = currentUser;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", userWithMostPoints, mostPoints);
        System.out.println("Ranking:");

        for (Map.Entry<String, TreeMap<String, Integer>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            TreeMap<String, Integer> currentPoints = entry.getValue();

            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

            currentPoints.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Integer> stringIntegerEntry : sortedMap.entrySet()) {
                System.out.printf("#  %s -> %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }

        }
    }
}