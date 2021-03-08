package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class E03LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junk = new TreeMap<>();

        boolean legendaryItemObtained = false;
        String materialOfLegendaryItem = "";

        String input = scanner.nextLine();

        while (!legendaryItemObtained) {
            String[] tokens = input.toLowerCase().split(" ");

            for (int i = 0; i < tokens.length; i++) {
                if (legendaryItemObtained) {
                    break;
                }
                int quantity = Integer.parseInt(tokens[i]);
                i++;
                String material = tokens[i];

                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":

                        keyMaterials.put(material, keyMaterials.get(material) + quantity);

                        if (keyMaterials.get(material) >= 250) {

                            materialOfLegendaryItem = material;
                            legendaryItemObtained = true;
                            break;
                        }
                        break;

                    default:
                        if (junk.containsKey(material)) {
                            junk.put(material, junk.get(material) + quantity);
                        } else {
                            junk.put(material, quantity);
                        }
                        break;
                }
            }

            if (legendaryItemObtained) {
                break;
            } else {
                input = scanner.nextLine();
            }
        }

        switch (materialOfLegendaryItem) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        keyMaterials.put(materialOfLegendaryItem, keyMaterials.get(materialOfLegendaryItem) - 250);

        LinkedHashMap<String, Integer> keyMaterialsSorted = new LinkedHashMap<>();
        keyMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> keyMaterialsSorted.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : keyMaterialsSorted.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}