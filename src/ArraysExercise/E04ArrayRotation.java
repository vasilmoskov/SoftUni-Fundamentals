package ArraysExercise;

import java.util.*;

public class E04ArrayRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(" ");
        int numberOfRotations = Integer.parseInt(scanner.nextLine());

        Integer[] numbers = new Integer[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        Collections.rotate(Arrays.asList(numbers), -numberOfRotations);

        System.out.println(Arrays.toString(numbers)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
    /*
    Scanner xScanner = new Scanner(System.in);
    String strArray = xScanner.nextLine();
    int[] inputArray = toIntArray(strArray);
    int numRotations = xScanner.nextInt();

    //-- Намаляме броя на ротациите, ако са повече от броя на елементите в масива
    if(numRotations >= inputArray.length)
    numRotations = numRotations % inputArray.length;

    //-- Извършваме ротациите
    for (int i = 0; i < numRotations; i++)
    rotate(inputArray);

    //-- Принтираме масива
    for (int currentElem : inputArray)
            System.out.print(currentElem + " ");
}

    private static int[] toIntArray(String strArray) {
        String[] aSplitted = strArray.split(" ");
        int[] inputArray = new int[aSplitted.length];
        for (int i = 0; i < aSplitted.length; i++) {
            inputArray[i] = Integer.parseInt(aSplitted[i]);
        }
        return inputArray;
    }

    private static void rotate(int[] arr) {
        //-- Запазваме първия елемент
        int iFirstElem = arr[0];
        //-- Преместваме всички останали едно място напред в масива
        for(int i = 1; i< arr.length; i++) {
            arr[i-1] = arr[i];
        }
        //-- Записваме първият елемент на последна позиция
        arr[arr.length-1] = iFirstElem;
    }
}
     */