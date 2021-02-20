package ObjectsAndClassesExercise;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class E01AdvertisementMessage {

    static class Message {
        String[] phrase;
        String[] event;
        String[] author;
        String[] city;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        Message possibleMessages = new Message();
        possibleMessages.phrase = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        possibleMessages.event = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        possibleMessages.author = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        possibleMessages.city = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();
        for (int i = 0; i < numberOfMessages; i++) {
            int randomNumberForPhrase = random.nextInt(possibleMessages.phrase.length);
            String phrase = possibleMessages.phrase[randomNumberForPhrase];

            int randomNumberForEvent = random.nextInt(possibleMessages.event.length);
            String event = possibleMessages.event[randomNumberForEvent];

            int randomNumberForAuthor = random.nextInt(possibleMessages.author.length);
            String author = possibleMessages.author[randomNumberForAuthor];

            int randomNumberForCity = random.nextInt(possibleMessages.city.length);
            String city = possibleMessages.city[randomNumberForCity];

            System.out.printf("%s %s %s - %s%n", phrase, event, author, city);
        }

    }
}
