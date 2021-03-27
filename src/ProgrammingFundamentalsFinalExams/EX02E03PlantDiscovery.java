package ProgrammingFundamentalsFinalExams;

import java.util.*;

public class EX02E03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Plant> plants = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plantName = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            if (!plants.containsKey(plantName)) {
                Plant plant = new Plant(plantName, rarity);
                plants.put(plantName, plant);
            } else {
                plants.get(plantName).setRarity(rarity);
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];

            switch (command) {
                case "Rate":
                    String plantName = tokens[1].split(" - ")[0];
                    double rating = Double.parseDouble(tokens[1].split(" - ")[1]);

                    if (plants.containsKey(plantName)) {
                        plants.get(plantName).addRating(rating);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Update":
                    plantName = tokens[1].split(" - ")[0];
                    int rarity = Integer.parseInt(tokens[1].split(" - ")[1]);

                    if (plants.containsKey(plantName)) {
                        plants.get(plantName).setRarity(rarity);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Reset":
                    plantName = tokens[1];
                    if (plants.containsKey(plantName)) {
                        plants.get(plantName).removeAllRatings();
                    } else {
                        System.out.println("error");
                    }

                    break;

            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plants.entrySet().stream()
                .sorted((e1, e2) -> {
                    double res = Double.compare(e2.getValue().getRarity(), e1.getValue().getRarity());

                    if (res==0){
                        res = Double.compare(e2.getValue().getAverageRating(), e1.getValue().getAverageRating());
                    }

                    return (int) res;

                }).forEach(e-> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n"
                                 , e.getKey(), e.getValue().getRarity(), e.getValue().getAverageRating()));
    }


    public static class Plant implements Comparator<Plant> {
        String name;
        int rarity;
        List<Double> ratings = new ArrayList<>();

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void addRating(double rating) {
            this.ratings.add(rating);
        }

        public void removeAllRatings() {
            this.ratings.clear();
        }

        public double getAverageRating() {
            double total = 0;

            for (Double rating : this.ratings) {
                total += rating;
            }

            if (this.ratings.isEmpty()) {
                return 0;
            }

            return total / this.ratings.size();
        }

        @Override
        public int compare(Plant first, Plant second) {
            int result = Integer.compare(second.getRarity(), first.getRarity());
            return result != 0 ? result : Double.compare(second.getAverageRating(), second.getAverageRating());
        }
    }
}
