package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX05E02MuOnline {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        int bestRoom = 0;
        boolean youAreAlive = true;

        String[] rooms = scanner.nextLine().split("\\|");

        //You have initial health 100 and initial bitcoins 0.
        // You will be given a string, representing the dungeons rooms.
        // Each room is separated with '|' (vertical bar): "room1|room2|room3…"

        for (int i = 0; i < rooms.length; i++) {
            String[] tokensOfCurrentRoom = rooms[i].split(" ");
            String command = tokensOfCurrentRoom[0];
            int number = Integer.parseInt(tokensOfCurrentRoom[1]);

            if (command.equals("potion")) {

                health += number;
                if (health > 100) {
                    number -= health - 100;
                    health = 100;
                }

                System.out.printf("You healed for %d hp.%n", number);
                System.out.printf("Current health: %d hp.%n", health);

                //Each room contains a command and a number, separated by space. The command can be:
                //•	"potion"
                //o	You are healed with the number in the second part. But your health cannot exceed your initial health (100).
                //o	First print: "You healed for {amount} hp.".
                //o	After that, print your current health: "Current health: {health} hp.".

            } else if (command.equals("chest")) {

                System.out.printf("You found %d bitcoins.%n", number);
                bitcoins += number;

                //•	"chest"
                //o	You've found some bitcoins, the number in the second part.
                //o	Print: "You found {amount} bitcoins."

            } else {

                health -= number;

                if (health <= 0) {
                    System.out.printf("You died! Killed by %s.%n", command);
                    bestRoom = i + 1;
                    System.out.printf("Best room: %d%n", bestRoom);
                    youAreAlive = false;
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", command);
                }
            }
        }

        if (youAreAlive) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }


        //•	In any other case you are facing a monster, you are going to fight.
        // The second part of the room, contains the attack of the monster.
        // You should remove the monster's attack from your health.

        //o	If you are not dead (health <= 0) you've slain the monster, and you should print ("You slayed {monster}.")

        //o	If you've died, print "You died! Killed by {monster}." and your quest is over.
        // Print the best room you`ve manage to reach: "Best room: {room}".

        //If you managed to go through all the rooms in the dungeon, print on the next three lines:
        //"You've made it!", "Bitcoins: {bitcoins}", "Health: {health}".


    }
}
