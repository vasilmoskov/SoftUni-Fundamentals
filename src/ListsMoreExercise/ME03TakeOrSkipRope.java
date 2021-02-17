package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03TakeOrSkipRope {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Input
        //The encrypted message as a string

        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < text.size(); i++) {
            if (Character.isDigit(text.get(i).charAt(0))) {
                numbers.add(Integer.parseInt(text.get(i)));
                text.remove(i);
                i--;
            }
        }

        //Let’s take the string “skipTest_String044170” as an example.
        //Take every digit from the string and store it somewhere.
        // After that, remove all the digits from the string.
        // After this operation, you should have two lists of items: the numbers list and the non-numbers list:
        //•	Numbers list: [0, 4, 4, 1, 7, 0]
        //•	Non-numbers: [s, k, i, p, T, e, s, t, _, S, t, r, i, n, g]

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }

        //After that, take every digit in the numbers list and split it up into a take list and a skip list,
        // depending on whether the digit is in an even or an odd index:
        //•	Numbers list: [0, 4, 4, 1, 7, 0]
        //•	Take list: [0, 4, 7]
        //•	Skip list: [4, 1, 0]

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < takeList.size(); i++) {

            int j = 0;

            int numbersToBeAdded = takeList.get(i);

            while (j < numbersToBeAdded) {
                word.append(text.get(j));
                text.remove(j);
                numbersToBeAdded--;
                if (text.isEmpty()){
                    break;
                }
            }

            int numbersToBeSkipped = skipList.get(i);

            while (j < numbersToBeSkipped) {
                if (text.isEmpty()){
                    break;
                }
                text.remove(j);
                numbersToBeSkipped--;
            }
        }

        System.out.println(word);

        //Afterwards, iterate over both of the lists and skip {skipCount} characters from the non-numbers list,
        // then take {takeCount} characters and store it in a result string.
        // Note that the skipped characters are summed up as they go.
        // The process would look like this on the aforementioned non-numbers list:
        //Example: "skipTest_String"
        //1.	Take 0 characters  Taken: "", skip 4 characters  Skipped: "skip" Result: ""
        //2.	Take 4 characters Taken: "Test", skip 1 characters  Skipped: "_"  Result: "Test"
        //3.	Take 7 characters Taken: "String", skip 0 characters  Skipped: ""  Result: "TestString"

        //After that, just print the result string on the console.

        //Output
        //The decrypted message as a string

        //Constraints
        //•	The count of digits in the input string will always be even.
        //•	The encrypted message will contain any printable ASCII character.
    }
}
