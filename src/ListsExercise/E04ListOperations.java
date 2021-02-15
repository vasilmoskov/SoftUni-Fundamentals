package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class E04ListOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbersAsString = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsString.size(); i++) {
            numbers.add(Integer.parseInt(numbersAsString.get(i)));
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String [] commandAsArray = command.split(" ");
            String action = commandAsArray[0];

            if (action.equals("Add")){
                int number = Integer.parseInt(commandAsArray[1]);
                numbers.add(number);
            } else if (action.equals("Insert")) {
                int number = Integer.parseInt(commandAsArray[1]);
                int index = Integer.parseInt(commandAsArray[2]);
                if (index>=0 && index<numbers.size()) {
                    numbers.add(index,number);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (action.equals("Remove")) {
                int index = Integer.parseInt(commandAsArray[1]);
                if (index>=0 && index<numbers.size()) {
                    numbers.remove(index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (action.equals("Shift")) {
                String direction = commandAsArray[1];
                int distance = Integer.parseInt(commandAsArray[2]);
                if (direction.equals("right")) {
                    Collections.rotate(numbers, distance);
                } else if (direction.equals("left")) {
                    Collections.rotate(numbers, -distance);
                }
            }

            command= scanner.nextLine();
        }

        for (int number:numbers) {
            System.out.print(number+" ");
        }
    }
}
