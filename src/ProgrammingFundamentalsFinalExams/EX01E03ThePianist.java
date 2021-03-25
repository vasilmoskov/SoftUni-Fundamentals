package ProgrammingFundamentalsFinalExams;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EX01E03ThePianist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Piece> pieces = new TreeMap<>();
        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPieces; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String pieceName = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            Piece piece = new Piece(pieceName, composer, key);
            pieces.put(pieceName, piece);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String pieceName = tokens[1];
                    String composer = tokens[2];
                    String key = tokens[3];

                    if (pieces.containsKey(pieceName)) {
                        System.out.println(pieceName + " is already in the collection!");
                    } else {
                        Piece piece = new Piece(pieceName, composer, key);
                        pieces.put(pieceName, piece);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, key);
                    }
                    break;

                case "Remove":
                     pieceName = tokens[1];

                    if (pieces.containsKey(pieceName)) {
                        pieces.remove(pieceName);
                        System.out.println("Successfully removed " + pieceName + "!");
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }
                    break;

                case "ChangeKey":
                    pieceName = tokens[1];
                    String newKey = tokens[2];

                    if (pieces.containsKey(pieceName)) {
                        pieces.get(pieceName).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }


                    break;
            }

            input = scanner.nextLine();
        }

        pieces.entrySet().forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        e.getValue().getPieceName(), e.getValue().getComposer(), e.getValue().getKey()));

    }


    public static class Piece {
        private String pieceName;
        private String composer;
        private String key;

        public Piece(String pieceName, String composer, String key) {
            this.pieceName = pieceName;
            this.composer = composer;
            this.key = key;
        }

        public String getPieceName () {
            return pieceName;
        }

        public String getComposer () {
            return composer;
        }

        public String getKey () {
            return key;
        }

        public void setKey (String key) {
            this.key = key;
        }
    }
}
