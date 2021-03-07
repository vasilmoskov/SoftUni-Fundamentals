package MapsLambdaAndStreamAPILab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.ToDoubleFunction;

public class L01CountRealNumbers {
    public static void main(String[] args) {

        Map<Double, Integer> numberOccurences = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsStings = input.split(" ");


        double[] numbers = new double[inputAsStings.length];
        for (int i = 0; i < inputAsStings.length; i++) {
            double number = Double.parseDouble(inputAsStings[i]);

            Integer occurences = numberOccurences.get(number);
            // Главния интеджър поддържа null.
            // Първия път, когато срещна някакво число number, което не съм го добавял досега, ще полуза за occurences стойността null
            if (occurences == null) {
                occurences = 0;
            }
            numberOccurences.put(number, occurences + 1);
        }

        /*
            алтернативно може да се напише по следния начин:
            for (double number : numbers) {
                if (!numberOccurences.containsKey(number)) {
                    numberOccurences.put(number, 0);
                    // ако не съдържа такъв ключ num, да го добави с 0
                }
                numberOccurences.put(num, numberOccurences.get(number)+1);
            }
        */

        for (Map.Entry<Double, Integer> entry : numberOccurences.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }


    }
}
