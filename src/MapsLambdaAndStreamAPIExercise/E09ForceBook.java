package MapsLambdaAndStreamAPIExercise;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toMap;

public class E09ForceBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> sides = new TreeMap<>();

        String input = scanner.nextLine();

        List<String> allUsers = new ArrayList<>();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {
                String[] tokens = input.split(" \\| ");
                String forceSide = tokens[0];
                String forceUser = tokens[1];

                /*
                if (!sides.containsValue(forceUser)) {
                    if (!sides.containsKey(forceSide)) {
                        List<String> users = new ArrayList<>();
                        users.add(forceUser);
                        sides.put(forceSide, users);
                    } else {
                        List<String> users = sides.get(forceSide);
                        users.add(forceUser);
                    }
                }

                 */

                if (!allUsers.contains(forceUser)) {
                    if (!sides.containsKey(forceSide)) {
                        List<String> users = new ArrayList<>();
                        users.add(forceUser);
                        sides.put(forceSide, users);
                        allUsers.add(forceUser);
                    } else {
                        List<String> users = sides.get(forceSide);
                        if (!users.contains(forceUser)) {
                            users.add(forceUser);
                            sides.put(forceSide, users);
                            allUsers.add(forceUser);
                        }
                    }
                }

            } else {
                String[] tokens = input.split(" -> ");
                String forceUser = tokens[0];
                String forceSide = tokens[1];

                boolean thereIsSuchUser = false;

                for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
                    List<String> users = entry.getValue();

                    if (users.contains(forceUser)) {
                        thereIsSuchUser = true;

                        if (sides.containsKey(forceSide)) {
                            if (!entry.getKey().equals(forceSide)) {
                                users.remove(forceUser);
                                List<String> usersInNewSide = sides.get(forceSide);

                                if (!usersInNewSide.contains(forceUser)) {
                                    usersInNewSide.add(forceUser);
                                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                                }
                            }
                        }
                        break;
                    }
                }


                if (!thereIsSuchUser) {
                    if (sides.containsKey(forceSide)) {
                        List<String> usersInNewSide = sides.get(forceSide);
                        usersInNewSide.add(forceUser);
                    } else {
                        List<String> usersInNewSide = new ArrayList<>();
                        usersInNewSide.add(forceUser);
                        sides.put(forceSide, usersInNewSide);
                    }
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, List<String>> sidesSorted = new LinkedHashMap<>();

        sides.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEachOrdered(x -> sidesSorted.put(x.getKey(), x.getValue()));


        for (Map.Entry<String, List<String>> entry : sidesSorted.entrySet()) {
            if (entry.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                List<String> usersInThisSide = entry.getValue();
                Collections.sort(usersInThisSide);
                for (String user : usersInThisSide) {
                    System.out.printf("! %s%n", user);
                }
            }
        }
    }
}
