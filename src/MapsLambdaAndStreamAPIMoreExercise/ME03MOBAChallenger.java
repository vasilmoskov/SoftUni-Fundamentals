package MapsLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class ME03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> players = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Season end")) {
            if (!input.contains("vs")) {
                String[] inputAsArr = input.split(" -> ");
                String player = inputAsArr[0];
                String position = inputAsArr[1];
                int skill = Integer.parseInt(inputAsArr[2]);

                if (!players.containsKey(player)) {
                    TreeMap<String, Integer> skills = new TreeMap<>();
                    skills.put(position, skill);
                    players.put(player, skills);
                } else {
                    TreeMap<String, Integer> skills = players.get(player);

                    if (!skills.containsKey(position)) {
                        skills.put(position, skill);
                        players.put(player, skills);

                    } else {
                        if (skill > skills.get(position)) {
                            skills.put(position, skill);
                            players.put(player, skills);
                        }
                    }
                }
            } else if (input.contains("vs")) {
                String[] inputAsArr = input.split(" vs ");
                String player1 = inputAsArr[0];
                String player2 = inputAsArr[1];

                if (players.containsKey(player1) && players.containsKey(player2)) {
                    TreeMap<String, Integer> positionsPlayer1 = players.get(player1);
                    TreeMap<String, Integer> positionsPlayer2 = players.get(player2);

                    for (Map.Entry<String, Integer> entryPlayer1 : positionsPlayer1.entrySet()) {
                        String positionPlayer1 = entryPlayer1.getKey();
                        int skillsPlayer1 = entryPlayer1.getValue();
                        for (Map.Entry<String, Integer> entryPlayer2 : positionsPlayer2.entrySet()) {
                            String positionPlayer2 = entryPlayer2.getKey();
                            int skillsPlayer2 = entryPlayer2.getValue();
                            if (positionPlayer1.equals(positionPlayer2)) {
                                if (skillsPlayer1 > skillsPlayer2) {
                                    players.remove(player2);
                                } else if (skillsPlayer2 > skillsPlayer1) {
                                    players.remove(player1);
                                }
                            }
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        TreeMap<String, Integer> totalPoints = new TreeMap<>();

        for (Map.Entry<String, TreeMap<String, Integer>> entry : players.entrySet()) {
            String player = entry.getKey();
            int totalPointsCurrPlayer = 0;
            TreeMap<String, Integer> currentPlayerSkills = entry.getValue();

            for (Integer value : currentPlayerSkills.values()) {
                totalPointsCurrPlayer += value;
            }

            totalPoints.put(player, totalPointsCurrPlayer);

        }

        LinkedHashMap<String, Integer> totalSkillsOrdered = new LinkedHashMap<>();

        totalPoints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> totalSkillsOrdered.put(x.getKey(), x.getValue()));



        for (Map.Entry<String, Integer> entry : totalSkillsOrdered.entrySet()) {
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());

            TreeMap<String, Integer> positionPointsCurrPlayer = players.get(entry.getKey());

            LinkedHashMap<String, Integer> skillsOrdered = new LinkedHashMap<>();

            positionPointsCurrPlayer.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> skillsOrdered.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Integer> stringIntegerEntry : skillsOrdered.entrySet()) {
                System.out.printf("- %s <::> %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }
        }
    }
}