package ProgrammingFundamentalsMidExams;

import java.util.*;
import java.util.stream.Collectors;

public class E03Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cards = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> deck = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Ready")) {
            String[] inputAsArr = input.split("\\s+");

            String action = inputAsArr[0];

            if (action.equals("Add")) {
                String cardName = inputAsArr[1];

                if (!cards.contains(cardName)) {
                    System.out.println("Card not found.");
                } else {
                    deck.add(cardName);
                    cards.remove(cardName);
                }

            } else if (action.equals("Insert")) {
                String cardName = inputAsArr[1];
                int index = Integer.parseInt(inputAsArr[2]);

                if (!cards.contains(cardName)) {
                    System.out.println("Error!");
                } else {
                    if (index >= 0 && index < deck.size()) {
                        deck.add(index, cardName);
                        cards.remove(cardName);
                    }
                }

            } else if (action.equals("Remove")) {

                String cardName = inputAsArr[1];

                if (!deck.contains(cardName)) {
                    System.out.println("Card not found.");
                } else {
                    deck.remove(cardName);
                    cards.remove(cardName);
                }

            } else if (action.equals("Swap")) {
                String cardName1 = inputAsArr[1];
                String cardName2 = inputAsArr[2];

                int indexOfCard1 = deck.indexOf(cardName1);
                int indexOfCard2 = deck.indexOf(cardName2);

                deck.set(indexOfCard1, cardName2);
                deck.set(indexOfCard2, cardName1);

            } else if (action.equals("Shuffle")) {
                Collections.reverse(deck);
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(" ", deck));

    }
}