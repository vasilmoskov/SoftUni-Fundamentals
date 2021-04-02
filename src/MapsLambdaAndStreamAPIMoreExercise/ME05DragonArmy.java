package MapsLambdaAndStreamAPIMoreExercise;

import java.util.*;
import java.util.stream.Stream;

public class ME05DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Dragon>> dragonsStats = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String type = input[0];
            String name = input[1];
            int damage = 45;
            int health = 250;
            int armor = 10;

            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }
            
            Dragon dragon = new Dragon(name, damage, health, armor);

            if (dragonsStats.containsKey(type)) {
                List<Dragon> dragonsOfThisType = dragonsStats.get(type);

                boolean dragonIsAlreadyAdded = false;

                for (int j = 0; j < dragonsOfThisType.size(); j++) {
                    if (dragonsOfThisType.get(j).getName().equals(name)) {
                        dragonIsAlreadyAdded = true;
                        dragonsOfThisType.get(j).setArmor(armor);
                        dragonsOfThisType.get(j).setDamage(damage);
                        dragonsOfThisType.get(j).setHealth(health);
                        break;
                    }
                }

                if (!dragonIsAlreadyAdded) {
                    dragonsOfThisType.add(dragon);
                }

            } else {
                List<Dragon> dragonsOfThisType = new ArrayList<>();
                dragonsOfThisType.add(dragon);
                dragonsStats.put(type, dragonsOfThisType);

            }
        }

        for (Map.Entry<String, List<Dragon>> entry : dragonsStats.entrySet()) {
            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;

            List<Dragon> dragonsOfThisType = entry.getValue();

            for (int i = 0; i < dragonsOfThisType.size(); i++) {
                totalDamage += dragonsOfThisType.get(i).getDamage();
                totalHealth += dragonsOfThisType.get(i).getHealth();
                totalArmor += dragonsOfThisType.get(i).getArmor();
            }

            double averageDamage = totalDamage / dragonsOfThisType.size();
            double averageHealth = totalHealth / dragonsOfThisType.size();
            double averageArmor = totalArmor / dragonsOfThisType.size();

            //dragonsOfThisType.sort(Comparator.comparing(Dragon::getName));

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), averageDamage, averageHealth, averageArmor);
            dragonsOfThisType.stream()
                    .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                    .forEach(e -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                            e.getName(), e.getDamage(), e.getHealth(), e.getArmor()));
        }
    }

    public static class Dragon {
        String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public int getDamage () {
            return damage;
        }

        public int getArmor() {
            return armor;
        }

        public int getHealth() {
            return health;
        }

        public void setDamage (int damage) {
            this.damage = damage;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        public void setHealth(int health) {
            this.health = health;
        }
    }
}
