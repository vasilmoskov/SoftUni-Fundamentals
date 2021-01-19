package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //The distance between his targets reduces his poke power.

        //input:
        // You will be given the poke power the Poke Mon has, N – an integer.
        // Then you will be given the distance between the poke targets, M – an integer.
        // Then you will be given the exhaustionFactor Y – an integer.

        //Constrains
        //•	The integer N will be in the range [1, 2.000.000.000].
        //•	The integer M will be in the range [1, 1.000.000].
        //•	The integer Y will be in the range [0, 9].
        //•	Allowed time / memory: 16 MB / 100ms.

        //start subtracting M from N until N becomes less than M,
        // i.e. the Poke Mon does not have enough power to reach the next target.

        //Every time you subtract M from N that means you’ve reached a target and poked it successfully.
        // COUNT how many targets you’ve poked – you’ll need that count.

        //The Poke Mon becomes gradually more exhausted.
        // IF N becomes equal to EXACTLY 50 % of its original value, you must divide N by Y, if it is POSSIBLE.
        // This DIVISION is between integers.
        //If a division is not possible, you should NOT do it.
        // Instead, you should continue subtracting.
        //After dividing, you should continue subtracting from N, until it becomes less than M.

        //When N becomes less than M, you must take what has remained of N and the count of targets you’ve poked,
        // and print them as output.

        //Output
        //•	The output consists of 2 lines.
        //•	On the first line print what has remained of N, after subtracting from it.
        //•	On the second line print the count of targets, you’ve managed to poke.

        int N = Integer.parseInt (scanner.nextLine());
        int M = Integer.parseInt (scanner.nextLine());
        int Y = Integer.parseInt (scanner.nextLine());

        int originalValueOfN = N;
        int pokedTargets = 0;

        while (N>=M) {
            N-=M;
            pokedTargets++;
            if (N == originalValueOfN /2) {
                N /= Y;
            }
        }

        System.out.println(N);
        System.out.println(pokedTargets);

    }
}

