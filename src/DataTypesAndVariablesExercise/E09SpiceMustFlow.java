package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {

        //Write a program that calculates the total amount of spice that can be extracted from a source.
        //The source has a starting yield, which indicates how much spice can be mined on the first day.
        // After it has been mined for a day, the yield drops by 10,
        // meaning on the second day it’ll produce 10 less spice than on the first,
        // on the third day 10 less than on the second, and so on (see examples).

        //A source is considered profitable only while its yield is at least 100 –
        // when less than 100 spice is expected in a day, abandon the source.

        //The mining crew consumes 26 spice every day at the end of their shift
        // and an additional 26 after the mine has been exhausted.
        // Note that the workers cannot consume more spice than there is in storage.
        //When the operation is complete, print on the console on two separate lines
        // how many days the mine has operated
        // and the total amount of spice extracted.

        //Input
        //You will receive a number, representing the starting yield of the source.

        Scanner scanner = new Scanner(System.in);

        int currentYield = Integer.parseInt(scanner.nextLine());

        int daysOperated = 0;
        int spiceExtracted = 0;

        while (currentYield >= 100) {
            daysOperated++;

            spiceExtracted += currentYield;
            spiceExtracted -= 26;
            currentYield -= 10;
        }

        if (spiceExtracted >= 26) {
            spiceExtracted -= 26;
        }

        System.out.println(daysOperated);
        System.out.println(spiceExtracted);

        //Output
        //Print on the console on two separate lines how many days the mine has operated
        // and the total amount of spice extracted.

        // Constraints
        //•	The starting yield will be a positive integer within range [0 … 2 147 483 647]

    }
}
