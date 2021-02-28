package ProgrammingFundamentalsMidExams;

import java.util.Arrays;
import java.util.Scanner;

public class EX03R02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        String input = scanner.nextLine();


        while (!input.equals("End")) {
            int indexOfCurrentTarget = Integer.parseInt(input);

            if (indexOfCurrentTarget >= 0 && indexOfCurrentTarget < targets.length) {
                if (targets[indexOfCurrentTarget] != -1) {
                    for (int i = 0; i < targets.length; i++) {
                        if (i != indexOfCurrentTarget) {
                            if (targets[i] > targets[indexOfCurrentTarget] && targets[i] != -1) {
                                targets[i] -= targets[indexOfCurrentTarget];
                            } else if (targets[i] <= targets[indexOfCurrentTarget] && targets[i] != -1) {
                                targets[i] += targets[indexOfCurrentTarget];
                            }
                        }
                    }
                    targets[indexOfCurrentTarget] = -1;
                }
            }

            input = scanner.nextLine();
        }

        int countShotTargets = 0;
        for (int target : targets) {
            if (target == -1) {
                countShotTargets++;
            }
        }

        System.out.printf("Shot targets: %d -> ", countShotTargets);
        for (int target : targets) {
            System.out.print(target + " ");
        }

    }
}
