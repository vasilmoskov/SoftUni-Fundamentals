package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class E02ChangeList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandAsArr = command.split("\\s+");
            String operation = commandAsArr[0];

            if ("Delete".equals(operation)) {
                int number = Integer.parseInt(commandAsArr[1]);

                numbers.removeAll(Arrays.asList(number));
                /*

                while (numbers.contains(number)) {
                    numbers.remove((Object) number);
                }

                 */

            } else if ("Insert".equals(operation)) {
                int number = Integer.parseInt(commandAsArr[1]);
                int index = Integer.parseInt(commandAsArr[2]);

                //numbers.add(index, number);


                if (index >= 0 && index <= numbers.size()) {
                    numbers.add(index, number);
                }

            }

            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }
}

