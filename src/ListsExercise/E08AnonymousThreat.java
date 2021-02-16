package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08AnonymousThreat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        int countRemovedIndexes = 0;


        while (!command.equals("3:1")) {
            String[] commandAsArr = command.split(" ");
            String operation = commandAsArr[0];

            if (operation.equals("merge")) {
                int startIndex = Integer.parseInt(commandAsArr[1]);
                int endIndex = Integer.parseInt(commandAsArr[2]);

                boolean validIndex = false;

                /*

                startIndex -=countRemovedIndexes;
                endIndex -=countRemovedIndexes;

                countRemovedIndexes = 0;

                 */

                if (startIndex<0) {
                    startIndex = 0;
                }




                StringBuilder newWord = new StringBuilder();

                for (int i = startIndex; i <= endIndex; i++) {
                    if (i < input.size()) {
                        newWord.append(input.get(i));
                    }
                }

                while (startIndex < input.size() && startIndex <= endIndex) {
                    input.remove(startIndex);
                    //countRemovedIndexes++;
                    endIndex--;
                    validIndex = true;
                }

               // countRemovedIndexes--;

                if (validIndex) {
                    input.add(startIndex, String.valueOf(newWord));
                }


            } else if (operation.equals("divide")) {
                int index = Integer.parseInt(commandAsArr[1]);
                int partitions = Integer.parseInt(commandAsArr[2]);

                int indexToPutNewWordOn = index + 1;

                String word = input.get(index);
                int lengthOfEachNewWord = word.length() / partitions;

                int repetitions = partitions;
                int restCharactersOfTheWord = word.length() % partitions;
                int currentRepetition = 0;
                boolean lastRepetition = false;

                for (int i = 0; i < word.length(); i += lengthOfEachNewWord) {
                    currentRepetition++;
                    StringBuilder newWord = new StringBuilder();

                    for (int j = i; j < i + lengthOfEachNewWord; j++) {
                        newWord.append(word.charAt(j));
                    }


                    if (currentRepetition == repetitions && restCharactersOfTheWord != 0) {
                        int restStartsAtIndex = word.length() - restCharactersOfTheWord;
                        for (int j = restStartsAtIndex; j < word.length(); j++) {
                            newWord.append(word.charAt(j));
                        }
                        lastRepetition = true;
                    }

                    input.add(indexToPutNewWordOn, String.valueOf(newWord));
                    indexToPutNewWordOn++;

                    if (lastRepetition) {
                        break;
                    }

                }

                input.remove(index);

            }

            command = scanner.nextLine();
        }

        //System.out.println(input.toString().replaceAll("[\\[\\],]", ""));

        System.out.println(String.join(" ", input));

    }
}

