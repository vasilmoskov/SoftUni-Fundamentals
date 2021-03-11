package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class E10SoftUniExamResults {
    public static void main(String[] args) {

        //You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished".
        // You should store each username and his submissions and points.

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> results = new TreeMap<>();
        TreeMap<String, Integer> submissions = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            String[] inputAsArrString = input.split("-");
            String username = inputAsArrString[0];

            if (inputAsArrString[1].equals("banned")) {
                results.remove(username);

                //You can receive a command to ban a user for cheating in the following format: "{username}-banned".
                // In that case, you should remove the user from the contest,
                // but preserve his submissions in the total count of submissions for each language.

            } else {

                String language = inputAsArrString[1];
                int points = Integer.parseInt(inputAsArrString[2]);

                if (!results.containsKey(username)) {
                    results.put(username, points);
                } else {
                    if (results.get(username) <= points) {
                        results.put(username, points);
                    }
                }

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language)+1);
                }

            }
            input = scanner.nextLine();
        }

        Set<Map.Entry<String, Integer>> setResults = results.entrySet();
        List<Map.Entry<String, Integer>> listResults = new ArrayList<Map.Entry<String, Integer>>(setResults);
        Collections.sort(listResults, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> arg0,
                               Map.Entry<String, Integer> arg1) {

                return arg1.getValue().compareTo(arg0.getValue());

            }
        });

        System.out.println("Results:");

        for (Map.Entry<String, Integer> entry : listResults) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }

        //After receiving "exam finished",
        // print each of the participants, ordered descending by their max points, then by username, in the following format:
        //Results:
        //{username} | {points}

        Set<Map.Entry<String, Integer>> setSubmissions = submissions.entrySet();
        List<Map.Entry<String, Integer>> listSubmissions = new ArrayList<Map.Entry<String, Integer>>(setSubmissions);
        Collections.sort(listSubmissions, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> arg0,
                               Map.Entry<String, Integer> arg1) {

                return arg1.getValue().compareTo(arg0.getValue());

            }
        });

        System.out.println("Submissions:");

        for (Map.Entry<String, Integer> entry : listSubmissions) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }

        //After that print each language, used in the exam,
        // ordered descending by total submission count and then by language name, in the following format:
        //Submissions:
        //{language} - {submissionsCount}
    }
}
