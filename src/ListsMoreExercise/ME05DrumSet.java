package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME05DrumSet {
    public static void main(String[] args) {

        //Input
        //•	On the first line you receive the savings – a floating-point number;
        //•	On the second line you receive the drum set: sequence of integers, separated by spaces.
        //•	Until you receive the command "Hit it again, Gabsy!"
        // you will be receiving integers – the hit power Gabsy applies on each drum.

        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSetWithInitialQuality = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        List<Integer> drumSetWithDamagedQuality = new ArrayList<>();
        drumSetWithDamagedQuality.addAll(drumSetWithInitialQuality);

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSetWithDamagedQuality.size(); i++) {
                int qualityOfCurrentDrum = drumSetWithDamagedQuality.get(i) - hitPower;
                if (qualityOfCurrentDrum <= 0) {
                    double price = drumSetWithInitialQuality.get(i) * 3;
                    if (price <= savings) {
                        drumSetWithDamagedQuality.set(i, drumSetWithInitialQuality.get(i));
                        savings -= price;
                    } else {
                        drumSetWithDamagedQuality.remove(i);
                        drumSetWithInitialQuality.remove(i);
                        if (i == drumSetWithDamagedQuality.size()) {
                            break;
                        } else {
                            i--;
                        }
                    }
                } else {
                    drumSetWithDamagedQuality.set(i, qualityOfCurrentDrum);
                }
            }

            input = scanner.nextLine();
        }

        for (Integer drum : drumSetWithDamagedQuality) {
            System.out.print(drum + " ");
        }
        System.out.println();

        System.out.printf("Gabsy has %.2flv.", savings);

        //Output
        //•	On the first line you should print each drum in the drum set, separated by space.
        //•	Then you must print the money that are left on the second line in the format
        // "Gabsy has {money left}lv.", formatted with two digits after the decimal point.
    }
}
