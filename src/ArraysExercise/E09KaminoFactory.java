package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class E09KaminoFactory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dnaLength = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int[] bestSequence = new int[dnaLength];

        int bestSequenceLength = -1;
        int bestSample = -1;
        int bestSequenceStartingIndex = Integer.MAX_VALUE;
        int bestSequenceSum = Integer.MIN_VALUE;

        int countSamples = 0;

        while (!input.equals("Clone them!")) {
            countSamples++;
            String[] currentSequenceAsString = input.split("!+");

            int[] currentSequence = new int[dnaLength];

            for (int i = 0; i < currentSequence.length; i++) {
                currentSequence[i] = Integer.parseInt(currentSequenceAsString[i]);
            }

            int currentSequenceStartingIndex = 0;
            int sumCurrentSequence = 0;
            int countOnes = 0;
            int currentSequenceLength = 0;

            for (int i = 0; i < currentSequence.length-1; i++) {
                sumCurrentSequence += currentSequence[i];
                if (currentSequence[i] == currentSequence[i + 1] && currentSequence[i] == 1) {
                    countOnes++;
                    if (countOnes == 1) {
                        currentSequenceStartingIndex = i;
                    }
                    currentSequenceLength = countOnes + 1;
                } else {
                    countOnes = 0;
                }

            }

            sumCurrentSequence += currentSequence [currentSequence.length-1];


            if (currentSequenceLength > bestSequenceLength) {
                bestSample = countSamples;
                bestSequenceLength = currentSequenceLength;
                bestSequenceStartingIndex = currentSequenceStartingIndex;
                bestSequenceSum = sumCurrentSequence;

                for (int i = 0; i < bestSequence.length; i++) {
                    bestSequence[i] = currentSequence[i];
                }
            } else if (currentSequenceLength == bestSequenceLength) {
                if (currentSequenceStartingIndex < bestSequenceStartingIndex) {
                    bestSample = countSamples;
                    bestSequenceStartingIndex = currentSequenceStartingIndex;
                    bestSequenceSum = sumCurrentSequence;
                    bestSequenceLength = currentSequenceLength;
                    for (int i = 0; i < bestSequence.length; i++) {
                        bestSequence[i] = currentSequence[i];
                    }
                } else if (currentSequenceStartingIndex == bestSequenceStartingIndex) {
                    if (sumCurrentSequence > bestSequenceSum) {
                        bestSample = countSamples;
                        bestSequenceSum = sumCurrentSequence;
                        bestSequenceLength = currentSequenceLength;
                        bestSequenceStartingIndex = currentSequenceStartingIndex;
                        for (int i = 0; i < bestSequence.length; i++) {
                            bestSequence[i] = currentSequence[i];
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, bestSequenceSum);
        for (int i : bestSequence) {
            System.out.print(i + " ");
        }
    }
}


/*            for (int i = 0; i < currentSequence.length; i++) {
                sumCurrentSequence += currentSequence[i];
                for (int j = i + 1; j < currentSequence.length; j++) {
                    if (currentSequence[i] == currentSequence[j] && currentSequence[i] == 1) {
                        countOnes++;
                        if (countOnes == 1) {
                            currentSequenceStartingIndex = i;
                        }
                        currentSequenceLength = countOnes + 1;
                    } else {
                        countOnes = 0;
                        currentSequenceLength=0;
                        break;
                    }
                }
            }

 */