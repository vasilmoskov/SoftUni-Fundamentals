package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {
        //You have a water tank with capacity of 255 liters.
        //On the next n lines, you will receive liters of water, which you have to pour in your tank.
        //If the capacity is not enough, print “Insufficient capacity!” and continue reading the next line.
        // On the last line, print the liters in the tank.

        //Input
        //The input will be on two lines:
        //•	On the first line, you will receive n – the number of lines, which will follow
        //•	On the next n lines – you receive quantities of water, which you have to pour in the tank

        int capacity = 255;
        int litersInTheTank = 0;

        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            int currentQuantity = Integer.parseInt (scanner.nextLine());
            if (currentQuantity > capacity) {
                System.out.println("Insufficient capacity!");
            } else {
                litersInTheTank += currentQuantity;
                capacity -= currentQuantity;
            }
        }

        System.out.println(litersInTheTank);

        //Output
        //Every time you do not have enough capacity in the tank to pour the given liters, print:
        //Insufficient capacity!
        //On the last line, print only the liters in the tank.

        //Constraints
        //•	n will be in the interval [1…20]
        //•	liters will be in the interval [1…1000]
    }
}
