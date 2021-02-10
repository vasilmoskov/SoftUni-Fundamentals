package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class E11ArrayManipulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandAsArray = command.split(" ");

            if (commandAsArray[0].equals("exchange")) {
                int exchangeIndex = Integer.parseInt(commandAsArray[1]);
                exchangeIndexes(array, exchangeIndex);
            } else if (commandAsArray[0].equals("max")) {
                String numberType = commandAsArray[1];
                printIndexOfMax(array, numberType);
            } else if (commandAsArray[0].equals("min")) {
                String numberType = commandAsArray[1];
                printIndexOfMin(array, numberType);
            } else if (commandAsArray[0].equals("first")) {
                int count = Integer.parseInt(commandAsArray[1]);
                String numberType = commandAsArray[2];
                printFirst(array, count, numberType);
            } else if (commandAsArray[0].equals("last")) {
                int count = Integer.parseInt(commandAsArray[1]);
                String numberType = commandAsArray[2];
                printLast(array, count, numberType);
            }
            command = scanner.nextLine();

            //•	end – stop taking input and print the final state of the array.
        }
        System.out.println(Arrays.toString(array));
    }


    public static int[] exchangeIndexes(int[] array, int exchangeIndex) {

        //•	exchange {index} – splits the array after the given index and exchanges the places of the two resulting subarrays.
        // E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
        //o	If the index is outside the boundaries of the array, print "Invalid index".

        if (exchangeIndex >= array.length || exchangeIndex < 0) {
            System.out.println("Invalid index");
        } else {
            int[] subArrayBeforeExchangeIndex = new int[exchangeIndex + 1];
            for (int i = 0; i < subArrayBeforeExchangeIndex.length; i++) {
                subArrayBeforeExchangeIndex[i] = array[i];
            }

            int[] subArrayAfterExchangeIndex = new int[array.length - 1 - exchangeIndex];
            for (int i = 0; i < subArrayAfterExchangeIndex.length; i++) {
                subArrayAfterExchangeIndex[i] = array[i + exchangeIndex + 1];
            }

            for (int i = 0; i < array.length; i++) {
                if (i < subArrayAfterExchangeIndex.length) {
                    array[i] = subArrayAfterExchangeIndex[i];
                } else {
                    array[i] = subArrayBeforeExchangeIndex[i - subArrayAfterExchangeIndex.length];
                }
            }
        }
        return array;
    }

    //•	max even/odd– returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
    //•	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
    //o	If there are two or more equal min/max elements, return the index of the rightmost one.
    //o	If a min/max even/odd element cannot be found, print "No matches".

    public static void printIndexOfMax(int[] array, String numberType) {
        int max = Integer.MIN_VALUE;
        int indexOfMax = Integer.MIN_VALUE;

        if (numberType.equals("odd")) {
            boolean oddFound = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 1) {
                    oddFound = true;
                    if (array[i] >= max) {
                        max = array[i];
                        indexOfMax = i;
                    }
                }
            }
            if (!oddFound) {
                System.out.println("No matches");
            } else {
                System.out.println(indexOfMax);
            }
        } else if (numberType.equals("even")) {
            boolean evenFound = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    evenFound = true;
                    if (array[i] >= max) {
                        max = array[i];
                        indexOfMax = i;
                    }
                }
            }
            if (!evenFound) {
                System.out.println("No matches");
            } else {
                System.out.println(indexOfMax);
            }
        }
    }

    public static void printIndexOfMin(int[] array, String numberType) {
        int min = Integer.MAX_VALUE;
        int indexOfMin = Integer.MIN_VALUE;

        if (numberType.equals("odd")) {
            boolean oddFound = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 1) {
                    oddFound = true;
                    if (array[i] <= min) {
                        min = array[i];
                        indexOfMin = i;
                    }
                }
            }
            if (!oddFound) {
                System.out.println("No matches");
            } else {
                System.out.println(indexOfMin);
            }
        } else if (numberType.equals("even")) {
            boolean evenFound = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    evenFound = true;
                    if (array[i] <= min) {
                        min = array[i];
                        indexOfMin = i;
                    }
                }
            }
            if (!evenFound) {
                System.out.println("No matches");
            } else {
                System.out.println(indexOfMin);
            }
        }
    }

    //•	first {count} even/odd– returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
    //•	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
    //o	If the count is greater than the array length, print "Invalid count".
    //o	If there are not enough elements to satisfy the count, print as many as you can.
    // If there are zero even/odd elements, print an empty array "[]".

    public static void printFirst(int[] array, int count, String numberType) {

        //o	If the count is greater than the array length, print "Invalid count".
        // но до валидния count ги принтирам?


        int countAddedNumbers = 0;

        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            int[] firstXNumbers = new int[count];
            if (numberType.equals("odd")) {
                for (int i = 0; i < array.length; i++) {
                    if (countAddedNumbers == count) {
                        break;
                    }
                    if (array[i] % 2 == 1) {
                        if (countAddedNumbers <= count) {
                            firstXNumbers[countAddedNumbers] = array[i];
                            countAddedNumbers++;
                        }
                    }
                }

            } else if (numberType.equals("even")) {
                for (int i = 0; i < array.length; i++) {
                    if (countAddedNumbers == count) {
                        break;
                    }
                    if (array[i] % 2 == 0) {
                        if (countAddedNumbers <= count) {
                            firstXNumbers[countAddedNumbers] = array[i];
                            countAddedNumbers++;
                        }
                    }
                }
            }

            if (countAddedNumbers == 0) {
                firstXNumbers = new int[0];
                System.out.println(Arrays.toString(firstXNumbers));
            } else if (countAddedNumbers < firstXNumbers.length) {
                int[] firstNumbersThatAreLessThanNeeded = new int[countAddedNumbers];
                for (int i = 0; i < firstNumbersThatAreLessThanNeeded.length; i++) {
                    firstNumbersThatAreLessThanNeeded[i] = firstXNumbers[i];
                }
                System.out.println(Arrays.toString(firstNumbersThatAreLessThanNeeded));
            } else {
                System.out.println(Arrays.toString(firstXNumbers));
            }
        }
    }

    public static void printLast(int[] array, int count, String numberType) {

        int countAddedNumbers = 0;

        if (count > array.length) {
            System.out.println("Invalid count");
        } else {

            int[] lastXNumbers = new int[count];
            if (numberType.equals("odd")) {
                for (int i = array.length - 1; i >= 0; i--) {
                    if (countAddedNumbers == count) {
                        break;
                    }
                    if (array[i] % 2 == 1) {
                        while (countAddedNumbers < lastXNumbers.length) {
                            lastXNumbers[countAddedNumbers] = array[i];
                            countAddedNumbers++;
                            break;
                        }
                    }
                }
            } else if (numberType.equals("even")) {
                for (int i = array.length - 1; i >= 0; i--) {
                    if (countAddedNumbers == count) {
                        break;
                    }
                    if (array[i] % 2 == 0) {
                        while (countAddedNumbers < lastXNumbers.length) {
                            lastXNumbers[countAddedNumbers] = array[i];
                            countAddedNumbers++;
                            break;
                        }
                    }
                }
            }

            if (countAddedNumbers == 0) {
                lastXNumbers = new int[0];
                System.out.println(Arrays.toString(lastXNumbers));
            } else if (countAddedNumbers < lastXNumbers.length) {
                int[] lastNumbersThatAreLessThanNeeded = new int[countAddedNumbers];
                for (int i = lastNumbersThatAreLessThanNeeded.length - 1; i >= 0; i--) {
                    lastNumbersThatAreLessThanNeeded[i] = lastXNumbers[i];
                }
                System.out.println(Arrays.toString(lastNumbersThatAreLessThanNeeded));
            } else {
                int[] lastXNumbersInCorrectOrder = new int[lastXNumbers.length];
                for (int i = 0; i < lastXNumbersInCorrectOrder.length; i++) {
                    lastXNumbersInCorrectOrder[i] = lastXNumbers[lastXNumbers.length - 1 - i];
                }
                System.out.println(Arrays.toString(lastXNumbersInCorrectOrder));
            }
        }
    }
}