package ProgrammingFundamentalsFinalExams;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EX04E03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Hero> heroes = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String heroName = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            Hero hero = new Hero(heroName, hp, mp);

            heroes.put(heroName, hero);

        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String action = tokens[0];
            String heroName = tokens[1];

            switch (action) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    if (heroes.get(heroName).getMp() >= mpNeeded) {
                        int manaLeft = heroes.get(heroName).getMp() - mpNeeded;
                        heroes.get(heroName).setMp(manaLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, manaLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }

                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    int currentHP = heroes.get(heroName).getHp() - damage;

                    if (currentHP > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, currentHP);

                        heroes.get(heroName).setHp(currentHP);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }

                    break;
                case "Recharge":
                    int amountMP = Integer.parseInt (tokens[2]);
                    int oldAmountMP = heroes.get(heroName).getMp();
                    int newAmountMP = oldAmountMP + amountMP;

                    if (newAmountMP > 200) {
                        amountMP = 200 - oldAmountMP;
                        newAmountMP = 200;
                    }

                    heroes.get(heroName).setMp(newAmountMP);

                    System.out.printf("%s recharged for %d MP!%n", heroName, amountMP);

                    break;

                case "Heal":

                    int amountHP = Integer.parseInt (tokens[2]);
                    int oldAmountHP = heroes.get(heroName).getHp();
                    int newAmountHP = oldAmountHP + amountHP;

                    if (newAmountHP > 100) {
                        amountHP = 100 - oldAmountHP;
                        newAmountHP = 100;
                    }

                    heroes.get(heroName).setHp(newAmountHP);

                    System.out.printf("%s healed for %d HP!%n", heroName, amountHP);

                    break;
            }

            command = scanner.nextLine();
        }

        heroes.entrySet().stream()
                .sorted((e1, e2) -> {
                    int res = Integer.compare(e2.getValue().getHp(), e1.getValue().getHp());
                    if (res == 0) {
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                })
                .forEach(e -> {
                    System.out.printf("%s%n  HP: %d%n  MP: %d%n", e.getKey(), e.getValue().getHp(), e.getValue().getMp());
                });
    }

    public static class Hero {
        String name;
        int hp;
        int mp;

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getMp() {
            return mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }
    }
}
