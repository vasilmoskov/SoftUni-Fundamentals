package ProgrammingFundamentalsFinalExams;

import java.util.*;

public class EX05E03Pirates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> citiesPopulation = new TreeMap<>();
        Map<String, Integer> citiesGold = new TreeMap<>();

        while (!input.equals("Sail")) {
            String tokens[] = input.split("\\|{2}");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!citiesPopulation.containsKey(city)) {
                citiesPopulation.put(city, population);
                citiesGold.put(city, gold);
            } else {
                citiesPopulation.put(city, citiesPopulation.get(city) + population);
                citiesGold.put(city, citiesGold.get(city) + gold);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("=>");
            String action = tokens[0];

            if (action.equals("Plunder")) {
                String city = tokens[1];
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);

                //check if city exists ?
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);

                citiesPopulation.put(city, citiesPopulation.get(city) - people);
                citiesGold.put(city, citiesGold.get(city) - gold);

                if (citiesPopulation.get(city) == 0 || citiesGold.get(city) == 0) {
                    citiesPopulation.remove(city);
                    citiesGold.remove(city);

                    System.out.println(city + " has been wiped off the map!");
                }


            } else if (action.equals("Prosper")) {
                String city = tokens[1];
                int gold = Integer.parseInt(tokens[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {

                    citiesGold.put(city, citiesGold.get(city) + gold);

                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, citiesGold.get(city));
                }

            }

            input = scanner.nextLine();
        }

        if (!citiesGold.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesGold.size());

            citiesGold.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int res = e2.getValue().compareTo(e1.getValue());
                        if (res == 0) {
                            res = e1.getKey().compareTo(e2.getKey());
                        }
                        return res;
                    })
                    .forEach((e) -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), citiesPopulation.get(e.getKey()) ,e.getValue());
                    });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
