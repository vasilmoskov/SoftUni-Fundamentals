package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt (scanner.nextLine());
        int capacity = Integer.parseInt (scanner.nextLine());

        int courses = people / capacity;
        int coursesWithoutFullCapacity = people % capacity;

        if (coursesWithoutFullCapacity!=0) {
            courses++;
        }

        System.out.println(courses);

    }
}
